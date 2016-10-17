package com._604robotics.robotnik.prefabs.controller.wheel;

import com._604robotics.robotnik.prefabs.controller.ControllerButton;
import edu.wpi.first.wpilibj.Joystick;

/**
 * The buttons of a wheel controller.
 */
public class WheelControllerButtons {
    /**
     * Left Pad.
     */
    public final ControllerButton LeftPad;
    
    /**
     * Right Pad.
     */
    public final ControllerButton RightPad;
    
    /**
     * Triangle.
     */
    public final ControllerButton Triangle;
    
    /**
     * Square.
     */
    public final ControllerButton Square;
    
    /**
     * Circle.
     */
    public final ControllerButton Circle;
    
    /**
     * Cross.
     */
    public final ControllerButton Cross;
    
    /**
     * L2.
     */
    public final ControllerButton L2;
    
    /**
     * R2.
     */
    public final ControllerButton R2;
    
    /**
     * L3.
     */
    public final ControllerButton L3;
    
    /**
     * R3.
     */
    public final ControllerButton R3;
    
    /**
     * Home.
     */
    public final ControllerButton Home;
    
    /**
     * ST.
     */
    public final ControllerButton ST;
    
    /**
     * SE.
     */
    public final ControllerButton SE;

    /**
     * Creates wheel controller buttons.
     * @param joystick Wheel controller containing the buttons.
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