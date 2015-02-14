package com._604robotics.robotnik.logging;

// TODO: Auto-generated Javadoc
/**
 * The Class InternalLogger.
 */
public class InternalLogger {
    
    /**
     * Missing.
     *
     * @param type the type
     * @param name the name
     */
    public static void missing (String type, String name) {
        Logger.warn("Missing " + type + " - " + name);
    }
    
    /**
     * Caught.
     *
     * @param moduleName the module name
     * @param type the type
     * @param name the name
     * @param step the step
     * @param ex the ex
     */
    public static void caught (String moduleName, String type, String name, String step, Exception ex) {
        Logger.error("Caught error while in step " + step + " of " + type + " " + name + " of module " + moduleName, ex);
    }
}
