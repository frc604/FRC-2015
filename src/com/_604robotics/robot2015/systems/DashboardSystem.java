package com._604robotics.robot2015.systems;

import com._604robotics.robotnik.coordinator.Coordinator;
import com._604robotics.robotnik.coordinator.connectors.DataWire;
import com._604robotics.robotnik.module.ModuleManager;
import com._604robotics.robotnik.prefabs.outputs.DashboardOutput;

// TODO: Auto-generated Javadoc
/**
 * The Class DashboardSystem.
 */
public class DashboardSystem extends Coordinator {
    
    /* (non-Javadoc)
     * @see com._604robotics.robotnik.coordinator.Coordinator#apply(com._604robotics.robotnik.module.ModuleManager)
     */
    protected void apply (ModuleManager modules) {
    	this.fill(new DataWire(modules.getModule("Drive").getAction("Throttled Tank Drive"),
                "throttle", modules.getModule("Dashboard").getData("Throttle")));
    	this.fill(new DataWire(modules.getModule("Elevator").getAction("Manual Setpoint"),
    			"clicks", modules.getModule("Dashboard").getData("Throttle")));
    	/* Drive servo testing */
    	{
    		this.fill(new DataWire(modules.getModule("Drive").getAction("Servo"),
    				"left clicks", modules.getModule("Dashboard").getData("Left Drive Servo")));
    		this.fill(new DataWire(modules.getModule("Drive").getAction("Servo"),
    				"right clicks", modules.getModule("Dashboard").getData("Right Drive Servo")));
    	}
    }
}
