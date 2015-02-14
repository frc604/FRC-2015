package com._604robotics.robot2015.modules;

import com._604robotics.robotnik.action.Action;
import com._604robotics.robotnik.action.ActionData;
import com._604robotics.robotnik.action.controllers.ElasticController;
import com._604robotics.robotnik.action.field.FieldMap;
import com._604robotics.robotnik.data.Data;
import com._604robotics.robotnik.data.DataMap;
import com._604robotics.robotnik.module.Module;
import com._604robotics.robotnik.trigger.Trigger;
import com._604robotics.robotnik.trigger.TriggerMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.PIDSource.PIDSourceParameter;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// TODO: Auto-generated Javadoc
/**
 * The Class Drive.
 */
public class Drive extends Module {
	
	/** The left. */
	private final Talon fLeft = new Talon(0);
	
	/** The r left. */
	private final Talon rLeft = new Talon(1);
	
	/** The right. */
	private final Talon fRight = new Talon(2);
	
	/** The r right. */
	private final Talon rRight = new Talon(3);
    
    /** The drive. */
    private final RobotDrive drive = new RobotDrive(fLeft, rLeft, fRight, rRight);
    
    /** The encoder left. */
    private final Encoder encoderLeft = new Encoder(2, 1);
    
    /** The encoder right. */
    private final Encoder encoderRight = new Encoder(3, 4);
    
    /** The pid left. */
    private final PIDController pidLeft = new PIDController(0.005, 0D, 0.005, encoderRight, new PIDOutput () {
        public void pidWrite (double output) {
            fLeft.set(output);
            rLeft.set(output);
        }
    });
    
    /** The pid right. */
    private final PIDController pidRight = new PIDController(0.005, 0D, 0.005, encoderRight, new PIDOutput () {
        public void pidWrite (double output) {
            fRight.set(output);
            rRight.set(output);
        }
    });
    
    /**
     * Instantiates a new drive.
     */
    public Drive () {
        encoderLeft.setPIDSourceParameter(PIDSourceParameter.kDistance);
        encoderRight.setPIDSourceParameter(PIDSourceParameter.kDistance);
        
        pidLeft.setAbsoluteTolerance(25);
        pidRight.setAbsoluteTolerance(25);
        SmartDashboard.putData("Left Drive PID", pidLeft);
        SmartDashboard.putData("Right Drive PID", pidRight);
        
        this.set(new DataMap() {{
            add("Left Drive Clicks", new Data() {
                public double run () {
                    return encoderLeft.get();
                }
            });
            
            add("Right Drive Clicks", new Data() {
                public double run () {
                    return encoderRight.get();
                }
            });
            
            add("Left Drive Rate", new Data() {
                public double run () {
                    return encoderLeft.getRate();
                }
            });
            
            add("Right Drive Rate", new Data() {
                public double run () {
                    return encoderRight.getRate();
                }
            });
        }});
        
        this.set(new TriggerMap() {{
            add("At Left Servo Target", new Trigger() {
                private final Timer timer = new Timer();
                private boolean timing = false;
                
                public boolean run () {
                    if (pidLeft.isEnable() && pidLeft.onTarget()) {
                        if (!timing) {
                            timing = true;
                            timer.start();
                        }
                        
                        return timer.get() >= 0.5;
                    } else {
                        if (timing) {
                            timing = false;
                            
                            timer.stop();
                            timer.reset();
                        }
                        
                        return false;
                    }
                }
            });
            add("At Right Servo Target", new Trigger() {
                private final Timer timer = new Timer();
                private boolean timing = false;
                
                public boolean run () {
                    if (pidRight.isEnable() && pidRight.onTarget()) {
                        if (!timing) {
                            timing = true;
                            timer.start();
                        }
                        
                        return timer.get() >= 0.5;
                    } else {
                        if (timing) {
                            timing = false;
                            
                            timer.stop();
                            timer.reset();
                        }
                        
                        return false;
                    }
                }
            });
        }});
        
        this.set(new ElasticController() {{
            addDefault("Off", new Action() {
                public void run (ActionData data) {
                    drive.tankDrive(0D, 0D);
                }
            });
            
            add("Arcade Drive", new Action(new FieldMap () {{
                define("throttle", 0D);
                define("turn", 0D);
            }}) {
                public void run (ActionData data) {
                    drive.arcadeDrive(data.get("throttle"), data.get("turn"));
                }
                
                public void end (ActionData data) {
                    drive.stopMotor();
                }
            });
            
            add("Tank Drive", new Action(new FieldMap () {{
                define("left", 0D);
                define("right", 0D);
            }}) {
                public void run (ActionData data) {
                    drive.tankDrive(data.get("left"), data.get("right"));
                }
                
                public void end (ActionData data) {
                    drive.stopMotor();
                }
            });
            
            add("Throttled Tank Drive", new Action(new FieldMap () {{
                define("left", 0D);
                define("right", 0D);
                define("throttle", 1D);
            }}) {
                public void run (ActionData data) {
                    drive.tankDrive(data.get("left")*data.get("throttle"), data.get("right")*data.get("throttle"));
                }
                
                public void end (ActionData data) {
                    drive.stopMotor();
                }
            });
            
            add("Stick Drive", new Action(new FieldMap () {{
                define("throttle", 0D);
                define("turn", 0D);
            }}) {
                public void run (ActionData data) {
                    drive.arcadeDrive(data.get("throttle"), data.get("turn"));
                }
                
                public void end (ActionData data) {
                    drive.stopMotor();
                }
            });
            
            add("Servo", new Action(new FieldMap() {{
                define("left clicks", 0D);
                define("right clicks", 0D);
            }}) {
                public void begin (ActionData data) {
                    pidLeft.setSetpoint(data.get("left clicks") + data.data("Left Drive Clicks"));
                    pidLeft.setSetpoint(data.get("right clicks") + data.data("Right Drive Clicks"));
                    pidLeft.enable();
                    pidRight.enable();
                }
                
                public void end (ActionData data) {
                    pidLeft.reset();
                    pidRight.reset();
                }
            });
        }});
    }
}
