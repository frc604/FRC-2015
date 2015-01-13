package com._604robotics.robotnik.prefabs.controller.xbox;

import edu.wpi.first.wpilibj.Joystick;
import com._604robotics.robotnik.prefabs.controller.ControllerRumble;

public class XboxController {
    public final XboxControllerButtons buttons;
    
    public final XboxControllerStick leftStick;
    public final XboxControllerStick rightStick;
    
    public final XboxControllerDpad dpad;
    
    public final ControllerRumble rumble;
    
    
    public XboxController (int port) {
        final Joystick joystick = new Joystick(port);
        
        this.buttons = new XboxControllerButtons(joystick);
        
        this.leftStick  = new XboxControllerStick(joystick, 0, 1);
        this.rightStick = new XboxControllerStick(joystick, 4, 5);
        
        this.dpad = new XboxControllerDpad(joystick);
        
        this.rumble = new ControllerRumble(joystick);
    }
}