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
    	this.fill(new DataWire(modules.getModule("Gear").getAction("Not Shifting"),
                "multiplier", modules.getModule("Dashboard").getData("Scaling Factor")));
    	

    	this.fill(new DataWire(modules.getModule("Elevator").getAction("Tessellation Setpoint"),
    			"clicks", modules.getModule("Dashboard").getData("Tessellation Setpoint")));
    	this.fill(new DataWire(modules.getModule("Elevator").getAction("Trash Can Setpoint"),
    			"clicks", modules.getModule("Dashboard").getData("Trash Can Setpoint")));
    	this.fill(new DataWire(modules.getModule("Elevator").getAction("Trash Can Macro Setpoint"),
    			"clicks", modules.getModule("Dashboard").getData("Trash Can Macro Setpoint")));
    	this.fill(new DataWire(modules.getModule("Elevator").getAction("Test Setpoint 1"),
    			"clicks", modules.getModule("Dashboard").getData("Test Setpoint 1")));
    	this.fill(new DataWire(modules.getModule("Elevator").getAction("Test Setpoint 1.5"),
    			"clicks", modules.getModule("Dashboard").getData("Test Setpoint 1.5")));
    	this.fill(new DataWire(modules.getModule("Elevator").getAction("Test Setpoint 2"),
    			"clicks", modules.getModule("Dashboard").getData("Test Setpoint 2")));
    	this.fill(new DataWire(modules.getModule("Elevator").getAction("Test Setpoint 3"),
    			"clicks", modules.getModule("Dashboard").getData("Test Setpoint 3")));
    	/* Drive servo testing and macro*/
    	{
    		this.fill(new DataWire(modules.getModule("Drive").getAction("Servo Drive"),
    				"left clicks", modules.getModule("Dashboard").getData("Left Drive Servo")));
    		this.fill(new DataWire(modules.getModule("Drive").getAction("Servo Drive"),
    				"right clicks", modules.getModule("Dashboard").getData("Right Drive Servo")));
    	}
    	 this.fill(new DataWire(DashboardOutput.asDouble(), "left clicks",
    			 modules.getModule("Drive").getData("Left Drive Clicks")));
         this.fill(new DataWire(DashboardOutput.asDouble(), "right clicks",
        		 modules.getModule("Drive").getData("Right Drive Clicks")));
    	 this.fill(new DataWire(DashboardOutput.asDouble(), "left rate",
    			 modules.getModule("Drive").getData("Left Drive Rate")));
         this.fill(new DataWire(DashboardOutput.asDouble(), "right rate",
        		 modules.getModule("Drive").getData("Right Drive Rate")));
         this.fill(new DataWire(DashboardOutput.asDouble(), "elevator clicks",
        		 modules.getModule("Elevator").getData("Elevator Clicks")));
         this.fill(new DataWire(DashboardOutput.asDouble(), "elevator rate",
        		 modules.getModule("Elevator").getData("Elevator Rate")));
         this.fill(new DataWire(DashboardOutput.asDouble(), "current gear",
        		 modules.getModule("Gear").getData("Gear")));
         this.fill(new DataWire(DashboardOutput.asDouble(), "current multiplier",
        		 modules.getModule("Gear").getData("Current Multiplier")));
         
         this.fill(new DataWire(DashboardOutput.asBoolean(), "elevator on target",
        		 modules.getModule("Elevator").getTrigger("At Elevator Target")));
         this.fill(new DataWire(DashboardOutput.asBoolean(), "left drive on target",
        		 modules.getModule("Drive").getTrigger("At Left Servo Target")));
         this.fill(new DataWire(DashboardOutput.asBoolean(), "right drive on target",
        		 modules.getModule("Drive").getTrigger("At Right Servo Target")));
    }
}
