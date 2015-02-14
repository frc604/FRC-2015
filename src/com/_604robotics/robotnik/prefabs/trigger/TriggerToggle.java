package com._604robotics.robotnik.prefabs.trigger;

import com._604robotics.robotnik.trigger.TriggerAccess;

// TODO: Auto-generated Javadoc
/**
 * The Class TriggerToggle.
 */
public class TriggerToggle {
    
    /** The trigger. */
    private final TriggerAccess trigger;
    
    /** The last. */
    private boolean last = false;
    
    /** The state. */
    private boolean state;
    
    /**
     * The Class TriggerState.
     */
    private class TriggerState implements TriggerAccess {
        
        /** The which. */
        private final boolean which;
        
        /**
         * Instantiates a new trigger state.
         *
         * @param which the which
         */
        public TriggerState (boolean which) {
            this.which = which;
        }
        
        /* (non-Javadoc)
         * @see com._604robotics.robotnik.trigger.TriggerAccess#get()
         */
        public boolean get () {
            update();
            return state == which;
        }
    }
    
    /** The off. */
    public final TriggerAccess off = new TriggerState(false);
    
    /** The on. */
    public final TriggerAccess on  = new TriggerState(true);
    
    /**
     * Instantiates a new trigger toggle.
     *
     * @param trigger the trigger
     * @param defaultValue the default value
     */
    public TriggerToggle (TriggerAccess trigger, boolean defaultValue) {
        this.trigger = trigger;
        this.state = defaultValue;
    }
    
    /**
     * Update.
     */
    private void update () {
        final boolean now = trigger.get();
        
        if (!last && now) {
            state = !state;
        }
        
        last = now;
    }
}