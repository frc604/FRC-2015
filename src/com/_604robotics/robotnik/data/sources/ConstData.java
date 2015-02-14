package com._604robotics.robotnik.data.sources;

import com._604robotics.robotnik.data.DataAccess;

// TODO: Auto-generated Javadoc
/**
 * The Class ConstData.
 */
public class ConstData implements DataAccess {
    
    /** The value. */
    private final double value;

    /**
     * Instantiates a new const data.
     *
     * @param value the value
     */
    public ConstData (double value) {
        this.value = value;
    }
    
    /* (non-Javadoc)
     * @see com._604robotics.robotnik.data.DataAccess#get()
     */
    public double get() {
        return value;
    }
}
