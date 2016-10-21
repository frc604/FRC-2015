package com._604robotics.robotnik.prefabs.actions;

import com._604robotics.robotnik.action.Action;
import com._604robotics.robotnik.action.ActionData;
import com._604robotics.robotnik.action.field.FieldMap;

import edu.wpi.first.wpilibj.PIDController;

/**
 * An action configuring the PID setpoint.
 */
public class PIDAction extends Action {
    private final PIDController pid;
    
    /**
     * Creates a PID action.
     * @param pid PID controller to use.
     * @param defaultSetpoint Default setpoint value.
     */
    public PIDAction (PIDController pid, double defaultSetpoint) {
        super(new FieldMap() {{
            define("Setpoint", defaultSetpoint);
        }});

        this.pid = pid;
    }

    @Override
    public void begin (ActionData data) {
        pid.enable();
        pid.setSetpoint(data.get("Setpoint"));
    }

    @Override
    public void run (ActionData data) {
        final double currentSetpoint = data.get("Setpoint");
        if (pid.getSetpoint() != currentSetpoint) {
            pid.setSetpoint(currentSetpoint);
        }
    }

    @Override
    public void end (ActionData data) {
        pid.reset();
    }
}
