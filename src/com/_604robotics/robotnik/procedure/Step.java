package com._604robotics.robotnik.procedure;

import com._604robotics.robotnik.coordinator.Coordinator;
import com._604robotics.robotnik.module.ModuleManager;

// TODO: Auto-generated Javadoc
/**
 * The Class Step.
 */
public class Step {
    
    /** The measure. */
    private final Measure measure;
    
    /** The coordinator. */
    private final Coordinator coordinator;

    /**
     * Instantiates a new step.
     *
     * @param measure the measure
     */
    public Step (Measure measure) {
        this.measure = measure;
        this.coordinator = new Coordinator();
    }

    /**
     * Instantiates a new step.
     *
     * @param coordinator the coordinator
     */
    public Step (Coordinator coordinator) {
        this.measure = null;
        this.coordinator = coordinator;
    }

    /**
     * Instantiates a new step.
     *
     * @param measure the measure
     * @param coordinator the coordinator
     */
    public Step (Measure measure, Coordinator coordinator) {
        this.measure = measure;
        this.coordinator = coordinator;
    }
    
    /**
     * Initialize.
     */
    public void initialize () {
        if (measure != null)
            measure.initialize();
    }
    
    /**
     * Complete.
     *
     * @return true, if successful
     */
    public boolean complete () {
        if (measure != null)
            return measure.complete();
        else
            return false;
    }
    
    /**
     * Attach.
     *
     * @param modules the modules
     */
    public void attach (ModuleManager modules) {
        coordinator.attach(modules);
    }
    
    /**
     * Update.
     */
    public void update () {
        coordinator.update();
    }
}
