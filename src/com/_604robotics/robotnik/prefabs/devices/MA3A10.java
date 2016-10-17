package com._604robotics.robotnik.prefabs.devices;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

/**
 * A MA3A10 encoder.
 */
public class MA3A10 implements PIDSource {
    private static final double MAX_VOLTAGE = 5;
    
    private final AnalogInput input;
    private double zero = 0D;
    
    /**
     * Creates a MA3A10.
     * @param port Port of the encoder.
     */
    public MA3A10 (int port) {
        this.input = new AnalogInput(port);
    }
    
    /**
     * Sets the zero of the encoder to its current value.
     */
    public void setZero () {
        this.setZero(this.getVoltage());
    }
    
    /**
     * Sets the zero of an encoder.
     * @param zero Zero value to set.
     */
    public void setZero (double zero) {
        this.zero = zero;
    }
    
    /**
     * Sets the zero of the encoder to an angle.
     * @param zeroAngle Zero angle to set.
     */
    public void setZeroAngle (double zeroAngle) {
        this.setZero(zeroAngle / 360 * MAX_VOLTAGE);
    }
    
    /**
     * Gets the (raw, non-zeroed) voltage value of the encoder.
     * @return The (raw, non-zeroed) voltage value of the encoder.
     */
    public double getRawVoltage () {
        return this.input.getVoltage();
    }
    
    /**
     * Gets the (zeroed) voltage value of the encoder.
     * @return The (zeroed) voltage value of the encoder.
     */
    public double getVoltage () {
        double voltage = this.getRawVoltage() - this.zero;
        if (voltage < 0) {
            voltage += MAX_VOLTAGE;
        }
        return voltage;
    }
    
    /**
     * Gets the (zeroed) angle of the encoder.
     * @return The (zeroed) angle of the encoder.
     */
    public double getAngle () {
        return this.getVoltage() / MAX_VOLTAGE * 360;
    }
    
    /**
     * Gets the (raw, non-zeroed) angle value of the encoder.
     * @return The (raw, non-zeroed) angle of the encoder.
     */
    public double getRawAngle () {
        return this.getRawVoltage() / MAX_VOLTAGE * 360;
    }

    @Override
    public double pidGet () {
        return this.getAngle();
    }

    @Override
    public PIDSourceType getPIDSourceType () {
        return PIDSourceType.kDisplacement;
    }

    @Override
    public void setPIDSourceType (PIDSourceType sourceType) {
        if (sourceType != PIDSourceType.kRate) {
            throw new IllegalArgumentException("MA3A10 class only implements PIDSourceType.kDisplacement");
        }
    }
}
