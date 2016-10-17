package com._604robotics.robotnik.prefabs.controller.joystick;

import com._604robotics.robotnik.prefabs.controller.ControllerAxis;
import edu.wpi.first.wpilibj.Joystick;

/**
 * A joystick controller.
 */
public class JoystickController {
    /**
     * The joystick's buttons.
     */
    public final JoystickControllerButtons buttons;
    
    /**
     * The joystick's X axis.
     */
    public final ControllerAxis axisX;
    
    /**
     * The joystick's Y axis.
     */
    public final ControllerAxis axisY;
    
    /**
     * The joystick's adjust axis.
     */
    public final ControllerAxis axisAdjust;

    /**
     * Creates a joystick controller.
     * @param port Port of the controller.
     */
    public JoystickController (int port) {
        final Joystick joystick = new Joystick(port);
        
        this.buttons = new JoystickControllerButtons(joystick);
        
        this.axisX = new ControllerAxis(joystick, 0);
        this.axisY = new ControllerAxis(joystick, 1);
        this.axisAdjust = new ControllerAxis(joystick, 2);
    }
}