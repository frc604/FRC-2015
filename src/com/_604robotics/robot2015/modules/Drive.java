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

import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.PIDSource.PIDSourceParameter;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// TODO: Auto-generated Javadoc
/**
 * The Class Drive.
 */
public class Drive extends Module {
	//19.6 to 18.6 inches per 100 ticks
	//-490/490 is 360 degrees with both wheels driving, 115 is 90 degrees
	
	// Locking a side: put it 18 in the opposite direction
	// 430 is 180 degrees with one side locked
	
	// When decreasing angle it needs a little bit less than you'd think
	
    /** The drive. */
    private final RobotDrive drive = new RobotDrive(0, 1, 2, 3);
    
    /** The encoder left. */
    private final Encoder encoderLeft = new Encoder(0, 1, true, CounterBase.EncodingType.k4X);
    
    /** The encoder right. */
    private final Encoder encoderRight = new Encoder(2, 3, false, CounterBase.EncodingType.k4X);
    
    private double PIDLeftOut = 0D;
    private double PIDRightOut = 0D;
    
    private double pid_power_cap = 0.6;
    
    /** The pid left. */
    private final PIDController pidLeft = new PIDController(0.020, 0D, 0.005, encoderLeft, new PIDOutput () {
        public void pidWrite (double output) {
        	if (output > 0) PIDLeftOut = (output > pid_power_cap) ? pid_power_cap : output;
        	else PIDLeftOut = (output < -pid_power_cap) ? -pid_power_cap : output;
        }
    });
    
    /** The pid right. */
    private final PIDController pidRight = new PIDController(0.020, 0D, 0.005, encoderRight, new PIDOutput () {
        public void pidWrite (double output) {
        	if (output > 0) PIDRightOut = (output > pid_power_cap) ? pid_power_cap : output;
        	else PIDRightOut = (output < -pid_power_cap) ? -pid_power_cap : output;
        }
    });
    
    /**
     * Instantiates a new drive.
     */
    public Drive () {
        encoderLeft.setPIDSourceParameter(PIDSourceParameter.kDistance);
        encoderRight.setPIDSourceParameter(PIDSourceParameter.kDistance);
        
        pidLeft.setAbsoluteTolerance(20);
        pidRight.setAbsoluteTolerance(20);
        
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
            	public void begin (ActionData data){
            		encoderLeft.reset();
            		encoderRight.reset();
            	}
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
            
            add("Servo Drive", new Action(new FieldMap() {{
                define("left clicks", 0D);
                define("right clicks", 0D);
                define("power cap", 0.6D);
            }}) {
            	double startLeftClicks;
            	double startRightClicks;
            	
                public void begin (ActionData data) {
                	pid_power_cap = data.get("power cap");
                	startLeftClicks = data.data("Left Drive Clicks");
                	startRightClicks = data.data("Right Drive Clicks");
                    pidLeft.setSetpoint(data.get("left clicks") + startLeftClicks);
                    pidRight.setSetpoint(data.get("right clicks") + startRightClicks);
                    pidLeft.enable();
                    pidRight.enable();
                }
                
                public void run (ActionData data){
                	if(pidLeft.getSetpoint() != data.get("left clicks") + startLeftClicks){
                		pidLeft.setSetpoint(data.get("left clicks") + startLeftClicks);
                	}
                	if(pidRight.getSetpoint() != data.get("right clicks") + startRightClicks){
                		pidRight.setSetpoint(data.get("right clicks") + startRightClicks);
                	}
                	drive.tankDrive(PIDLeftOut, PIDRightOut);
                }
                
                public void end (ActionData data) {
                    pidLeft.reset();
                    pidRight.reset();
                    pidLeft.disable();
                    pidRight.disable();
                }
            });
        }});
    }
}
