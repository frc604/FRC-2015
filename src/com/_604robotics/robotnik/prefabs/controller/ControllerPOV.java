package com._604robotics.robotnik.prefabs.controller;

import com._604robotics.robotnik.data.DataAccess;
import edu.wpi.first.wpilibj.Joystick;

public class ControllerPOV implements DataAccess {
    private final Joystick joystick;
    private final int port;

    public ControllerPOV (Joystick joystick, int port) {
        this.joystick = joystick;
        this.port = port;
    }
    
    public double get () {
        return joystick.getPOV(port);
    }
}
