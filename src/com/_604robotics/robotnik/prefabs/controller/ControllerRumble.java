package com._604robotics.robotnik.prefabs.controller;

import com._604robotics.robotnik.data.DataRecipient;

import edu.wpi.first.wpilibj.Joystick;

public class ControllerRumble implements DataRecipient{
    private final Joystick joystick;
    private boolean enable;
    private float lRumble;
    private float rRumble;
    
    public ControllerRumble (final Joystick joystick) {
        this.joystick = joystick;
        this.enable = false;
        this.lRumble = 0;
        this.rRumble = 0;
    }
    
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
