package com._604robotics.robotnik.prefabs.devices;

import edu.wpi.first.wpilibj.PIDOutput;

/**
 * Outputs a value to multiple PID outputs.
 */
public class MultiOutput implements PIDOutput {
    private final PIDOutput[] outputs;
    
    /**
     * Creates a multi output.
     * @param outputs PID outputs to output to.
     */
    public MultiOutput (PIDOutput... outputs) {
        this.outputs = outputs;
    }
    
    /**
     * Sets the value of the PID outputs.
     * @param value Value to set.
     */
    public void set (double value) {
        for (int i = 0; i < this.outputs.length; i++) {
            this.outputs[i].pidWrite(value);
        }
    }
    
    /**
     * Stops all motors.
     */
    public void stopMotor () {
        this.set(0D);
    }

    @Override
    public void pidWrite (double value) {
        this.set(value);
    }
}
