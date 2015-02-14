package com._604robotics.robotnik.coordinator;

import com._604robotics.robotnik.module.ModuleManager;
import java.util.Enumeration;
import java.util.Vector;

// TODO: Auto-generated Javadoc
/**
 * The Class CoordinatorList.
 */
public class CoordinatorList {
    
    /** The coordinators. */
    private final Vector coordinators = new Vector();
    
    /**
     * Adds the.
     *
     * @param coordinator the coordinator
     */
    protected void add (Coordinator coordinator) {
        this.coordinators.addElement(coordinator);
    }
    
    /**
     * Attach.
     *
     * @param modules the modules
     */
    public void attach (ModuleManager modules) {
        final Enumeration i = this.coordinators.elements();
        while (i.hasMoreElements()) ((Coordinator) i.nextElement()).attach(modules);
    }
    
    /**
     * Update.
     */
    public void update () {
        final Enumeration i = this.coordinators.elements();
        while (i.hasMoreElements()) ((Coordinator) i.nextElement()).update();
    }
}