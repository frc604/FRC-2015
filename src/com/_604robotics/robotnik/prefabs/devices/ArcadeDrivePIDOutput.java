package com._604robotics.robotnik.prefabs.devices;

import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.RobotDrive;

/**
 * PID output for arcade drive.
 */
public class ArcadeDrivePIDOutput {
    private final RobotDrive drive;
    
    private double movePower = 0D;
    private double rotatePower = 0D;

    /**
     * Move power PID output.
     */
    public final PIDOutput move = new PIDOutput() {
        @Override
        public void pidWrite (double output) {
            movePower = output;
            update();
        }
    };

    /**
     * Rotate power PID output.
     */
    public final PIDOutput rotate = new PIDOutput() {
        @Override
        public void pidWrite (double output) {
            rotatePower = output;
            update();
        }
    };
    
    /**
     * Creates an arcade drive PID output.
     * @param drive Robot drive to use.
     */
    public ArcadeDrivePIDOutput (RobotDrive drive) {
        this.drive = drive;
    }
    
    private synchronized void update () {
        this.drive.arcadeDrive(this.movePower, this.rotatePower);
    }
}
