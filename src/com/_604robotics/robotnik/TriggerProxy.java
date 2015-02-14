package com._604robotics.robotnik;

import com._604robotics.robotnik.logging.InternalLogger;
import com._604robotics.robotnik.trigger.TriggerReference;

// TODO: Auto-generated Javadoc
/**
 * The Class TriggerProxy.
 */
public class TriggerProxy {
    
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
     * @param triggerName the trigger name
     * @param trigger the trigger
     */
    public static void update (String moduleName, String triggerName, TriggerReference trigger) {
        if (active) {
            try {
                trigger.update();
            } catch (Exception ex) {
                InternalLogger.caught(moduleName, "Trigger", triggerName, "run", ex);
            }
        } else {
            trigger.update();
        }
    }
}
