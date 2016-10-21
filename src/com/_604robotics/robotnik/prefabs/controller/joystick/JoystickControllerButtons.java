package com._604robotics.robotnik.prefabs.controller.joystick;

import com._604robotics.robotnik.prefabs.controller.ControllerButton;
import edu.wpi.first.wpilibj.Joystick;

/**
 * The buttons of a joystick controller.
 */
public class JoystickControllerButtons {
    /**
     * Button 1.
     */
    public final ControllerButton Button1;
    
    /**
     * Button 2.
     */
    public final ControllerButton Button2;
    
    /**
     * Button 3.
     */
    public final ControllerButton Button3;
    
    /**
     * Button 4.
     */
    public final ControllerButton Button4;
    
    /**
     * Button 5.
     */
    public final ControllerButton Button5;
    
    /**
     * Button 6.
     */
    public final ControllerButton Button6;
    
    /**
     * Button 7.
     */
    public final ControllerButton Button7;
    
    /**
     * Button 8.
     */
    public final ControllerButton Button8;
    
    /**
     * Button 9.
     */
    public final ControllerButton Button9;
    
    /**
     * Button 10.
     */
    public final ControllerButton Button10;
    
    /**
     * Button 11.
     */
    public final ControllerButton Button11;

    /**
     * Creates joystick controller buttons.
     * @param joystick Joystick containing the buttons.
     */
    public JoystickControllerButtons (Joystick joystick) {
        this.Button1  = new ControllerButton(joystick, 1);
        this.Button2  = new ControllerButton(joystick, 2);
        this.Button3  = new ControllerButton(joystick, 3);
        this.Button4  = new ControllerButton(joystick, 4);
        this.Button5  = new ControllerButton(joystick, 5);
        this.Button6  = new ControllerButton(joystick, 6);
        this.Button7  = new ControllerButton(joystick, 7);
        this.Button8  = new ControllerButton(joystick, 8);
        this.Button9  = new ControllerButton(joystick, 9);
        this.Button10 = new ControllerButton(joystick, 10);
        this.Button11 = new ControllerButton(joystick, 11);
    }
}