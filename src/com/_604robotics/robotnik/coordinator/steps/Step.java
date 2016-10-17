package com._604robotics.robotnik.coordinator.steps;

import com._604robotics.robotnik.coordinator.Coordinator;
import com._604robotics.robotnik.module.ModuleManager;

/**
 * A step to execute.
 */
public class Step {
    private final Measure measure;
    private final Coordinator coordinator;

    /**
     * Creates a step with no contents.
     * @param measure Measure indicating completion.
     */
    public Step (Measure measure) {
        this.measure = measure;
        this.coordinator = new Coordinator();
    }

    /**
     * Creates an unmeasured step.
     * @param coordinator Coordinator driving the step.
     */
    public Step (Coordinator coordinator) {
        this.measure = null;
        this.coordinator = coordinator;
    }

    /**
     * Creates a step.
     * @param measure Measure indicating completion.
     * @param coordinator Coordinator driving the step.
     */
    public Step (Measure measure, Coordinator coordinator) {
        this.measure = measure;
        this.coordinator = coordinator;
    }
    
    /**
     * Initializes the step.
     */
    public void initialize () {
        if (measure != null) {
            measure.initialize();
        }
    }
    
    /**
     * Gets whether the step is complete.
     * @return Whether the step is complete.
     */
    public boolean complete () {
        if (measure != null && !measure.complete()) {
            return false;
        }
        
        if (!coordinator.complete()) {
            return false;
        }

        return true;
    }
    
    /**
     * Attaches the step to a set of modules.
     * @param modules Modules to attach to.
     */
    public void attach (ModuleManager modules) {
        coordinator.attach(modules);
    }
    
    /**
     * Updates the step.
     */
    public void update () {
        coordinator.update();
    }
    
    /**
     * Resets the step.
     */
    public void reset () {
        coordinator.stop();
    }
}
