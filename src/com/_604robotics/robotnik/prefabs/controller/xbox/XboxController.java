package com._604robotics.robotnik.prefabs.controller.xbox;

import edu.wpi.first.wpilibj.Joystick;
import com._604robotics.robotnik.prefabs.controller.ControllerRumble;

// TODO: Auto-generated Javadoc
/**
 * The Class XboxController.
 */
public class XboxController {
    
    /** The buttons. */
    public final XboxControllerButtons buttons;
    
    /** The left stick. */
    public final XboxControllerStick leftStick;
    
    /** The right stick. */
    public final XboxControllerStick rightStick;
    
    public final XboxControllerTriggers triggers;
    
    /** The dpad. */
    public final XboxControllerDpad dpad;
    
    /** The rumble. */
    public final ControllerRumble rumble;
    
    
    /**
     * Instantiates a new xbox controller.
     *
     * @param port the port
     */
    public XboxController (int port) {
        final Joystick joystick = new Joystick(port);
        
        this.buttons = new XboxControllerButtons(joystick);
        
        this.leftStick  = new XboxControllerStick(joystick, 0, 1);
        this.rightStick = new XboxControllerStick(joystick, 4, 5);
        
        this.triggers = new XboxControllerTriggers(joystick, 2, 3);
        
        this.dpad = new XboxControllerDpad(joystick);
        
        this.rumble = new ControllerRumble(joystick);
    }
}