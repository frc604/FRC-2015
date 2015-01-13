package com._604robotics.robotnik.prefabs.controller;

import com._604robotics.robotnik.data.DataRecipient;

import edu.wpi.first.wpilibj.Joystick;

public class ControllerRumble implements DataRecipient {
    private final Joystick joystick;
    
    public ControllerRumble (Joystick joystick) {
        this.joystick = joystick;
    }
    
    public void sendData (String fieldName, double dataValue) {
        if(fieldName == "high rumble") joystick.setRumble(Joystick.RumbleType.kLeftRumble, (float)dataValue);
        else if(fieldName == "low rumble") joystick.setRumble(Joystick.RumbleType.kRightRumble, (float)dataValue);
    }
}
