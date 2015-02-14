package com._604robotics.robotnik.prefabs.controller.joystick;

import com._604robotics.robotnik.prefabs.controller.ControllerAxis;
import edu.wpi.first.wpilibj.Joystick;

// TODO: Auto-generated Javadoc
/**
 * The Class JoystickController.
 */
public class JoystickController {
    
    /** The buttons. */
    public final JoystickControllerButtons buttons;
    
    /** The axis x. */
    public final ControllerAxis axisX;
    
    /** The axis y. */
    public final ControllerAxis axisY;
    
    /** The axis adjust. */
    public final ControllerAxis axisAdjust;
    
    /**
     * Instantiates a new joystick controller.
     *
     * @param port the port
     */
    public JoystickController (int port) {
        final Joystick joystick = new Joystick(port);
        
        this.buttons = new JoystickControllerButtons(joystick);
        
        this.axisX = new ControllerAxis(joystick, 0);
        this.axisY = new ControllerAxis(joystick, 1);
        this.axisAdjust = new ControllerAxis(joystick, 2);
    }
}