package com._604robotics.robotnik.prefabs.controller;

import com._604robotics.robotnik.trigger.TriggerAccess;
import edu.wpi.first.wpilibj.Joystick;

// TODO: Auto-generated Javadoc
/**
 * The Class ControllerAxisButton.
 */
public class ControllerAxisButton implements TriggerAccess {
    
    /** The joystick. */
    private final Joystick joystick;
    
    /** The axis. */
    private final int axis;
    
    /** The direction. */
    private final int direction;
    
    /**
     * Instantiates a new controller axis button.
     *
     * @param joystick the joystick
     * @param axis the axis
     * @param direction the direction
     */
    public ControllerAxisButton (Joystick joystick, int axis, int direction) {
        this.joystick = joystick;
        this.axis = axis;
        
        this.direction = direction;
    }
    
    /* (non-Javadoc)
     * @see com._604robotics.robotnik.trigger.TriggerAccess#get()
     */
    public boolean get () {
        return Math.round(this.joystick.getRawAxis(this.axis)) == this.direction;
    }
}
