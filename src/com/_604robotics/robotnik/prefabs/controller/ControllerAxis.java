package com._604robotics.robotnik.prefabs.controller;

import com._604robotics.robotnik.data.DataAccess;
import edu.wpi.first.wpilibj.Joystick;

// TODO: Auto-generated Javadoc
/**
 * The Class ControllerAxis.
 */
public class ControllerAxis implements DataAccess {
    
    /** The joystick. */
    private final Joystick joystick;
    
    /** The axis. */
    private final int axis;
    
    /** The deadband. */
    private double deadband = 0D;
    
    /** The factor. */
    private double factor = 1D;
    
    /**
     * Instantiates a new controller axis.
     *
     * @param joystick the joystick
     * @param axis the axis
     */
    public ControllerAxis (Joystick joystick, int axis) {
        this.joystick = joystick;
        this.axis = axis;
    }
    
    /* (non-Javadoc)
     * @see com._604robotics.robotnik.data.DataAccess#get()
     */
    public double get () {
        final double value = this.joystick.getRawAxis(this.axis) * this.factor;
        
        return Math.abs(value) < this.deadband ? 0D : value;
    }
    
    /**
     * Sets the deadband.
     *
     * @param deadband the new deadband
     */
    public void setDeadband (double deadband) {
        this.deadband = deadband;
    }
    
    /**
     * Sets the factor.
     *
     * @param factor the new factor
     */
    public void setFactor (double factor) {
        this.factor = factor;
    }
}
