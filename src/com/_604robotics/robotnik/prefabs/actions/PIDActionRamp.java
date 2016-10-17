package com._604robotics.robotnik.prefabs.actions;

import com._604robotics.robotnik.action.Action;
import com._604robotics.robotnik.action.ActionData;
import com._604robotics.robotnik.action.field.FieldMap;

import edu.wpi.first.wpilibj.PIDController;

/**
 * An action configuring the ramped PID setpoint.
 * The setpoint is incremented or decremented in increments.
 * This makes it easier to calibrate PID values
 * when the input is prone to jumps.
 */
public class PIDActionRamp extends Action {
    private final PIDController pid;
    private final double setpointIncrement;
    
    /**
     * Creates a PID action.
     * @param pid PID controller to use.
     * @param defaultSetpoint Default setpoint value.
     * @param setpointIncrement Increment by which to adjust PID setpoint
     */
    public PIDActionRamp (PIDController pid, double defaultSetpoint, 
                          double setpointIncrement) {
        super(new FieldMap() {{
            define("Setpoint", defaultSetpoint);
        }});

        this.pid = pid;
        this.setpointIncrement=setpointIncrement;
    }

    @Override
    public void begin (ActionData data) {
        pid.enable();
        pid.setSetpoint(data.get("Setpoint"));
    }

    @Override
    public void run (ActionData data) {
        final double currentSetpoint = data.get("Setpoint");
        final double delta = currentSetpoint-pid.getSetpoint();
        if (pid.getSetpoint() != currentSetpoint) {
            if (Math.abs(delta)<setpointIncrement) {
                pid.setSetpoint(currentSetpoint);
            }
            else if (delta>0) {
                pid.setSetpoint(pid.getSetpoint()+setpointIncrement);
            }
            else {
                pid.setSetpoint(pid.getSetpoint()-setpointIncrement);
            }
        }
    }

    @Override
    public void end (ActionData data) {
        pid.reset();
    }
}
