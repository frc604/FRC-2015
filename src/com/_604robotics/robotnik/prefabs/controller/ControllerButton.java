package com._604robotics.robotnik.prefabs.controller;

import com._604robotics.robotnik.trigger.TriggerAccess;
import edu.wpi.first.wpilibj.Joystick;

/**
 * A button on a controller.
 */
public class ControllerButton implements TriggerAccess {
    private final Joystick joystick;
    private final int button;

    /**
     * Creates a controller button.
     * @param joystick Joystick containing the button.
     * @param button Button to represent.
     */
    public ControllerButton (Joystick joystick, int button) {
        this.joystick = joystick;
        this.button = button;
    }
    
    @Override
    public boolean get () {
        return this.joystick.getRawButton(this.button);
    }
}
