package com.chunkmapper;

import java.io.DataOutputStream;
import java.io.File;
import java.io.PrintStream;

import net.minecraft.world.level.chunk.storage.RegionFile;

import org.apache.commons.io.FileUtils;

import com.chunkmapper.chunk.Chunk;
import com.chunkmapper.enumeration.Blocka;
import com.chunkmapper.writer.GenericWriter;
import com.chunkmapper.writer.HorseWriter;
import com.chunkmapper.writer.LoadedLevelDat;
import com.chunkmapper.writer.MobWriter;
import com.mojang.nbt.NbtIo;

public class CreateNaked {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		File gameFolder = new File("/Users/matthewmolloy/Library/Application Support/minecraft/saves/naked");
//		FileUtils.deleteDirectory(gameFolder);
		File src = new File("resources/level.dat");
		File regionFolder = new File(gameFolder, "region");
		regionFolder.mkdirs();
		File loadedLevelDatFile = new File("/Users/matthewmolloy/Library/Application Suppport/minecraft/saves/naked/level.dat");
		FileUtils.copyFile(src, loadedLevelDatFile);
		LoadedLevelDat loadedLevelDat = new LoadedLevelDat(loadedLevelDatFile);
		loadedLevelDat.setName("naked");
		loadedLevelDat.setPlayerPosition(12, 6, 12);
		loadedLevelDat.save();
		RegionFile regionFile = new RegionFile(new File(regionFolder, "r.0.0.mca"));
		int[][] heights = new int[24][24];
		for (int i = 0; i < 24; i++) {
			for (int j = 0; j < 24; j++) {
				heights[i][j] = 4;
			}
		}
		for (int chunkx = 0; chunkx < 32; chunkx += 2) {
			for (int chunkz = 0; chunkz < 32; chunkz += 2) {
				Chunk chunk = new Chunk(chunkx, chunkz, heights, chunkx, chunkz);
				for (int y = 0; y < 4; y++) {
					for (int z = 0; z < 16; z++) {
						for (int x = 0; x < 16; x++) {
							chunk.Blocks[y][z][x] = Blocka.Grass;
						}
					}
				}

				DataOutputStream out = regionFile.getChunkDataOutputStream(chunkx, chunkz);
				NbtIo.write(chunk.getTag(), out);
				out.close();
			}
		}
		regionFile.close();

		System.out.println("done");

	}


}