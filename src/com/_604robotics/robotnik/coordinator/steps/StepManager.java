package com._604robotics.robotnik.coordinator.steps;

import java.util.ArrayList;
import java.util.List;

import com._604robotics.robotnik.logging.Logger;
import com._604robotics.robotnik.module.ModuleManager;

/**
 * Manages steps.
 */
public class StepManager {
    private final List<String> names = new ArrayList<String>();
    private final List<Step> steps = new ArrayList<Step>();

    private int currentStep = 0;
    private boolean initialized = false;

    /**
     * Clears all steps from the manager.
     */
    public void clear () {
        this.names.clear();
        this.steps.clear();
    }

    /**
     * Adds a step to the manager.
     * @param name Name of the step.
     * @param step Step to add.
     */
    public void add (String name, Step step) {
        this.names.add(name);
        this.steps.add(step);
    }

    /**
     * Attaches the step manager to a set of modules.
     * @param modules Modules to attach to.
     */
    public void attach (ModuleManager modules) {
        for (Step step : this.steps) {
            step.attach(modules);
        }
    }

    /**
     * Updates the step manager.
     */
    public void update () {
        if (!this.complete()) {
            final Step step = this.steps.get(currentStep);

            if (!this.initialized) {
                this.initialized = true;
				step.initialize();

				Logger.log(" ---- Entered step: " + this.names.get(this.currentStep));
            } else if (!step.complete()) {
                step.update();
            } else {
                Logger.log(" ---- Completed step: " + this.names.get(this.currentStep));
                
                ++this.currentStep;
                this.initialized = false;
            }
        }
    }

    /**
     * Stops and resets the step manager.
     */
    public void stop () {
        this.currentStep = 0;
        this.initialized = false;

        for (Step step : this.steps) {
            step.reset();
        }
    }
    
    /**
     * Gets whether all steps have been completed.
     * @return Whether all steps have been completed.
     */
    public boolean complete () {
        return this.currentStep >= this.steps.size();
    }
}
