package com._604robotics.robot2015.systems;

import com._604robotics.robotnik.coordinator.Coordinator;
import com._604robotics.robotnik.coordinator.connectors.DataWire;
import com._604robotics.robotnik.module.ModuleManager;

// TODO: Auto-generated Javadoc
/**
 * The Class DashboardSystem.
 */
public class DashboardSystem extends Coordinator {
    
    /* (non-Javadoc)
     * @see com._604robotics.robotnik.coordinator.Coordinator#apply(com._604robotics.robotnik.module.ModuleManager)
     */
    protected void apply (ModuleManager modules) {
    	this.fill(new DataWire(modules.getModule("Gear").getAction("Not Shifting"),
                "multiplier", modules.getModule("Dashboard").getData("Scaling Factor")));
    	this.fill(new DataWire(modules.getModule("Elevator").getAction("Manual Setpoint"),
    			"clicks", modules.getModule("Dashboard").getData("Manual Setpoint")));
    	/* Drive servo testing */
    	{
    		this.fill(new DataWire(modules.getModule("Drive").getAction("Servo Drive"),
    				"left clicks", modules.getModule("Dashboard").getData("Left Drive Servo")));
    		this.fill(new DataWire(modules.getModule("Drive").getAction("Servo Drive"),
    				"right clicks", modules.getModule("Dashboard").getData("Right Drive Servo")));
    	}
    	 this.fill(new DataWire(modules.getModule("Dashboard").getAction("Display"),
    			 "left clicks", modules.getModule("Drive").getData("Left Drive Clicks")));
         this.fill(new DataWire(modules.getModule("Dashboard").getAction("Display"),
        		 "right clicks", modules.getModule("Drive").getData("Right Drive Clicks")));
         this.fill(new DataWire(modules.getModule("Dashboard").getAction("Display"),
        		 "elevator clicks", modules.getModule("Elevator").getData("Elevator Clicks")));
         this.fill(new DataWire(modules.getModule("Dashboard").getAction("Display"),
        		 "current gear", modules.getModule("Gear").getData("Gear")));
         this.fill(new DataWire(modules.getModule("Dashboard").getAction("Display"),
        		 "current multiplier", modules.getModule("Gear").getData("Current Multiplier")));
    }
}
