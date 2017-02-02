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
    	
    	step("Moth PID", new Step(new TriggerMeasure(new TriggerAnd(new TriggerAccess[] {
    			modules.getModule("Drive").getTrigger("Always False")})
    	), new Coordinator() {
    		protected void apply (ModuleManager modules) {
    			
    			this.bind(new Binding(modules.getModule("Drive").getAction("Ultra Oscil")));
    			this.fill(new DataWire(modules.getModule("Drive").getAction("Ultra Oscil"), "inches", 50.0));
    		}
    	}));

    }
}
