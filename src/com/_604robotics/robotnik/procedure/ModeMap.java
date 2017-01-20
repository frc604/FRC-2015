package com._604robotics.robotnik.procedure;

import com._604robotics.robotnik.coordinator.Coordinator;
import com._604robotics.robotnik.module.ModuleManager;

// TODO: Auto-generated Javadoc
/**
 * The Class ModeMap.
 */
public class ModeMap {
    
    /** The autonomous mode. */
    private Procedure autonomousMode = new Procedure();
    
    /** The teleop mode. */
    private Procedure teleopMode = new Procedure();
    
    /**
     * Attach.
     *
     * @param modules the modules
     */
    public void attach (ModuleManager modules) {
        this.autonomousMode.attach(modules);
        this.teleopMode.attach(modules);
    }
    
    /**
     * Sets the autonomous mode.
     *
     * @param autonomousMode the new autonomous mode
     */
    protected void setAutonomousMode (Coordinator autonomousMode) {
        this.setAutonomousMode(new Procedure(autonomousMode));
    }
    
    /**
     * Sets the autonomous mode.
     *
     * @param autonomousMode the new autonomous mode
     */
    protected void setAutonomousMode (Procedure autonomousMode) {
        this.autonomousMode = autonomousMode;
    }
    
    /**
     * Sets the teleop mode.
     *
     * @param teleopMode the new teleop mode
     */
    protected void setTeleopMode (Coordinator teleopMode) {
        this.setTeleopMode(new Procedure(teleopMode));
    }
    
    /**
     * Sets the teleop mode.
     *
     * @param teleopMode the new teleop mode
     */
    protected void setTeleopMode (Procedure teleopMode) {
        this.teleopMode = teleopMode;
    }

    /**
     * Gets the autonomous mode.
     *
     * @return the autonomous mode
     */
    public Procedure getAutonomousMode () {
        return this.autonomousMode;
    }

    /**
     * Gets the teleop mode.
     *
     * @return the teleop mode
     */
    public Procedure getTeleopMode () {
        return this.teleopMode;
    }
}