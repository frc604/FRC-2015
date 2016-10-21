package com._604robotics.robotnik.coordinator;

import java.util.ArrayList;
import java.util.List;

import com._604robotics.robotnik.coordinator.connectors.Binding;
import com._604robotics.robotnik.coordinator.connectors.DataWire;
import com._604robotics.robotnik.coordinator.groups.Group;
import com._604robotics.robotnik.coordinator.groups.GroupManager;
import com._604robotics.robotnik.coordinator.steps.Step;
import com._604robotics.robotnik.coordinator.steps.StepManager;
import com._604robotics.robotnik.module.ModuleManager;

/**
 * Coordinates the flow of data and bindings, and the execution of groups and steps.
 */
public class Coordinator {
    private final List<Binding> triggerBindings = new ArrayList<Binding>();
    private final List<DataWire> dataWires = new ArrayList<DataWire>();
    
    private final GroupManager groups = new GroupManager();
    private final StepManager steps = new StepManager();
    
    /**
     * Applies the coordinator to a set of modules.
     * @param modules Modules to apply to.
     */
    protected void apply (ModuleManager modules) {}
    
    /**
     * Attaches the coordinator to a set of modules.
     * @param modules Modules to attach to.
     */
    public void attach (ModuleManager modules) {
        this.triggerBindings.clear();
        this.dataWires.clear();

        this.groups.clear();
        this.steps.clear();
        
        this.apply(modules);

        this.groups.attach(modules);
        this.steps.attach(modules);
    }
    
    /**
     * Adds a binding to the coordinator.
     * @param binding Binding to add.
     */
    protected void bind (Binding binding) {
        this.triggerBindings.add(binding);
    }
    
    /**
     * Adds a data wire to the coordinator.
     * @param dataWire Data wire to add.
     */
    protected void fill (DataWire dataWire) {
        this.dataWires.add(dataWire);
    }
    
    /**
     * Adds a group to the coordinator.
     * @param group Group to add.
     */
    protected void group (Group group) {
        this.groups.add(group);
    }
    
    /**
     * Adds a step to the coordinator.
     * @param name Name of the step.
     * @param step Step to add.
     */
    protected void step (String name, Step step) {
        this.steps.add(name, step);
    }
    
    /**
     * Updates the coordinator.
     */
    public void update () {
        for (DataWire wire : this.dataWires) {
            wire.conduct();
        }
        
        for (Binding binding : this.triggerBindings) {
            binding.conduct();
        }

        this.groups.update();
        this.steps.update();
    }

    /**
     * Stops the coordinator's execution.
     */
    public void stop () {
        this.groups.stop();
        this.steps.stop();
    }
    
    /**
     * Gets whether the coordinator has completed execution.
     * @return Whether the coordinator is complete.
     */
    public boolean complete () {
        return this.steps.complete() && this.groups.complete();
    }
}
