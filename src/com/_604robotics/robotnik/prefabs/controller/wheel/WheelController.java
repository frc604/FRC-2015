package com._604robotics.robotnik.prefabs.controller.wheel;

import com._604robotics.robotnik.prefabs.controller.ControllerAxis;
import edu.wpi.first.wpilibj.Joystick;

// TODO: Auto-generated Javadoc
/**
 * The Class WheelController.
 */
public class WheelController {
    
    /** The buttons. */
    public final WheelControllerButtons buttons;
    
    /** The axis. */
    public final ControllerAxis axis;
    
    /**
     * Instantiates a new wheel controller.
     *
     * @param port the port
     */
    public WheelController (int port) {
        final Joystick joystick = new Joystick(port);
        
        this.buttons = new WheelControllerButtons(joystick);
        this.axis = new ControllerAxis(joystick, 1);
    }
}