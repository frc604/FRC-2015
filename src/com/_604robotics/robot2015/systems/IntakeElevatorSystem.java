package com._604robotics.robot2015.systems;

import com._604robotics.robotnik.coordinator.Coordinator;
import com._604robotics.robotnik.coordinator.connectors.DataWire;
import com._604robotics.robotnik.module.ModuleManager;

// TODO: Auto-generated Javadoc

public class IntakeElevatorSystem extends Coordinator {
    
    /* (non-Javadoc)
     * @see com._604robotics.robotnik.coordinator.Coordinator#apply(com._604robotics.robotnik.module.ModuleManager)
     */
    protected void apply (ModuleManager modules) {
    	this.fill(new DataWire(modules.getModule("Elevator").getAction("Manual"),
                "intake open", modules.getModule("Clamp").getTrigger("Open")));
    	this.fill(new DataWire(modules.getModule("Elevator").getAction("Tessellation Setpoint"),
                "intake open", modules.getModule("Clamp").getTrigger("Open")));
    	this.fill(new DataWire(modules.getModule("Elevator").getAction("Test Setpoint 1"),
                "intake open", modules.getModule("Clamp").getTrigger("Open")));
    	this.fill(new DataWire(modules.getModule("Elevator").getAction("Test Setpoint 1.5"),
                "intake open", modules.getModule("Clamp").getTrigger("Open")));
    	this.fill(new DataWire(modules.getModule("Elevator").getAction("Test Setpoint 2"),
                "intake open", modules.getModule("Clamp").getTrigger("Open")));
    	this.fill(new DataWire(modules.getModule("Elevator").getAction("Test Setpoint 3"),
                "intake open", modules.getModule("Clamp").getTrigger("Open")));
    }
}
