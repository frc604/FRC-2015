package com._604robotics.robotnik.prefabs.controller;

import com._604robotics.robotnik.data.DataRecipient;

import edu.wpi.first.wpilibj.Joystick;

// TODO: Auto-generated Javadoc
/**
 * The Class ControllerRumble.
 */
public class ControllerRumble implements DataRecipient{
    
    /** The joystick. */
    private final Joystick joystick;
    
    /** The enable. */
    private boolean enable;
    
    /** The l rumble. */
    private float lRumble;
    
    /** The r rumble. */
    private float rRumble;
    
    /**
     * Instantiates a new controller rumble.
     *
     * @param joystick the joystick
     */
    public ControllerRumble (final Joystick joystick) {
        this.joystick = joystick;
        this.enable = false;
        this.lRumble = 0;
        this.rRumble = 0;
    }
    
    /* (non-Javadoc)
     * @see com._604robotics.robotnik.data.DataRecipient#sendData(java.lang.String, double)
     */
    public void sendData (String fieldName, double dataValue) {
    	if (fieldName == "enable") this.enable = true;
    	else if (fieldName == "high rumble") this.lRumble = (float) dataValue;
        else if (fieldName == "low rumble") this.rRumble = (float) dataValue;
    	
    	if(this.enable){
    		this.joystick.setRumble(Joystick.RumbleType.kLeftRumble, lRumble);
    		this.joystick.setRumble(Joystick.RumbleType.kLeftRumble, rRumble);
    	}
    }
}
