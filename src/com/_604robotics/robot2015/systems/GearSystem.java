package com._604robotics.robot2015.systems;

import com._604robotics.robotnik.coordinator.Coordinator;
import com._604robotics.robotnik.coordinator.connectors.DataWire;
import com._604robotics.robotnik.module.ModuleManager;

// TODO: Auto-generated Javadoc
/**
 * The Class DashboardSystem.
 */
public class GearSystem extends Coordinator {
    
    /* (non-Javadoc)
     * @see com._604robotics.robotnik.coordinator.Coordinator#apply(com._604robotics.robotnik.module.ModuleManager)
     */
    protected void apply (ModuleManager modules) {
    	this.fill(new DataWire(modules.getModule("Drive").getAction("Throttled Tank Drive"),
                "throttle", modules.getModule("Gear").getData("Current Multiplier")));
    }
}
