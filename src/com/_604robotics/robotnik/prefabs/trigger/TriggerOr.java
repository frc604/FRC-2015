package com._604robotics.robotnik.prefabs.trigger;

import com._604robotics.robotnik.trigger.TriggerAccess;

// TODO: Auto-generated Javadoc
/**
 * The Class TriggerOr.
 */
public class TriggerOr implements TriggerAccess {
    
    /** The triggers. */
    private final TriggerAccess[] triggers;
    
    /**
     * Instantiates a new trigger or.
     *
     * @param triggers the triggers
     */
    public TriggerOr (TriggerAccess[] triggers) {
        this.triggers = triggers;
    }
    
    /* (non-Javadoc)
     * @see com._604robotics.robotnik.trigger.TriggerAccess#get()
     */
    public boolean get () {
        for (int i = 0; i < this.triggers.length; i++) {
            if (this.triggers[i].get()) {
                return true;
            }
        }
        
        return false;
    }
}