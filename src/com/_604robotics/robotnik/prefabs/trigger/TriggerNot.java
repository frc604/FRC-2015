package com._604robotics.robotnik.prefabs.trigger;

import com._604robotics.robotnik.trigger.TriggerAccess;

// TODO: Auto-generated Javadoc
/**
 * The Class TriggerNot.
 */
public class TriggerNot implements TriggerAccess {
    
    /** The trigger. */
    private final TriggerAccess trigger;
    
    /**
     * Instantiates a new trigger not.
     *
     * @param trigger the trigger
     */
    public TriggerNot (TriggerAccess trigger) {
        this.trigger = trigger;
    }
    
    /* (non-Javadoc)
     * @see com._604robotics.robotnik.trigger.TriggerAccess#get()
     */
    public boolean get () {
        return !this.trigger.get();
    }
}