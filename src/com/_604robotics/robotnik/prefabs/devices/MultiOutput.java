package com._604robotics.robotnik.prefabs.devices;

import edu.wpi.first.wpilibj.PIDOutput;

// TODO: Auto-generated Javadoc
/**
 * The Class MultiOutput.
 */
public class MultiOutput implements PIDOutput {
    
    /** The outputs. */
    private final PIDOutput[] outputs;
    
    /**
     * Instantiates a new multi output.
     *
     * @param outputs the outputs
     */
    public MultiOutput (PIDOutput[] outputs) {
        this.outputs = outputs;
    }
    
    /**
     * Sets the.
     *
     * @param value the value
     */
    public void set (double value) {
        for (int i = 0; i < this.outputs.length; i++) {
            this.outputs[i].pidWrite(value);
        }
    }

    /* (non-Javadoc)
     * @see edu.wpi.first.wpilibj.PIDOutput#pidWrite(double)
     */
    public void pidWrite (double value) {
        this.set(value);
    }
    
    /**
     * Stop motor.
     */
    public void stopMotor () {
        this.set(0D);
    }
}
