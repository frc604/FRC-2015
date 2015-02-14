/*
 * 
 */
package com._604robotics.robot2015.modes;

import com._604robotics.robot2015.modules.Drive;
import com._604robotics.robotnik.coordinator.Coordinator;
import com._604robotics.robotnik.coordinator.connectors.Binding;
import com._604robotics.robotnik.coordinator.connectors.DataWire;
import com._604robotics.robotnik.module.ModuleManager;
import com._604robotics.robotnik.prefabs.measure.TriggerMeasure;
import com._604robotics.robotnik.prefabs.trigger.TriggerAnd;
import com._604robotics.robotnik.procedure.Procedure;
import com._604robotics.robotnik.procedure.Step;
import com._604robotics.robotnik.trigger.TriggerAccess;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;

// TODO: Auto-generated Javadoc
/**
 * The Class AutonomousMode.
 */
public class AutonomousMode extends Procedure {
	Drive drive = new Drive();
	Encoder rEncoder = new Encoder(3, 4);
	Encoder lEncoder = new Encoder(2, 1);
	
	/** The left. */
	private final Talon fLeftMotor = new Talon(0);
	
	/** The r left. */
	private final Talon rLeftMotor = new Talon(1);
	
	/** The right. */
	private final Talon fRightMotor = new Talon(2);
	
	/** The r right. */
	private final Talon rRightMotor = new Talon(3);
    
    /**
     * Instantiates a new autonomous mode.
     */
    public AutonomousMode () {
    }
    
    /* (non-Javadoc)
     * @see com._604robotics.robotnik.procedure.Procedure#apply(com._604robotics.robotnik.module.ModuleManager)
     */
    protected void apply (ModuleManager modules) {
    	while(rEncoder.get()<100){
    		rLeftMotor.set(1D);
    		
    	}
    }
}
