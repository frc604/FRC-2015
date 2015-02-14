package com._604robotics.robotnik.coordinator;

import com._604robotics.robotnik.ConnectorProxy;
import com._604robotics.robotnik.coordinator.connectors.Binding;
import com._604robotics.robotnik.coordinator.connectors.DataWire;
import com._604robotics.robotnik.coordinator.connectors.Group;
import com._604robotics.robotnik.module.ModuleManager;
import java.util.Enumeration;
import java.util.Vector;

// TODO: Auto-generated Javadoc
/**
 * The Class Coordinator.
 */
public class Coordinator {
    
    /** The trigger bindings. */
    private final Vector triggerBindings = new Vector();
    
    /** The data wires. */
    private final Vector dataWires = new Vector();
    
    /** The sub groups. */
    private final Vector subGroups = new Vector();
    
    /**
     * Apply.
     *
     * @param modules the modules
     */
    protected void apply (ModuleManager modules) {}
    
    /**
     * Attach.
     *
     * @param modules the modules
     */
    public void attach (ModuleManager modules) {
        this.triggerBindings.removeAllElements();
        this.dataWires.removeAllElements();
        this.subGroups.removeAllElements();
        
        this.apply(modules);
        
        final Enumeration i = this.subGroups.elements();
        while (i.hasMoreElements()) ((Group) i.nextElement()).attach(modules);
    }
    
    /**
     * Bind.
     *
     * @param binding the binding
     */
    protected void bind (Binding binding) {
        this.triggerBindings.addElement(binding);
    }
    
    /**
     * Fill.
     *
     * @param dataWire the data wire
     */
    protected void fill (DataWire dataWire) {
        this.dataWires.addElement(dataWire);
    }
    
    /**
     * Group.
     *
     * @param group the group
     */
    protected void group (Group group) {
        this.subGroups.addElement(group);
    }
    
    /**
     * Update.
     */
    public void update () {
        final Enumeration wires = this.dataWires.elements();
        while (wires.hasMoreElements()) ConnectorProxy.pipe((DataWire) wires.nextElement());
        
        final Enumeration bindings = this.triggerBindings.elements();
        while (bindings.hasMoreElements()) ConnectorProxy.pipe((Binding) bindings.nextElement());
        
        final Enumeration groups = this.subGroups.elements();
        while (groups.hasMoreElements()) ((Group) groups.nextElement()).update();
    }
}