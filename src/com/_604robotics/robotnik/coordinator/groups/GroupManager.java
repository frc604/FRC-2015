package com._604robotics.robotnik.coordinator.groups;

import java.util.ArrayList;
import java.util.List;

import com._604robotics.robotnik.module.ModuleManager;

/**
 * Manages groups.
 */
public class GroupManager {
    private final List<Group> groups = new ArrayList<Group>();

    /**
     * Clears all groups from the manager.
     */
    public void clear () {
        this.groups.clear();
    }

    /**
     * Adds a group to the manager.
     * @param group Group to add.
     */
    public void add (Group group) {
        this.groups.add(group);
    }

    /**
     * Attaches the group manager to a set of modules.
     * @param modules Modules to attach to.
     */
    public void attach (ModuleManager modules) {
        for (Group group : this.groups) {
            group.attach(modules);
        }
    }

    /**
     * Updates all groups within the manager.
     */
    public void update () {
        for (Group group : this.groups) {
            group.update();
        }
    }

    /**
     * Stops all groups within the manager.
     */
    public void stop () {
        for (Group group : this.groups) {
            group.reset();
        }
    }

    /**
     * Gets whether all groups have completed.
     * @return Whether all groups have completed.
     */
    public boolean complete () {
        for (Group group : this.groups) {
            if(!group.complete()) {
                return false;
            }
        }

        return true;
    }
}
