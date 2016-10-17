package com._604robotics.robotnik.trigger;

import com._604robotics.robotnik.Safety;
import com._604robotics.robotnik.memory.IndexedTable.Slice;
import com._604robotics.robotnik.prefabs.trigger.TriggerNot;

/**
 * A reference to a trigger.
 */
public class TriggerReference implements TriggerAccess {
    private final Trigger trigger;
    private final Slice value;

    private TriggerAccess inverse = null;

    /**
     * Creates a trigger reference.
     * @param trigger Trigger to refer to.
     * @param value Slice to store the trigger value in.
     */
    public TriggerReference (Trigger trigger, Slice value) {
        this.trigger = trigger;
        this.value = value;
    }
    
    /**
     * Gets the inverse of the trigger.
     * @return The inverse of the trigger.
     */
    public TriggerAccess not () {
        if (inverse == null) {
            inverse = new TriggerNot(this);
        }
        
        return inverse;
    }
    
    @Override
    public boolean get () {
        return value.getBoolean(false);
    }
    
    /**
     * Updates the trigger.
     * @param safety Safety mode to operate with.
     */
    public void update (Safety safety) {
        safety.wrap("updating trigger value", () -> value.putBoolean(trigger.run()));
    }
}
