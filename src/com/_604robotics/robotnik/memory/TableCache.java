package com._604robotics.robotnik.memory;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.tables.ITable;
import java.util.Hashtable;

// TODO: Auto-generated Javadoc
/**
 * The Class TableCache.
 */
public class TableCache {
    
    /** The Constant cache. */
    private static final Hashtable cache = new Hashtable();
    
    /**
     * Gets the table.
     *
     * @param key the key
     * @return the table
     */
    protected static IndexedTable getTable (String key) {
        return getTable(NetworkTable.getTable(key));
    }
    
    /**
     * Gets the sub table.
     *
     * @param parent the parent
     * @param key the key
     * @return the sub table
     */
    protected static IndexedTable getSubTable(ITable parent, String key) {
        return getTable(parent.getSubTable(key));
    }
    
    /**
     * Gets the table.
     *
     * @param table the table
     * @return the table
     */
    private static IndexedTable getTable (ITable table) {
        if (cache.containsKey(table)) {
            return (IndexedTable) cache.get(table);
        } else {
            final IndexedTable result = new IndexedTable(table);
            cache.put(table, result);
            
            return result;
        }
    }
}
