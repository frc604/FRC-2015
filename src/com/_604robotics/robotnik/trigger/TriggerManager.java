package com._604robotics.robotnik.trigger;

import java.util.HashMap;
import java.util.Map;

import com._604robotics.robotnik.Safety;
import com._604robotics.robotnik.logging.Logger;
import com._604robotics.robotnik.memory.IndexedTable;

/**
 * Manages triggers.
 */
public class TriggerManager {
    private final Map<String, TriggerReference> triggerTable;
    
    /**
     * Creates a trigger manager.
     * @param triggerMap Map of triggers to manage.
     * @param table Table to store trigger data in.
     */
    public TriggerManager (TriggerMap triggerMap, final IndexedTable table) {
        this.triggerTable = new HashMap<String, TriggerReference>();
        for (Map.Entry<String, Trigger> entry : triggerMap) {
            this.triggerTable.put(entry.getKey(), new TriggerReference(entry.getValue(), table.getSlice(entry.getKey())));
        }
    }
    
    /**
     * Gets a reference to a trigger.
     * @param name Name of the trigger.
     * @return The retrieved trigger reference.
     */
    public TriggerReference getTrigger (String name) {
        final TriggerReference ref = this.triggerTable.get(name);
        if (ref == null) Logger.missing("TriggerReference", name);
        return ref;
    }
    
    /**
     * Updates all triggers.
     * @param safety Safety mode to operate with.
     */
    public void update (Safety safety) {
        for (TriggerReference ref : this.triggerTable.values()) {
            ref.update(safety);
        }
    }
}
