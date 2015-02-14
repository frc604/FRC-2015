package com._604robotics.robotnik.prefabs.trigger;

import com._604robotics.robotnik.trigger.TriggerAccess;

// TODO: Auto-generated Javadoc
/**
 * The Class TriggerManual.
 */
public class TriggerManual implements TriggerAccess {
    
    /** The triggered. */
    private boolean triggered;
    
    /**
     * Instantiates a new trigger manual.
     *
     * @param defaultValue the default value
     */
    public TriggerManual (boolean defaultValue) {
        this.triggered = defaultValue;
    }
    
    /* (non-Javadoc)
     * @see com._604robotics.robotnik.trigger.TriggerAccess#get()
     */
    public boolean get () {
        return this.triggered;
    }
    
    /**
     * Sets the.
     *
     * @param triggered the triggered
     */
    public void set (boolean triggered) {
        this.triggered = triggered;
    }
}