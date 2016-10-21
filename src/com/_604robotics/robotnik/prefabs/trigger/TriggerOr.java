package com._604robotics.robotnik.prefabs.trigger;

import com._604robotics.robotnik.trigger.TriggerAccess;

/**
 * A trigger based on whether any of multiple triggers are active.
 */
public class TriggerOr implements TriggerAccess {
    private final TriggerAccess[] triggers;

    /**
     * Creates a trigger or.
     * @param triggers Triggers to use.
     */
    public TriggerOr (TriggerAccess... triggers) {
        this.triggers = triggers;
    }
    
    @Override
    public boolean get () {
        for (int i = 0; i < this.triggers.length; i++) {
            if (this.triggers[i].get()) {
                return true;
            }
        }
        
        return false;
    }
}