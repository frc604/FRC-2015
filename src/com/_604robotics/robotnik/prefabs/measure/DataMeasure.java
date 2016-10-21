package com._604robotics.robotnik.prefabs.measure;

import com._604robotics.robotnik.coordinator.steps.Measure;
import com._604robotics.robotnik.data.DataAccess;

/**
 * Measures data, reporting completion based on its value.
 */
public class DataMeasure extends Measure {
    /**
     * Measure if the value has changed by a target amount.
     */
    public static final int DELTA       = 1024;
    
    /**
     * Measure if the value is has gone below its lower bound.
     */
    public static final int LOWER_BOUND = 1;
    
    /**
     * Measure if the value is has gone above its upper bound.
     */
    public static final int UPPER_BOUND = 2;

    private final DataAccess data;
    private final int mode;
    private final double target;
    private double initialValue;

    /**
     * Creates a data measure.
     * @param data Data to measure.
     * @param mode Mode of the data measure.
     * @param target Target value to measure for.
     */
    public DataMeasure (DataAccess data, int mode, double target) {
        this.data = data;
        this.mode = mode;
        this.target = target;
    }

    @Override
    public void initialize () {
        this.initialValue = this.data.get();
    }

    @Override
    public boolean complete () {
        double value = data.get();
        if ((this.mode & DELTA) == DELTA) {
            value -= this.initialValue;
        }
        
        if ((this.mode & LOWER_BOUND) == LOWER_BOUND) {
            return value <= this.target;
        } else if ((this.mode & UPPER_BOUND) == UPPER_BOUND) {
            return value >= this.target;
        } else {
            return false;
        }
    }
}
