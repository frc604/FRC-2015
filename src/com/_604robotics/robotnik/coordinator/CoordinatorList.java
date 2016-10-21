package com._604robotics.robotnik.coordinator;

import java.util.ArrayList;
import java.util.List;

import com._604robotics.robotnik.module.ModuleManager;

/**
 * Contains a list of coordinators.
 */
public class CoordinatorList {
    private final List<Coordinator> coordinators = new ArrayList<Coordinator>();
    
    /**
     * Adds a coordinator.
     * @param coordinator Coordinator to add.
     */
    protected void add (Coordinator coordinator) {
        this.coordinators.add(coordinator);
    }
    
    /**
     * Attaches the list's coordinators to a set of modules.
     * @param modules Modules to attach to.
     */
    public void attach (ModuleManager modules) {
        for (Coordinator coordinator : this.coordinators) {
            coordinator.attach(modules);
        }
    }
    
    /**
     * Updates the list's coordinators.
     */
    public void update () {
        for (Coordinator coordinator : this.coordinators) {
            coordinator.update();
        }
    }
}