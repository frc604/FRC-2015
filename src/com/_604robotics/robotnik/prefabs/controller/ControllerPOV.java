package com._604robotics.robotnik.prefabs.controller;

import com._604robotics.robotnik.data.DataAccess;
import edu.wpi.first.wpilibj.Joystick;

// TODO: Auto-generated Javadoc
/**
 * The Class ControllerPOV.
 */
public class ControllerPOV implements DataAccess {
    
    /** The joystick. */
    private final Joystick joystick;
    
    /** The port. */
    private final int port;

    /**
     * Instantiates a new controller pov.
     *
     * @param joystick the joystick
     * @param port the port
     */
    public ControllerPOV (Joystick joystick, int port) {
        this.joystick = joystick;
        this.port = port;
    }
    
    /* (non-Javadoc)
     * @see com._604robotics.robotnik.data.DataAccess#get()
     */
    public double get () {
        return joystick.getPOV(port);
    }
}
