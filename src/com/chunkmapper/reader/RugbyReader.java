package com.chunkmapper.reader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collection;

import com.chunkmapper.chunk.Chunk;
import com.chunkmapper.downloader.OSMDownloader;
import com.chunkmapper.enumeration.OSMSource;
import com.chunkmapper.sections.POI;

public class RugbyReader {
	private final Collection<POI> pois;
	public RugbyReader(int regionx, int regionz) throws URISyntaxException, IOException {
		pois = (Collection<POI>) OSMDownloader.getSections(OSMSource.poi, regionx, regionz);
	}
	public static class RugbyField {
		public final String name;
		public RugbyField(String name) {
			this.name = name;
		}
	}
	public RugbyField getRugbyField(Chunk chunk) {
		for (POI poi : pois) {
			boolean poiIsRugby = poi.type.equals("rugby") || poi.type.equals("rugby_league")
					|| poi.type.equals("rugby_union");
			if (poiIsRugby && chunk.x0 <= poi.point.x && poi.point.x < chunk.x0 + 16
					&& chunk.z0 <= poi.point.z && poi.point.z < chunk.z0 + 16) {
				return new RugbyField(poi.text);
			}
		}
		return null;
	}

}