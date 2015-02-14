package com._604robotics.robotnik.trigger;

import com._604robotics.robotnik.TriggerProxy;
import com._604robotics.robotnik.meta.Iterator;
import com._604robotics.robotnik.meta.Repackager;
import com._604robotics.robotnik.memory.IndexedTable;
import com._604robotics.robotnik.logging.InternalLogger;
import java.util.Hashtable;

// TODO: Auto-generated Javadoc
/**
 * The Class TriggerManager.
 */
public class TriggerManager {
    
    /** The module name. */
    private final String moduleName;
    
    /** The trigger table. */
    private final Hashtable triggerTable;
    
    /**
     * Instantiates a new trigger manager.
     *
     * @param moduleName the module name
     * @param triggerMap the trigger map
     * @param table the table
     */
    public TriggerManager (String moduleName, TriggerMap triggerMap, final IndexedTable table) {
        this.moduleName = moduleName;
        
        this.triggerTable = Repackager.repackage(triggerMap.iterate(), new Repackager() {
           public Object wrap (Object key, Object value) {
               return new TriggerReference((Trigger) value, table.getSlice((String) key));
           }
        });
    }
    
    /**
     * Gets the trigger.
     *
     * @param name the name
     * @return the trigger
     */
    public TriggerReference getTrigger (String name) {
        TriggerReference ref = (TriggerReference) this.triggerTable.get(name);
        if (ref == null) InternalLogger.missing("TriggerReference", name);
        return ref;
    }
    
    /**
     * Update.
     */
    public void update () {
        final Iterator i = new Iterator(this.triggerTable);
        while (i.next()) TriggerProxy.update(moduleName, (String) i.key, (TriggerReference) i.value);
    }
}
