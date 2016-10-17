package com._604robotics.robotnik.prefabs.trigger;

import com._604robotics.robotnik.trigger.TriggerAccess;

/**
 * A manual trigger.
 */
public class TriggerManual implements TriggerAccess {
    private boolean triggered;

    /**
     * Creates a trigger manual.
     * @param defaultValue Default value of the trigger.
     */
    public TriggerManual (boolean defaultValue) {
        this.triggered = defaultValue;
    }
    
    @Override
    public boolean get () {
        return this.triggered;
    }

    /**
     * Sets the trigger's value.
     * @param triggered Whether the trigger is triggered.
     */
    public void set (boolean triggered) {
        this.triggered = triggered;
    }
}