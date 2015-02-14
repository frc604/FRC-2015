package com._604robotics.robotnik.prefabs.controller.joystick;

import com._604robotics.robotnik.prefabs.controller.ControllerButton;
import edu.wpi.first.wpilibj.Joystick;

// TODO: Auto-generated Javadoc
/**
 * The Class JoystickControllerButtons.
 */
public class JoystickControllerButtons {
    
    /** The Button1. */
    public final ControllerButton Button1;
    
    /** The Button2. */
    public final ControllerButton Button2;
    
    /** The Button3. */
    public final ControllerButton Button3;
    
    /** The Button4. */
    public final ControllerButton Button4;
    
    /** The Button5. */
    public final ControllerButton Button5;
    
    /** The Button6. */
    public final ControllerButton Button6;
    
    /** The Button7. */
    public final ControllerButton Button7;
    
    /** The Button8. */
    public final ControllerButton Button8;
    
    /** The Button9. */
    public final ControllerButton Button9;
    
    /** The Button10. */
    public final ControllerButton Button10;
    
    /** The Button11. */
    public final ControllerButton Button11;
    
    /**
     * Instantiates a new joystick controller buttons.
     *
     * @param joystick the joystick
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