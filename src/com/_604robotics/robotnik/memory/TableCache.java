package com._604robotics.robotnik.memory;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.tables.ITable;

import java.util.HashMap;
import java.util.Map;

/**
 * A cache of tables.
 */
public class TableCache {
    private static final Map<ITable, IndexedTable> cache = new HashMap<ITable, IndexedTable>();

    /**
     * Gets a table.
     * @param key Key of the table.
     * @return The retrieved table.
     */
    protected static IndexedTable getTable (String key) {
        return getTable(NetworkTable.getTable(key));
    }

    /**
     * Gets a sub table.
     * @param parent Parent table of the sub table.
     * @param key Key of the sub table.
     * @return The retrieved sub table.
     */
    protected static IndexedTable getSubTable(ITable parent, String key) {
        return getTable(parent.getSubTable(key));
    }

    private static IndexedTable getTable (ITable table) {
        if (cache.containsKey(table)) {
            return cache.get(table);
        } else {
            final IndexedTable result = new IndexedTable(table);
            cache.put(table, result);
            
            return result;
        }
    }
}
