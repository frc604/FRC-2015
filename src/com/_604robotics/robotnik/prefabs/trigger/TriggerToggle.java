package com._604robotics.robotnik.prefabs.trigger;

import com._604robotics.robotnik.trigger.TriggerAccess;

/**
 * A toggled trigger, with an on and off state.
 */
public class TriggerToggle {
    private final TriggerAccess trigger;
    private boolean last = false;
    private boolean state;

    private class TriggerState implements TriggerAccess {
        private final boolean which;

        public TriggerState (boolean which) {
            this.which = which;
        }
        
        @Override
        public boolean get () {
            update();
            return state == this.which;
        }
    }

    /**
     * Trigger for the off state.
     */
    public final TriggerAccess off = new TriggerState(false);
    
    /**
     * Trigger for the on state.
     */
    public final TriggerAccess on  = new TriggerState(true);

    /**
     * Creates a trigger toggle.
     * @param trigger Trigger to toggle the state.
     * @param defaultValue Default value of the toggle.
     */
    public TriggerToggle (TriggerAccess trigger, boolean defaultValue) {
        this.trigger = trigger;
        this.state = defaultValue;
    }

    private void update () {
        final boolean now = this.trigger.get();
        
        if (!this.last && now) {
            this.state = !this.state;
        }
        
        this.last = now;
    }
}