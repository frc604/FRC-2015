package com._604robotics.robotnik.prefabs.controller.wheel;

import com._604robotics.robotnik.prefabs.controller.ControllerAxis;
import edu.wpi.first.wpilibj.Joystick;

/**
 * A wheel controller.
 */
public class WheelController {
    /**
     * The wheel's buttons.
     */
    public final WheelControllerButtons buttons;
    
    /**
     * The wheel's axis.
     */
    public final ControllerAxis axis;

    /**
     * Creates a wheel controller.
     * @param port Port of the controller.
     */
    public WheelController (int port) {
        final Joystick joystick = new Joystick(port);
        
        this.buttons = new WheelControllerButtons(joystick);
        this.axis = new ControllerAxis(joystick, 1);
    }
}