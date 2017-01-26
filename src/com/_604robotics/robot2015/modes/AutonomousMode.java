/*
 * 
 */
package com._604robotics.robot2015.modes;

import com._604robotics.robotnik.coordinator.Coordinator;
import com._604robotics.robotnik.coordinator.connectors.Binding;
import com._604robotics.robotnik.coordinator.connectors.DataWire;
import com._604robotics.robotnik.coordinator.steps.Step;
import com._604robotics.robotnik.module.ModuleManager;
import com._604robotics.robotnik.prefabs.measure.TriggerMeasure;
import com._604robotics.robotnik.prefabs.trigger.TriggerAnd;
import com._604robotics.robotnik.prefabs.trigger.TriggerOr;
import com._604robotics.robotnik.trigger.TriggerAccess;

// TODO: Auto-generated Javadoc
/**
 * The Class AutonomousMode.
 */
public class AutonomousMode extends Coordinator {
    
    /* (non-Javadoc)
     * @see com._604robotics.robotnik.procedure.Procedure#apply(com._604robotics.robotnik.module.ModuleManager)
     */
    protected void apply (ModuleManager modules) {
    	
    	step("Enable", new Step(new TriggerMeasure(modules.getModule("Dashboard").getTrigger("Auton On")), new Coordinator()));
    	
    	step("Moth Raw", new Step(new TriggerMeasure(new TriggerOr(new TriggerAccess[] {
    			modules.getModule("Dashboard").getTrigger("Raw"),
    				new TriggerAnd(new TriggerAccess[] {
    						modules.getModule("Drive").getTrigger("At Ultra Target")})
    	})), new Coordinator() {
    		protected void apply (ModuleManager modules) {
    			this.bind(new Binding(modules.getModule("Drive").getAction("Ultra Drive Raw")));
    			this.fill(new DataWire(modules.getModule("Drive").getAction("Ultra Drive Raw"), "raw", -0.845));
    		}
    	}));
    	step("Moth Inches", new Step(new TriggerMeasure(new TriggerOr(new TriggerAccess[] {
    			modules.getModule("Dashboard").getTrigger("Inches"),
    				new TriggerAnd(new TriggerAccess[] {
    						modules.getModule("Drive").getTrigger("At Ultra Target")})
    	})), new Coordinator() {
    		protected void apply (ModuleManager modules) {
    			this.bind(new Binding(modules.getModule("Drive").getAction("Ultra Drive Inches")));
    			this.fill(new DataWire(modules.getModule("Drive").getAction("Ultra Drive Inches"), "inches", 36));
    		}
    	}));
    	step("Moth Manual", new Step(new TriggerMeasure(new TriggerOr(new TriggerAccess[] {
    			modules.getModule("Dashboard").getTrigger("Manual"),
    				new TriggerAnd(new TriggerAccess[] {
    						modules.getModule("Drive").getTrigger("Past Ultra Target")})
    	})), new Coordinator() {
    		protected void apply (ModuleManager modules) {
    			this.bind(new Binding(modules.getModule("Drive").getAction("Arcade Drive")));
    			this.fill(new DataWire(modules.getModule("Drive").getAction("Arcade Drive"), "throttle", 0.5));
    			this.fill(new DataWire(modules.getModule("Drive").getAction("Arcade Drive"), "turn", 0D));
    		}
    	}));
    }
}
