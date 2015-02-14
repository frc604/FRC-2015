package com._604robotics.robotnik.trigger;

import com._604robotics.robotnik.memory.IndexedTable.Slice;

// TODO: Auto-generated Javadoc
/**
 * The Class TriggerReference.
 */
public class TriggerReference implements TriggerAccess {
    
    /** The trigger. */
    private final Trigger trigger;
    
    /** The value. */
    private final Slice value;
    
    /** The inverse. */
    private TriggerAccess inverse = null;
    
    /**
     * The Class TriggerNot.
     */
    private class TriggerNot implements TriggerAccess {
        
        /** The source. */
        private final TriggerAccess source;
        
        /**
         * Instantiates a new trigger not.
         *
         * @param source the source
         */
        public TriggerNot (TriggerAccess source) {
            this.source = source;
        }
        
        /* (non-Javadoc)
         * @see com._604robotics.robotnik.trigger.TriggerAccess#get()
         */
        public boolean get () {
            return !source.get();
        }
    }
    
    /**
     * Instantiates a new trigger reference.
     *
     * @param trigger the trigger
     * @param value the value
     */
    public TriggerReference (Trigger trigger, Slice value) {
        this.trigger = trigger;
        this.value = value;
    }
    
    /**
     * Not.
     *
     * @return the trigger access
     */
    public TriggerAccess not () {
        if (this.inverse == null) {
            this.inverse = new TriggerNot(this);
        }
        
        return this.inverse;
    }
    
    /* (non-Javadoc)
     * @see com._604robotics.robotnik.trigger.TriggerAccess#get()
     */
    public boolean get () {
        return this.value.getBoolean(false);
    }
    
    /**
     * Update.
     */
    public void update () {
        this.value.putBoolean(this.trigger.run());
    }
}
