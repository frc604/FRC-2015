package com._604robotics.robotnik.coordinator.steps;

/**
 * Measures a quantity until it reaches a target.
 */
public abstract class Measure {
    /**
     * Initializes the measure.
     */
    public void initialize () {}

    /**
     * Gets whether the measure is complete.
     * @return Whether the measure is complete.
     */
    public abstract boolean complete ();
}
