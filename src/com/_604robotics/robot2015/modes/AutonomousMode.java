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
import com._604robotics.robotnik.prefabs.trigger.TriggerOr;
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
    	add("Enable", new Step(new TriggerMeasure(modules.getModule("Dashboard").getTrigger("Auton On")), new Coordinator()));
    	
    	add("Lift", new Step(new TriggerMeasure(new TriggerOr(new TriggerAccess[] {
    			modules.getModule("Dashboard").getTrigger("Drive Only"),
    			modules.getModule("Elevator").getTrigger("Tote Lifted")
    	})), new Coordinator()));
    	
    	add("Back", new Step(new TriggerMeasure(new TriggerOr(new TriggerAccess[] {
    			modules.getModule("Dashboard").getTrigger("Drive Only"),
    				new TriggerAnd(new TriggerAccess[] {
    						modules.getModule("Drive").getTrigger("At Left Servo Target"),
    						modules.getModule("Drive").getTrigger("At Right Servo Target")})
    	})), new Coordinator() {
    		protected void apply (ModuleManager modules) {
    			this.bind(new Binding(modules.getModule("Drive").getAction("Servo Drive")));
    			this.fill(new DataWire(modules.getModule("Drive").getAction("Servo Drive"), "left clicks", -45));
    			this.fill(new DataWire(modules.getModule("Drive").getAction("Servo Drive"), "right clicks", -45));
    		}
    	}));
    	
    	add("Turn", new Step(new TriggerMeasure(new TriggerOr(new TriggerAccess[] {
    			modules.getModule("Dashboard").getTrigger("Drive Only"),
    				new TriggerAnd(new TriggerAccess[] {
    						modules.getModule("Drive").getTrigger("At Left Servo Target"),
    						modules.getModule("Drive").getTrigger("At Right Servo Target")})
    	})), new Coordinator() {
    		protected void apply (ModuleManager modules) {
    			this.bind(new Binding(modules.getModule("Drive").getAction("Servo Drive")));
    			this.fill(new DataWire(modules.getModule("Drive").getAction("Servo Drive"), "left clicks", 130));
    			this.fill(new DataWire(modules.getModule("Drive").getAction("Servo Drive"), "right clicks", -130));
    		}
    	}));
    	
    	add("Drive", new Step(new Coordinator() {
    		protected void apply (ModuleManager modules) {
    			this.bind(new Binding(modules.getModule("Drive").getAction("Servo Drive")));
    			this.fill(new DataWire(modules.getModule("Drive").getAction("Servo Drive"), "left clicks",
    					(modules.getModule("Dashboard").getTrigger("Drive Only").get()) ? 300 : 700));
    			this.fill(new DataWire(modules.getModule("Drive").getAction("Servo Drive"), "right clicks",
    					(modules.getModule("Dashboard").getTrigger("Drive Only").get()) ? 300 : 700));
    		}
    	}));
    }
}
