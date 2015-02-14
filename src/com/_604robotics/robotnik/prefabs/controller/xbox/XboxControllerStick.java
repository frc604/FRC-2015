package com._604robotics.robotnik.prefabs.controller.xbox;

import com._604robotics.robotnik.prefabs.controller.ControllerAxis;
import edu.wpi.first.wpilibj.Joystick;

// TODO: Auto-generated Javadoc
/**
 * The Class XboxControllerStick.
 */
public class XboxControllerStick {
    
    /** The x. */
    public final ControllerAxis X;
    
    /** The y. */
    public final ControllerAxis Y;
    
    /**
     * Instantiates a new xbox controller stick.
     *
     * @param joystick the joystick
     * @param x the x
     * @param y the y
     */
    public XboxControllerStick (Joystick joystick, int x, int y) {
        this.X = new ControllerAxis(joystick, x);
        this.Y = new ControllerAxis(joystick, y);
    }
}