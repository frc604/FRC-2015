package com._604robotics.robotnik.prefabs.controller.wheel;

import com._604robotics.robotnik.prefabs.controller.ControllerButton;
import edu.wpi.first.wpilibj.Joystick;

// TODO: Auto-generated Javadoc
/**
 * The Class WheelControllerButtons.
 */
public class WheelControllerButtons {
    
    /** The Left pad. */
    public final ControllerButton LeftPad;
    
    /** The Right pad. */
    public final ControllerButton RightPad;
    
    /** The Triangle. */
    public final ControllerButton Triangle;
    
    /** The Square. */
    public final ControllerButton Square;
    
    /** The Circle. */
    public final ControllerButton Circle;
    
    /** The Cross. */
    public final ControllerButton Cross;
    
    /** The L2. */
    public final ControllerButton L2;
    
    /** The R2. */
    public final ControllerButton R2;
    
    /** The L3. */
    public final ControllerButton L3;
    
    /** The R3. */
    public final ControllerButton R3;
    
    /** The Home. */
    public final ControllerButton Home;
    
    /** The st. */
    public final ControllerButton ST;
    
    /** The se. */
    public final ControllerButton SE;
    
    /**
     * Instantiates a new wheel controller buttons.
     *
     * @param joystick the joystick
     */
    public WheelControllerButtons (Joystick joystick) {
        this.LeftPad  = new ControllerButton(joystick, 5);
        this.RightPad = new ControllerButton(joystick, 6);
        
        this.Triangle = new ControllerButton(joystick, 4);
        this.Square   = new ControllerButton(joystick, 1);
        this.Circle   = new ControllerButton(joystick, 3);
        this.Cross    = new ControllerButton(joystick, 2);
        
        this.L2 = new ControllerButton(joystick, 7);
        this.R2 = new ControllerButton(joystick, 8);
        
        this.L3 = new ControllerButton(joystick, 11);
        this.R3 = new ControllerButton(joystick, 12);
        
        this.Home = new ControllerButton(joystick, 13);
        this.ST   = new ControllerButton(joystick, 10);
        this.SE   = new ControllerButton(joystick, 9);
    }
}