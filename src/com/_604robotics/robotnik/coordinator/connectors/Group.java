package com._604robotics.robotnik.coordinator.connectors;

import com._604robotics.robotnik.coordinator.Coordinator;
import com._604robotics.robotnik.module.ModuleManager;
import com._604robotics.robotnik.trigger.TriggerAccess;

// TODO: Auto-generated Javadoc
/**
 * The Class Group.
 */
public class Group {
    
    /** The trigger. */
    private final TriggerAccess trigger;
    
    /** The coordinator. */
    private final Coordinator coordinator;

    /**
     * Instantiates a new group.
     *
     * @param trigger the trigger
     * @param coordinator the coordinator
     */
    public Group (TriggerAccess trigger, Coordinator coordinator) {
        this.trigger = trigger;
        this.coordinator = coordinator;
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
        if (trigger.get())
            coordinator.update();
    }
}
