package com._604robotics.robotnik.prefabs.trigger;

import com._604robotics.robotnik.trigger.TriggerAccess;

/**
 * A trigger that outputs the inverse of another.
 */
public class TriggerNot implements TriggerAccess {
    private final TriggerAccess trigger;

    /**
     * Creates a trigger not.
     * @param trigger Trigger to invert.
     */
    public TriggerNot (TriggerAccess trigger) {
        this.trigger = trigger;
    }
    
    @Override
    public boolean get () {
        return !this.trigger.get();
    }
}