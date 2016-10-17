package com._604robotics.robotnik.prefabs.controller;

import com._604robotics.robotnik.trigger.TriggerAccess;
import edu.wpi.first.wpilibj.Joystick;

/**
 * A button representing whether an axis has been pushed in a direction.
 */
public class ControllerAxisButton implements TriggerAccess {
    private final Joystick joystick;
    private final int axis;
    private final int direction;

    /**
     * Creates a controller axis button.
     * @param joystick Joystick containing the axis.
     * @param axis Axis to represent.
     * @param direction Direction to check for.
     */
    public ControllerAxisButton (Joystick joystick, int axis, int direction) {
        this.joystick = joystick;
        this.axis = axis;
        
        this.direction = direction;
    }
    
    @Override
    public boolean get () {
        return Math.round(this.joystick.getRawAxis(this.axis)) == this.direction;
    }
}
