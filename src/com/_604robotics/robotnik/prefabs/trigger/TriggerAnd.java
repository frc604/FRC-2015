package com._604robotics.robotnik.prefabs.trigger;

import com._604robotics.robotnik.trigger.TriggerAccess;

// TODO: Auto-generated Javadoc
/**
 * The Class TriggerAnd.
 */
public class TriggerAnd implements TriggerAccess {
    
    /** The triggers. */
    private final TriggerAccess[] triggers;
    
    /**
     * Instantiates a new trigger and.
     *
     * @param triggers the triggers
     */
    public TriggerAnd (TriggerAccess[] triggers) {
        this.triggers = triggers;
    }
    
    /* (non-Javadoc)
     * @see com._604robotics.robotnik.trigger.TriggerAccess#get()
     */
    public boolean get () {
        boolean value = true;
        
        for (int i = 0; i < this.triggers.length; i++) {
            value = this.triggers[i].get() && value;
        }
        
        return value;
    }
}