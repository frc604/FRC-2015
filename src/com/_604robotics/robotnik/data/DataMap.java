package com._604robotics.robotnik.data;

import com._604robotics.robotnik.meta.Iterator;
import java.util.Hashtable;

// TODO: Auto-generated Javadoc
/**
 * The Class DataMap.
 */
public class DataMap {
    
    /** The data table. */
    private final Hashtable dataTable = new Hashtable();
    
    /**
     * Adds the.
     *
     * @param name the name
     * @param data the data
     */
    protected void add (String name, Data data) {
        this.dataTable.put(name, data);
    }
    
    /**
     * Gets the data.
     *
     * @param name the name
     * @return the data
     */
    protected Data getData (String name) {
        return (Data) this.dataTable.get(name);
    }
    
    /**
     * Iterate.
     *
     * @return the iterator
     */
    protected Iterator iterate () {
        return new Iterator(this.dataTable);
    }
}
