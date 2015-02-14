package com._604robotics.robotnik.data;

import com._604robotics.robotnik.memory.IndexedTable.Slice;

// TODO: Auto-generated Javadoc
/**
 * The Class DataReference.
 */
public class DataReference implements DataAccess {
    
    /** The data. */
    private final Data data;
    
    /** The value. */
    private final Slice value;
    
    /**
     * Instantiates a new data reference.
     *
     * @param data the data
     * @param value the value
     */
    public DataReference (Data data, Slice value) {
        this.data = data;
        this.value = value;
    }
    
    /* (non-Javadoc)
     * @see com._604robotics.robotnik.data.DataAccess#get()
     */
    public double get () {
        return this.value.getNumber(0D);
    }
    
    /**
     * Update.
     */
    public void update () {
        this.value.putNumber(this.data.run());
    }
}
