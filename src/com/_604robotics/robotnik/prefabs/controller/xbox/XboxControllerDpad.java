package com._604robotics.robotnik.prefabs.controller.xbox;

import com._604robotics.robotnik.prefabs.controller.ControllerPOV;
import com._604robotics.robotnik.prefabs.controller.ControllerPOVButton;
import edu.wpi.first.wpilibj.Joystick;

/**
 * The D-pad of an Xbox controller.
 */
public class XboxControllerDpad {
    /**
     * Pad POV-hat.
     */
    public final ControllerPOV pad;
    
    /**
     * Up.
     */
    public final ControllerPOVButton Up;
    
    /**
     * Down.
     */
    public final ControllerPOVButton Down;
    
    /**
     * Left.
     */
    public final ControllerPOVButton Left;
    
    /**
     * Right.
     */
    public final ControllerPOVButton Right;
    
    /**
     * Pressed.
     */
    public final ControllerPOVButton pressed;

    /**
     * Imprecise D-pad measurements.
     */
    public class XboxControllerDpadImprecise {
        /**
         * Up.
         */
        public final ControllerPOVButton Up;
        
        /**
         * Down.
         */
        public final ControllerPOVButton Down;
        
        /**
         * Left.
         */
        public final ControllerPOVButton Left;
        
        /**
         * Right.
         */
        public final ControllerPOVButton Right;

        public XboxControllerDpadImprecise (ControllerPOVButton up, ControllerPOVButton down, ControllerPOVButton left, ControllerPOVButton right) {
            this.Up = up;
            this.Down = down;
            this.Left = left;
            this.Right = right;
        }
    }

    /**
     * Imprecise D-pad measurements.
     */
    public final XboxControllerDpadImprecise imprecise;

    /**
     * Creates an Xbox controller D-pad.
     * @param joystick Xbox controller containing the D-pad.
     */
    public XboxControllerDpad (Joystick joystick){
        this.pad = new ControllerPOV(joystick, 0);
        this.Up = new ControllerPOVButton(joystick, 0, 0);
        this.Down = new ControllerPOVButton(joystick, 0, 180);
        this.Left = new ControllerPOVButton(joystick, 0, 270);
        this.Right = new ControllerPOVButton(joystick, 0, 90);
        this.pressed = new ControllerPOVButton(joystick, 0, 0, 360);
        this.imprecise = new XboxControllerDpadImprecise(
                    new ControllerPOVButton(joystick, 0, 315, 45),
                    new ControllerPOVButton(joystick, 0, 135, 225),
                    new ControllerPOVButton(joystick, 0, 45, 135),
                    new ControllerPOVButton(joystick, 0, 225, 315)
                );
    }
}
