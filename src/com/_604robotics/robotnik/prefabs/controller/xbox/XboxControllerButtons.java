package com._604robotics.robotnik.prefabs.controller.xbox;

import com._604robotics.robotnik.prefabs.controller.ControllerAxisButton;
import com._604robotics.robotnik.prefabs.controller.ControllerButton;
import edu.wpi.first.wpilibj.Joystick;

/**
 * The buttons of an Xbox controller.
 */
public class XboxControllerButtons {
    /**
     * A.
     */
    public final ControllerButton A;
    
    /**
     * B.
     */
    public final ControllerButton B;
    
    /**
     * X.
     */
    public final ControllerButton X;
    
    /**
     * Y.
     */
    public final ControllerButton Y;
    
    /**
     * LB.
     */
    public final ControllerButton LB;
    
    /**
     * RB.
     */
    public final ControllerButton RB;
    
    /**
     * Back.
     */
    public final ControllerButton Back;
    
    /**
     * Left Stick.
     */
    public final ControllerButton LeftStick;
    
    /**
     * Right Stick.
     */
    public final ControllerButton RightStick;
    
    /**
     * LT.
     */
    public final ControllerAxisButton LT;
    
    /**
     * RT.
     */
    public final ControllerAxisButton RT;

    /**
     * Creates Xbox controller buttons.
     * @param joystick Xbox controller containing the buttons.
     */
    public XboxControllerButtons (Joystick joystick) {
        this.A    = new ControllerButton(joystick, 1);
        this.B    = new ControllerButton(joystick, 2);
        this.X    = new ControllerButton(joystick, 3);
        this.Y    = new ControllerButton(joystick, 4);
        this.LB   = new ControllerButton(joystick, 5);
        this.RB   = new ControllerButton(joystick, 6);
        this.Back = new ControllerButton(joystick, 7);
        
        this.LeftStick  = new ControllerButton(joystick,  9);
        this.RightStick = new ControllerButton(joystick, 10);
        
        this.LT = new ControllerAxisButton(joystick, 2, 1);
        this.RT = new ControllerAxisButton(joystick, 3, 1);
    }
}