package com._604robotics.robotnik.prefabs.controller;

import com._604robotics.robotnik.trigger.TriggerAccess;
import edu.wpi.first.wpilibj.Joystick;

// TODO: Auto-generated Javadoc
/**
 * The Class ControllerButton.
 */
public class ControllerButton implements TriggerAccess {
    
    /** The joystick. */
    private final Joystick joystick;
    
    /** The button. */
    private final int button;
    
    /**
     * Instantiates a new controller button.
     *
     * @param joystick the joystick
     * @param button the button
     */
    public ControllerButton (Joystick joystick, int button) {
        this.joystick = joystick;
        this.button = button;
    }
    
    /* (non-Javadoc)
     * @see com._604robotics.robotnik.trigger.TriggerAccess#get()
     */
    public boolean get () {
        return this.joystick.getRawButton(this.button);
    }
}
