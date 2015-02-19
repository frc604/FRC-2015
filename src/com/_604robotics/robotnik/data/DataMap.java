package com._604robotics.robotnik.data;

import com._604robotics.robotnik.meta.Iterator;
import java.util.Hashtable;

/**
 * The Class DataMap.
 */
public class DataMap {
    
    /** The hashtable that is to be used to store data*/
    private final Hashtable dataTable = new Hashtable();
    
    /**
     * Adds the name and data combination to the hashtable
     *
     * @param name the key used to retrieve the data
     * @param data the the data to be retrieved 
     */
    protected void add (String name, Data data) {
        this.dataTable.put(name, data);
    }
    
    /**
     * Gets the data.
     *
     * @param name of the key assigned to the data to be retrieved
     * @return the data
     */
    protected Data getData (String name) {
        return (Data) this.dataTable.get(name);
    }
    
    /**
     * Iterate.
     *
     * @return the new iterator created for the hashtable created for the DataMap
     */
    protected Iterator iterate () {
        return new Iterator(this.dataTable);
    }
}
