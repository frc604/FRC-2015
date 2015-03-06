/*
 * 
 */
package com._604robotics.robot2015.modes;

import com._604robotics.robotnik.coordinator.Coordinator;
import com._604robotics.robotnik.coordinator.connectors.Binding;
import com._604robotics.robotnik.coordinator.connectors.DataWire;
import com._604robotics.robotnik.module.ModuleManager;
import com._604robotics.robotnik.prefabs.measure.TriggerMeasure;
import com._604robotics.robotnik.prefabs.trigger.TriggerAnd;
import com._604robotics.robotnik.procedure.Procedure;
import com._604robotics.robotnik.procedure.Step;
import com._604robotics.robotnik.trigger.TriggerAccess;

// TODO: Auto-generated Javadoc
/**
 * The Class AutonomousMode.
 */
public class AutonomousMode extends Procedure {
    /**
     * Instantiates a new autonomous mode.
     */
    public AutonomousMode () {
    	super(new Coordinator() {
    		protected void apply (ModuleManager modules) {
    			this.bind(new Binding(modules.getModule("Elevator").getAction("Test Setpoint 2")));
    		}
    	});
    }
    
    /* (non-Javadoc)
     * @see com._604robotics.robotnik.procedure.Procedure#apply(com._604robotics.robotnik.module.ModuleManager)
     */
    protected void apply (ModuleManager modules) {
    	add("Lift", new Step(new TriggerMeasure(modules.getModule("Elevator").getTrigger("Tote Lifted")), new Coordinator()));
    	
    	add("Back", new Step(new TriggerMeasure(new TriggerAnd(new TriggerAccess[] {
    			modules.getModule("Drive").getTrigger("At Left Servo Target"),
    			modules.getModule("Drive").getTrigger("At Right Servo Target"),
    	})), new Coordinator() {
    		protected void apply (ModuleManager modules) {
    			this.bind(new Binding(modules.getModule("Drive").getAction("Servo Drive")));
    			this.fill(new DataWire(modules.getModule("Drive").getAction("Servo Drive"), "left clicks", -30));
    			this.fill(new DataWire(modules.getModule("Drive").getAction("Servo Drive"), "right clicks", -30));
    		}
    	}));
    	
    	add("Turn", new Step(new TriggerMeasure(new TriggerAnd(new TriggerAccess[] {
    			modules.getModule("Drive").getTrigger("At Left Servo Target"),
    			modules.getModule("Drive").getTrigger("At Right Servo Target"),
    	})), new Coordinator() {
    		protected void apply (ModuleManager modules) {
    			this.bind(new Binding(modules.getModule("Drive").getAction("Servo Drive")));
    			this.fill(new DataWire(modules.getModule("Drive").getAction("Servo Drive"), "left clicks", 115));
    			this.fill(new DataWire(modules.getModule("Drive").getAction("Servo Drive"), "right clicks", -115));
    		}
    	}));
    	
    	add("Drive", new Step(new Coordinator() {
    		protected void apply (ModuleManager modules) {
    			this.bind(new Binding(modules.getModule("Drive").getAction("Servo Drive")));
    			this.fill(new DataWire(modules.getModule("Drive").getAction("Servo Drive"), "left clicks", 600));
    			this.fill(new DataWire(modules.getModule("Drive").getAction("Servo Drive"), "right clicks", 600));
    		}
    	}));
    }
}
