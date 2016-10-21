package com._604robotics.robotnik.prefabs.controller;

import com._604robotics.robotnik.trigger.TriggerAccess;
import edu.wpi.first.wpilibj.Joystick;

/**
 * A button representing whether a POV-hat has been pushed in a certain direction.
 */
public class ControllerPOVButton implements TriggerAccess {
    private final Joystick joystick;
    private final int port;
    private final int directionBottom;
    private final int directionTop;

    /**
     * Creates a controller POV button.
     * @param joystick Joystick containing the POV.
     * @param port Port of the POV.
     * @param direction Direction to check for.
     */
    public ControllerPOVButton (Joystick joystick, int port, int direction) {
        this.joystick = joystick;
        this.port = port;
        this.directionTop = direction;
        this.directionBottom = direction;
    }
    
    /**
     * Creates a controller POV button.
     * @param joystick Joystick containing the POV.
     * @param port Port of the POV.
     * @param bottomAngle Minimum angle to check for.
     * @param topAngle Maximum angle to check for.
     */
    public ControllerPOVButton (Joystick joystick, int port, int bottomAngle, int topAngle) {
    	this.joystick = joystick;
        this.port = port;
        this.directionTop = topAngle;
        this.directionBottom = bottomAngle;
    }
    
    @Override
    public boolean get () {
    	if (this.directionTop > this.directionBottom) {
    		return this.joystick.getPOV(this.port) <= this.directionTop && this.joystick.getPOV(this.port) >= this.directionBottom;
    	} else {
    		return (this.joystick.getPOV(this.port) <= this.directionTop && this.joystick.getPOV(this.port) >= 0) ||
    		        (this.joystick.getPOV(this.port) <= 360 && this.joystick.getPOV(this.port) >= this.directionBottom);
    	}
    }
}
