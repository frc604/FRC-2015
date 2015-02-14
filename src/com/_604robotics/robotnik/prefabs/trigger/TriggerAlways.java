package com._604robotics.robotnik.prefabs.trigger;

import com._604robotics.robotnik.trigger.TriggerAccess;

// TODO: Auto-generated Javadoc
/**
 * The Class TriggerAlways.
 */
public class TriggerAlways implements TriggerAccess {
    
    /**
     * Instantiates a new trigger always.
     */
    private TriggerAlways () {}
    
    /** The Constant instance. */
    private static final TriggerAccess instance = new TriggerAlways();
    
    /**
     * Gets the single instance of TriggerAlways.
     *
     * @return single instance of TriggerAlways
     */
    public static TriggerAccess getInstance () {
        return instance;
    }
    
    /* (non-Javadoc)
     * @see com._604robotics.robotnik.trigger.TriggerAccess#get()
     */
    public boolean get () {
        return true;
    }
}