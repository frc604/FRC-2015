package com._604robotics.robotnik.prefabs.devices;

import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.RobotDrive;

/**
 * PID output for tank drive.
 */
public class TankDrivePIDOutput {
    private final RobotDrive drive;
    
    private double leftPower = 0D;
    private double rightPower = 0D;

    /**
     * Left power PID output.
     */
    public final PIDOutput left = new PIDOutput() {
        @Override
        public void pidWrite (double output) {
            leftPower = output;
            update();
        }
    };

    /**
     * Right power PID output.
     */
    public final PIDOutput right = new PIDOutput() {
        @Override
        public void pidWrite (double output) {
            rightPower = output;
            update();
        }
    };
    
    /**
     * Creates a tank drive PID output.
     * @param drive Robot drive to use.
     */
    public TankDrivePIDOutput (RobotDrive drive) {
        this.drive = drive;
    }
    
    private synchronized void update () {
        this.drive.tankDrive(this.leftPower, this.rightPower);
    }
}
