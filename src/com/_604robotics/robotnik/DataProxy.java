package com._604robotics.robotnik;

import com._604robotics.robotnik.data.DataReference;
import com._604robotics.robotnik.logging.InternalLogger;

// TODO: Auto-generated Javadoc
/**
 * The Class DataProxy.
 */
public class DataProxy {
    
    /** The active. */
    private static boolean active = true;
    
    /**
     * Disable.
     */
    protected static void disable () { active = false; }
    
    /**
     * Update.
     *
     * @param moduleName the module name
     * @param dataName the data name
     * @param data the data
     */
    public static void update (String moduleName, String dataName, DataReference data) {
        if (active) {
            try {
                data.update();
            } catch (Exception ex) {
                InternalLogger.caught(moduleName, "Data", dataName, "run", ex);
            }
        } else {
            data.update();
        }
    }
}
