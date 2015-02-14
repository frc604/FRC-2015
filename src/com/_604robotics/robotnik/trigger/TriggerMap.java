package com._604robotics.robotnik.trigger;

import com._604robotics.robotnik.meta.Iterator;
import java.util.Hashtable;

// TODO: Auto-generated Javadoc
/**
 * The Class TriggerMap.
 */
public class TriggerMap {
    
    /** The trigger table. */
    private final Hashtable triggerTable = new Hashtable();
    
    /**
     * Adds the.
     *
     * @param name the name
     * @param trigger the trigger
     */
    protected void add (String name, Trigger trigger) {
        this.triggerTable.put(name, trigger);
    }
    
    /**
     * Gets the trigger.
     *
     * @param name the name
     * @return the trigger
     */
    protected Trigger getTrigger (String name) {
        return (Trigger) this.triggerTable.get(name);
    }
    
    /**
     * Iterate.
     *
     * @return the iterator
     */
    protected Iterator iterate () {
        return new Iterator(this.triggerTable);
    }
}
