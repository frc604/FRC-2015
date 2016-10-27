package com._604robotics.robot2015.systems;

import com._604robotics.robotnik.coordinator.Coordinator;
import com._604robotics.robotnik.coordinator.connectors.DataWire;
import com._604robotics.robotnik.module.ModuleManager;

public class DynamicDriveSystem extends Coordinator {
	protected void apply(ModuleManager modules) {
    	this.fill(new DataWire(modules.getModule("Drive").getAction("Dynamic Drive"),
    			"doTank", modules.getModule("DynamicToggle").getData("inTankData")));
    	this.fill(new DataWire(modules.getModule("Drive").getAction("Dynamic Drive"),
    			"doArcade", modules.getModule("DynamicToggle").getData("inArcadeData")));
	}
}
