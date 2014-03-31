package com.chunkmapper.admin;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class MyLogger {
	public static final Logger LOGGER = Logger.getLogger("");
	private static final boolean[] specialFlags = new boolean[SpecialLog.values().length];
	
	public static enum SpecialLog { CONTROLS(0), GLOBE(1);
		public final int val;
		private SpecialLog(int val) {
			this.val = val;
		}
	}
	
	public static void specialLog(SpecialLog l) {
		if (!specialFlags[l.val]) {
			LOGGER.info(l.toString());
			specialFlags[l.val] = true;
		}
	}

	static {
		LOGGER.addHandler(FeedbackManager.streamHandler);
		if (Utila.isMatt()) {
			try {
				FileHandler h = new FileHandler("logging.txt");
				h.setFormatter(new SimpleFormatter());
				LOGGER.addHandler(h);

			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			LOGGER.setLevel(Level.CONFIG);
		} else {
			LOGGER.setLevel(Level.INFO);
		}
		LOGGER.info(LOGGER.getLevel().toString());
	}
	public static void deleteLog() {
		(new File("logging.txt")).delete();
	}

	public static String printException(Throwable t) {
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		PrintStream s = new PrintStream(b);
		t.printStackTrace(s);
		return b.toString();
	}
	public static void throwException() throws Exception {
		throw new Exception();
	}
	public static void main(String[] args) {
		System.out.println(LOGGER.getLevel());
	}

}