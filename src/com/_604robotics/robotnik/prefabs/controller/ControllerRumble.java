package com._604robotics.robotnik.prefabs.controller;

import com._604robotics.robotnik.data.DataRecipient;

import edu.wpi.first.wpilibj.Joystick;

/**
 * The rumble feature of a controller.
 */
public class ControllerRumble implements DataRecipient {
    private final Joystick joystick;
    private boolean enable;
    private float lRumble;
    private float rRumble;

    /**
     * Creates a controller rumble.
     * @param joystick Joystick containing the rumble feature.
     */
    public ControllerRumble (final Joystick joystick) {
        this.joystick = joystick;
        this.enable = false;
        this.lRumble = 0;
        this.rRumble = 0;
    }
    
    @Override
    public void sendData (String fieldName, double dataValue) {
    	if (fieldName.equals("enable")) {
    	    this.enable = true;
    	} else if (fieldName.equals("high rumble")) {
    	    this.lRumble = (float) dataValue;
    	} else if (fieldName.equals("low rumble")) {
    	    this.rRumble = (float) dataValue;
    	}
    	
    	if (this.enable) {
    		this.joystick.setRumble(Joystick.RumbleType.kLeftRumble, this.lRumble);
    		this.joystick.setRumble(Joystick.RumbleType.kLeftRumble, this.rRumble);
    	}
    }
}
