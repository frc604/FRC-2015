package com._604robotics.robotnik.logging;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * The Class Logger.
 */
public class Logger {
    
    /**
     * Log.
     *
     * @param message the message
     */
    public static void log (String message) {
        record(System.out, "[INFO] " + message);
    }
    
    /**
     * Warn.
     *
     * @param message the message
     */
    public static void warn (String message) {
        record(System.err, "[WARN] " + message);
        trace(new Exception());
    }
    
    /**
     * Error.
     *
     * @param message the message
     * @param ex the ex
     */
    public static void error (String message, Exception ex) {
        record(System.err, "[ERROR] " + message + ": (" + ex.getClass().getName() + ") " + ex.getMessage());
        trace(ex);
    }
    
    /**
     * Record.
     *
     * @param std the std
     * @param message the message
     */
    private static void record (PrintStream std, String message) {
        final String line = "(" + System.currentTimeMillis() + " ms) " + message;
        
        std.println(line);
        if (logFile != null) logFile.println(line);
    }
    
    /**
     * Trace.
     *
     * @param ex the ex
     */
    private static void trace (Exception ex) {
        ex.printStackTrace();
        if (logFile != null) logFile.println(ex.toString());
    }
    
    /** The Constant logFile. */
    private static final PrintStream logFile;
    
    static {
        PrintStream result = null;
        Exception error = null;
        /*
        try {
            final FileConnection file = (FileConnection) Connector.open("file:///robotnik.log", Connector.WRITE);
            if (!file.exists())
                file.create();
            
            result = null; new PrintStream(file.openOutputStream(file.fileSize()));
        } catch (IOException ex) {
            error = ex;
        }*/
        
        logFile = result;
        
        if (error != null)
            error("Could not open log file", error);
        else
            log("Recording to log file \"robotnik.log\" on cRIO; session ID = "
                    + new Random().nextInt());
    }
}
