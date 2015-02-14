package com._604robotics.robotnik.data;

import com._604robotics.robotnik.DataProxy;
import com._604robotics.robotnik.meta.Iterator;
import com._604robotics.robotnik.meta.Repackager;
import com._604robotics.robotnik.memory.IndexedTable;
import com._604robotics.robotnik.logging.InternalLogger;
import java.util.Hashtable;

// TODO: Auto-generated Javadoc
/**
 * The Class DataManager.
 */
public class DataManager {
    
    /** The module name. */
    private final String moduleName;
    
    /** The data table. */
    private final Hashtable dataTable;
    
    /**
     * Instantiates a new data manager.
     *
     * @param moduleName the module name
     * @param dataMap the data map
     * @param table the table
     */
    public DataManager (String moduleName, DataMap dataMap, final IndexedTable table) {
        this.moduleName = moduleName;
        
        this.dataTable = Repackager.repackage(dataMap.iterate(), new Repackager() {
           public Object wrap (Object key, Object value) {
               return new DataReference((Data) value, table.getSlice((String) key));
           }
        });
    }
    
    /**
     * Gets the data.
     *
     * @param name the name
     * @return the data
     */
    public DataReference getData (String name) {
        final DataReference ref = (DataReference) this.dataTable.get(name);
        if (ref == null) InternalLogger.missing("DataReference", name);
        return ref;
    }
    
    /**
     * Update.
     */
    public void update () {
        final Iterator i = new Iterator(this.dataTable);
        while (i.next()) DataProxy.update(moduleName, (String) i.key, (DataReference) i.value);
    }
}
