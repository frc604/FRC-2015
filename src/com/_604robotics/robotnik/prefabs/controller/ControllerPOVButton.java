package com._604robotics.robotnik.prefabs.controller;

import com._604robotics.robotnik.trigger.TriggerAccess;
import edu.wpi.first.wpilibj.Joystick;

// TODO: Auto-generated Javadoc
/**
 * The Class ControllerPOV.
 */
public class ControllerPOVButton implements TriggerAccess {
    
    /** The joystick. */
    private final Joystick joystick;
    
    /** The port. */
    private final int port;
    
    private final int directionBottom;
    private final int directionTop;

    /**
     * Instantiates a new controller pov.
     *
     * @param joystick the joystick
     * @param port the port
     */
    public ControllerPOVButton (Joystick joystick, int port, int direction) {
        this.joystick = joystick;
        this.port = port;
        this.directionTop = direction;
        this.directionBottom = direction;
    }
    
    public ControllerPOVButton (Joystick joystick, int port, int bottomAngle, int topAngle){
    	this.joystick = joystick;
        this.port = port;
        this.directionTop = topAngle;
        this.directionBottom = bottomAngle;
    }
    
    /* (non-Javadoc)
     * @see com._604robotics.robotnik.data.DataAccess#get()
     */
    public boolean get () {
    	if(directionTop > directionBottom){
    		return joystick.getPOV(port) <= directionTop && joystick.getPOV(port) >= directionBottom;
    	}
    	else{
    		return (joystick.getPOV(port) <= directionTop && joystick.getPOV(port) >= 0) ||
    				(joystick.getPOV(port) <= 360 && joystick.getPOV(port) >= directionBottom);
    	}
    }
}
