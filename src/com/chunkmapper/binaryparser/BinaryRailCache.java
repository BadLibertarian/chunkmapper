package com.chunkmapper.binaryparser;

import com.chunkmapper.Point;
import java.awt.Rectangle;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import com.chunkmapper.FileValidator;
import com.chunkmapper.Utila;
import com.chunkmapper.downloader.SynchronousDownloader;
import com.chunkmapper.protoc.FileContainer.FileInfo;
import com.chunkmapper.protoc.RailRegionContainer.RailRegion;
import com.chunkmapper.protoc.PointContainer;
import com.chunkmapper.protoc.RailSectionContainer;
import com.chunkmapper.protoc.RectangleContainer;
import com.chunkmapper.protoc.ServerInfoContainer.ServerInfo;
import com.chunkmapper.protoc.admin.ServerInfoManager;
import com.chunkmapper.rail.RailSection;

public class BinaryRailCache {
	private SynchronousDownloader downloader = new SynchronousDownloader();
	
	public ArrayList<RailSection> getSections(FileInfo info2) throws IOException, URISyntaxException {
		File CACHE = new File(Utila.CACHE, "myrails");
		File cacheFile = new File(CACHE, info2.getFile());
		
		byte[] data;
		
		if (FileValidator.checkValid(cacheFile)) {
			DataInputStream in = new DataInputStream(new FileInputStream(cacheFile));
			data = new byte[(int) cacheFile.length()];
			in.readFully(data);
			in.close();
		} else {
			ServerInfo info = ServerInfoManager.serverInfo;
			String address = info.getRailAddress() + "data/" + info2.getParent() + info2.getFile();
			data = downloader.downloadToFile(address, cacheFile);
		}
		
		RailRegion railRegion = RailRegion.parseFrom(data);
		ArrayList<RailSection> out = new ArrayList<RailSection>();
		
		for (RailSectionContainer.RailSection rawRailSection : railRegion.getRailSectionsList()) {
			ArrayList<Point> points = new ArrayList<Point>();
			for (PointContainer.Point rawPoint : rawRailSection.getPointsList()) {
				points.add(new Point(rawPoint.getX(), rawPoint.getZ()));
			}
			RectangleContainer.Rectangle rawBbox = rawRailSection.getBbox();
			Rectangle bbox = new Rectangle(rawBbox.getX(), rawBbox.getZ(), rawBbox.getWidth(), rawBbox.getHeight());
			out.add(new RailSection(points, rawRailSection.getIsPreserved(), rawRailSection.getHasBridge(),
					rawRailSection.getHasCutting(), rawRailSection.getHasEmbankment(), rawRailSection.getHasTunnel(),
					bbox)); 
		}
		return out;
	}

	public void shutdown() {
		downloader.shutdown();
		
	}

}