package com._604robotics.robotnik.prefabs.trigger;

import com._604robotics.robotnik.trigger.TriggerAccess;

/**
 * An always-active trigger.
 */
public class TriggerAlways implements TriggerAccess {
    private TriggerAlways () {}

    private static final TriggerAccess INSTANCE = new TriggerAlways();

    /**
     * Gets the TriggerAlways instance.
     * @return The TriggerAlways instance.
     */
    public static TriggerAccess getInstance () {
        return INSTANCE;
    }
    
    @Override
    public boolean get () {
        return true;
    }
}