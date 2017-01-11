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

         this.fill(new DataWire(DashboardOutput.asBoolean("Tank","Arcade"), "Drive Mode",
        		 modules.getModule("DynamicToggle").getTrigger("inArcade")));
         this.fill(new DataWire(DashboardOutput.asBoolean("Arcade","Tank"), "Drive Mode2",
        		 modules.getModule("DynamicToggle").getTrigger("inTank")));
         
         this.fill(new DataWire(DashboardOutput.asDouble(), "Inches",
           		 modules.getModule("Ultrasonic").getData("Inches")));
    }
}
