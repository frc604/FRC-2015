package com._604robotics.robotnik.logging;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Logs information to the console.
 */
public class Logger {
	private static final SimpleDateFormat LOG_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static final SimpleDateFormat LOG_FILE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
	
	private static PrintStream LOG_FILE = null;
	private static FileOutputStream logFileOutput = null;
	
	static Thread closeHandles = null;
	
	private static boolean isClosed = false;
	
	static {
		try {
			String fileName = "robotnik_" + LOG_FILE_DATE_FORMAT.format(new Date()) + ".log";
			File file = new File("/home/lvuser/"+fileName);
			if(!file.exists() && !file.createNewFile()) {
				warn("Could not create log file.");
			}
			
			logFileOutput = new FileOutputStream(file);
			LOG_FILE = new PrintStream(logFileOutput);
			log("Recording to log file \"" + fileName + "\" on cRIO");
			log("Full path is "+file.getAbsolutePath());
		} catch(IOException e) {
			error("Could not open log file.", e);
		}
		closeHandles = new Thread()
		{
			public void run()
			{
				if (!isClosed)
				{
					try {
						warn("Closing log file now; further writes to the log file will fail");
						logFileOutput.flush();
						logFileOutput.close();
						LOG_FILE.flush();
						LOG_FILE.close();
						isClosed=true;
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else
				{
					System.err.println("Logfile is already closed!");
				}
			}
		};
		Runtime.getRuntime().addShutdownHook(closeHandles);
	}
	
	/**
	 * Logs a missing component.
	 * @param type Type of the component.
	 * @param name Name of the component.
	 */
	public static void missing (String type, String name) {
		warn("Missing " + type + " - " + name);
	}

	/**
	 * Logs information.
	 * @param message Message to log.
	 */
	public static void log (String message) {
		record(System.out, "[INFO] " + message);
	}

	/**
	 * Logs a warning.
	 * @param message Message to log.
	 */
	public static void warn (String message) {
		record(System.err, "[WARN] " + message);
		//trace(new Exception());
	}

	/**
	 * Logs an error.
	 * @param message Message to log.
	 * @param ex Exception to log.
	 */
	public static void error (String message, Exception ex) {
		record(System.err, "[ERROR] " + message + ": (" + ex.getClass().getName() + ") " + ex.getMessage());
		trace(ex);
	}

	private static void record (PrintStream std, String message) {
		final String line = "(" + LOG_DATE_FORMAT.format(new Date()) + ") " + message;
		
		std.println(line);
		if (LOG_FILE != null) LOG_FILE.println(line);
	}

	private static void trace (Exception ex) {
		ex.printStackTrace();
		if (LOG_FILE != null) LOG_FILE.println(ex.toString());
	}
}
