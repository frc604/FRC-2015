package com._604robotics.robotnik;

import com._604robotics.robotnik.action.ActionReference;
import com._604robotics.robotnik.logging.InternalLogger;

// TODO: Auto-generated Javadoc
/**
 * The Class ActionProxy.
 */
public class ActionProxy {
    
    /** The active. */
    private static boolean active = true;
    
    /**
     * Disable.
     */
    protected static void disable () { active = false; }
    
    /**
     * Begin.
     *
     * @param moduleName the module name
     * @param actionName the action name
     * @param action the action
     */
    public static void begin (String moduleName, String actionName, ActionReference action) {
        if (active) {
            try {
                action.begin();
            } catch (Exception ex) {
                InternalLogger.caught(moduleName, "Action", actionName, "begin", ex);
            }
        } else {
            action.begin();
        }
    }
    
    /**
     * Run.
     *
     * @param moduleName the module name
     * @param actionName the action name
     * @param action the action
     */
    public static void run (String moduleName, String actionName, ActionReference action) {
        if (active) {
            try {
                action.run();
            } catch (Exception ex) {
                InternalLogger.caught(moduleName, "Action", actionName, "run", ex);
            }
        } else {
            action.run();
        }
    }
    
    /**
     * End.
     *
     * @param moduleName the module name
     * @param actionName the action name
     * @param action the action
     */
    public static void end (String moduleName, String actionName, ActionReference action) {
        if (active) {
            try {
                action.end();
            } catch (Exception ex) {
                InternalLogger.caught(moduleName, "Action", actionName, "end", ex);
            }
        } else {
            action.end();
        }
    }
}
