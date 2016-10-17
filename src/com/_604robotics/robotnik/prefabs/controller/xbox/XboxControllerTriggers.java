package com._604robotics.robotnik.prefabs.controller.xbox;

import com._604robotics.robotnik.prefabs.controller.ControllerAxis;
import edu.wpi.first.wpilibj.Joystick;

/**
 * The triggers of an Xbox controller.
 */
public class XboxControllerTriggers {
    /**
     * Left.
     */
    public final ControllerAxis Left;
    
    /**
     * Right.
     */
    public final ControllerAxis Right;
    
    /**
     * Creates Xbox controller triggers.
     * @param joystick Xbox controller containing the triggers.
     * @param left Left trigger ID.
     * @param right Right trigger ID.
     */
    public XboxControllerTriggers (Joystick joystick, int left, int right) {
        this.Left = new ControllerAxis(joystick, left);
        this.Right = new ControllerAxis(joystick, right);
    }
}