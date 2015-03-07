package com._604robotics.robotnik.prefabs.controller.xbox;

import com._604robotics.robotnik.prefabs.controller.ControllerAxis;
import edu.wpi.first.wpilibj.Joystick;

// TODO: Auto-generated Javadoc

public class XboxControllerTriggers {
    
    public final ControllerAxis LEFT;
    
    public final ControllerAxis RIGHT;
    
    public XboxControllerTriggers (Joystick joystick, int left, int right) {
        this.LEFT = new ControllerAxis(joystick, left);
        this.RIGHT = new ControllerAxis(joystick, right);
    }
}