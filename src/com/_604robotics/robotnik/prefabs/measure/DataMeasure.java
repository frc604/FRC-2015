package com._604robotics.robotnik.prefabs.measure;

import com._604robotics.robotnik.data.DataAccess;
import com._604robotics.robotnik.procedure.Measure;

// TODO: Auto-generated Javadoc
/**
 * The Class DataMeasure.
 */
public class DataMeasure extends Measure {
    
    /** The Constant DELTA. */
    public static final int DELTA       = 1024;
    
    /** The Constant LOWER_BOUND. */
    public static final int LOWER_BOUND = 1;
    
    /** The Constant UPPER_BOUND. */
    public static final int UPPER_BOUND = 2;
    
    /** The data. */
    private final DataAccess data;
    
    /** The mode. */
    private final int mode;
    
    /** The target. */
    private final double target;
    
    /** The initial value. */
    private double initialValue;
    
    /**
     * Instantiates a new data measure.
     *
     * @param data the data
     * @param mode the mode
     * @param target the target
     */
    public DataMeasure (DataAccess data, int mode, double target) {
        this.data = data;
        this.mode = mode;
        this.target = target;
    }

    /* (non-Javadoc)
     * @see com._604robotics.robotnik.procedure.Measure#initialize()
     */
    public void initialize () {
        initialValue = data.get();
    }

    /* (non-Javadoc)
     * @see com._604robotics.robotnik.procedure.Measure#complete()
     */
    public boolean complete () {
        double value = data.get();
        if ((mode & DELTA) == DELTA)
            value -= initialValue;
        
        if ((mode & LOWER_BOUND) == LOWER_BOUND)
            return value <= target;
        else if ((mode & UPPER_BOUND) == UPPER_BOUND)
            return value >= target;
        else
            return false;
    }
}
