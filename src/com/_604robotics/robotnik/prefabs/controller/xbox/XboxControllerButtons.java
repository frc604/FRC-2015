package com._604robotics.robotnik.prefabs.controller.xbox;

import com._604robotics.robotnik.prefabs.controller.ControllerAxisButton;
import com._604robotics.robotnik.prefabs.controller.ControllerButton;
import edu.wpi.first.wpilibj.Joystick;

// TODO: Auto-generated Javadoc
/**
 * The Class XboxControllerButtons.
 */
public class XboxControllerButtons {
    
    /** The a. */
    public final ControllerButton A;
    
    /** The b. */
    public final ControllerButton B;
    
    /** The x. */
    public final ControllerButton X;
    
    /** The y. */
    public final ControllerButton Y;
    
    /** The lb. */
    public final ControllerButton LB;
    
    /** The rb. */
    public final ControllerButton RB;
    
    /** The Back. */
    public final ControllerButton Back;
    
    /** The Left stick. */
    public final ControllerButton LeftStick;
    
    /** The Right stick. */
    public final ControllerButton RightStick;
    
    /** The lt. */
    public final ControllerAxisButton LT;
    
    /** The rt. */
    public final ControllerAxisButton RT;
    
    /**
     * Instantiates a new xbox controller buttons.
     *
     * @param joystick the joystick
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