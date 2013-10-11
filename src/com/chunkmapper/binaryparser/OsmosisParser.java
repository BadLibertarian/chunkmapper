package com.chunkmapper.binaryparser;

import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.DataFormatException;

import com.chunkmapper.Point;
import com.chunkmapper.Zip;
import com.chunkmapper.admin.BucketInfo;
import com.chunkmapper.parser.Nominatim;
import com.chunkmapper.parser.OverpassObject;
import com.chunkmapper.parser.OverpassObject.Node;
import com.chunkmapper.parser.OverpassObject.Relation;
import com.chunkmapper.parser.OverpassObject.Way;
import com.chunkmapper.parser.OverpassParser;
import com.chunkmapper.protoc.OSMContainer;
import com.chunkmapper.protoc.admin.ProtocPrinter;

public class OsmosisParser {
	public static final int NODE = 0, WAY = 1, RELATION = 2;
	private static final ConcurrentHashMap<Point, OverpassObject> cache = new ConcurrentHashMap<Point, OverpassObject>();
	private static final HashMap<URL, URL> lockMap = new HashMap<URL, URL>();
	private static Object masterLock = new Object();
		private static final ConcurrentHashMap<URL, FileContents> cache2 = new ConcurrentHashMap<URL, FileContents>();
	private static ArrayList<Rectangle> rectangles;
	private static Object key = new Object();

	private static URL getLock(URL url) {
		synchronized(masterLock) {
			if (lockMap.containsKey(url)) {
				return lockMap.get(url);
			} else {
				lockMap.put(url, url);
				return url;
			}
		}
	}

	public static OverpassObject getObject(int regionx, int regionz) throws IOException, InterruptedException, DataFormatException {
		Point p = new Point(regionx, regionz);
		if (cache.containsKey(p)) {
			return cache.get(p);
		} else {
			OverpassObject o = doGetObject(regionx, regionz);
			cache.put(p, o);
			return o;
		}
	}

	private static OverpassObject doGetObject(int regionx, int regionz) throws IOException, InterruptedException, DataFormatException {
		FileContents contents = getFileContents(regionx, regionz);
		OverpassObject out = new OverpassObject();
		for (OSMContainer.Node rawNode : contents.nodes) {
			Node node = new Node(new Point(rawNode.getX(), rawNode.getZ()), rawNode.getId());
			Iterator<String> ki = rawNode.getKeysList().iterator(), vi = rawNode.getValsList().iterator();
			while (ki.hasNext()) {
				node.map.put(ki.next(), vi.next());
			}
			out.nodes.add(node);
		}
		HashMap<Long, Way> wayMap = new HashMap<Long, Way>();
		for (OSMContainer.Way rawWay : contents.ways) {
			Way way = new Way(rawWay.getId());
			Iterator<String> ki = rawWay.getKeysList().iterator(), vi = rawWay.getValsList().iterator();
			while (ki.hasNext()) {
				way.map.put(ki.next(), vi.next());
			}
			Point rootPoint = null;
			Iterator<Integer> xi = rawWay.getXsList().iterator(), zi = rawWay.getZsList().iterator();
			while(xi.hasNext()) {
				Point p = new Point(xi.next(), zi.next());
				if (rootPoint == null) {
					rootPoint = p;
					way.points.add(p);
				} else {
					way.points.add(new Point(p.x + rootPoint.x, p.z + rootPoint.z));
				}
			}
			way.calculateBbox();
			wayMap.put(rawWay.getId(), way);
			out.ways.add(way);
		}
		for (OSMContainer.Relation rawRelation : contents.relations) {
			Relation relation = new Relation(rawRelation.getId());
			Iterator<String> ki = rawRelation.getKeysList().iterator(), vi = rawRelation.getValsList().iterator();
			while (vi.hasNext()) {
				relation.map.put(ki.next(), vi.next());
			}
			for (long id : rawRelation.getWaysList()) {
				Way way = wayMap.get(id);
				if (way != null) {
					relation.ways.add(way);
				}
			}
			relation.calculateBbox();
			out.relations.add(relation);
		}
		return out;
	}

	private static void setRectangles() throws InterruptedException {
		synchronized(key) {
			while (rectangles == null) {
				rectangles = getRectangles();
				if (rectangles == null)
					Thread.sleep(1000);
			}
		}
	}
	private static ArrayList<Rectangle> getRectangles() {
		try {
			URL url = new URL("http://chunkbackend.appspot.com/static/osm.txt");
			//			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			BufferedReader br = new BufferedReader(new FileReader(new File("/Users/matthewmolloy/python/webstore/static/osm.txt")));
			ArrayList<Rectangle> out = new ArrayList<Rectangle>();
			String line;
			while ((line = br.readLine()) != null) {
				if (line.startsWith("f_")) {
					String[] split = line.split("_");

					int x = Integer.parseInt(split[1]), z = Integer.parseInt(split[2]);
					int width = Integer.parseInt(split[3]), height = Integer.parseInt(split[4]);
					out.add(new Rectangle(x, z, width, height));
				}
			}
			return out;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public static void main(String[] args) throws Exception {
		//		checkPlace("new plymouth, nz");
		//		checkPlace("sydney");
		//		checkPlace("brisbane");
		checkPlace("london");
	}
	private static void checkPlace(String place) throws MalformedURLException, URISyntaxException, IOException, InterruptedException, DataFormatException {
		System.out.println("checking " + place);
		double[] latlon = Nominatim.getPoint(place);
		int regionx = (int) Math.floor(latlon[1] * 3600 / 512);
		int regionz = (int) Math.floor(-latlon[0] * 3600 / 512);
		System.out.println(getObject(regionx, regionz));
		//		FileContents fileContents = getFileContents(regionx, regionz);
		//		System.out.println(fileContents);
		//		for (OSMContainer.Relation relation : fileContents.relations) {
		//			ProtocPrinter.PrintRelation(relation);
		//		}
		System.out.println(OverpassParser.getObject(regionx, regionz));
		System.out.println("***");
	}
	private static FileContents getFileContents(int regionx, int regionz) throws IOException, InterruptedException, DataFormatException {

		setRectangles();
		FileContents out = new FileContents();
		int x = regionx * 512, z = regionz * 512;
		Rectangle myRectangle = new Rectangle(x, z, 512, 512);
		String rootAddress = BucketInfo.getBucket("chunkmapper-osm2") + "/f_";
		for (Rectangle r : rectangles) {
			if (myRectangle.intersects(r)) {
				URL url = new URL(rootAddress + r.x + "_" + r.y + "_" + r.width + "_" + r.height);
				
				out.append(readFile(url));
			}
		}
		return out;
	}

	private static FileContents readFile(URL url) throws IOException, DataFormatException {
		synchronized(getLock(url)) {
			if (cache2.containsKey(url)) {
				return cache2.get(url);
			}
			System.out.println(url);
			FileContents out = new FileContents();

			DataInputStream in = new DataInputStream(new ByteArrayInputStream(Zip.inflate(url.openStream())));
			try {
				while(true) {
					byte type = in.readByte();
					int len = in.readInt();
					byte[] data = new byte[len];
					in.readFully(data);

					switch(type) {
					case NODE:
						out.nodes.add(OSMContainer.Node.parseFrom(data));
						break;
					case WAY:
						out.ways.add(OSMContainer.Way.parseFrom(data));
						break;
					case RELATION:
						out.relations.add(OSMContainer.Relation.parseFrom(data));
						break;
					}
				}
			} catch (EOFException e) {

			}
			in.close();
			cache2.put(url, out);
			return out;
		}
	}

}
