package com._604robotics.robot2015.modules;

import com._604robotics.robotnew.sensor.ReverseAnalogUltrasonic;
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
import edu.wpi.first.wpilibj.PIDSourceType;
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
    //private final RobotDrive drive = new RobotDrive(0, 1, 2, 3);
	private final RobotDrive drive = new RobotDrive(6, 7, 8, 9);
    
    //i=0 // TEMP
    /** The encoder left. */
    
    //private final Encoder encoderLeft = new Encoder(0, 1, true, CounterBase.EncodingType.k4X);
    
    /** The encoder right. */
    //private final Encoder encoderRight = new Encoder(2, 3, false, CounterBase.EncodingType.k4X);
    
    private final ReverseAnalogUltrasonic ultra = new ReverseAnalogUltrasonic(0);
    
    //private double PIDLeftOut = 0D;
    //private double PIDRightOut = 0D;
    private double PIDUltraOut = 0D;
        
    private double pid_power_cap = 0.6;
    
    /** The pid left. */
    /*
    private final PIDController pidLeft = new PIDController(0.020, 0D, 0.005, encoderLeft, new PIDOutput () {
        public void pidWrite (double output) {
        	if (output > 0) PIDLeftOut = (output > pid_power_cap) ? pid_power_cap : output;
        	else PIDLeftOut = (output < -pid_power_cap) ? -pid_power_cap : output;
        }
    });
    */
    /** The pid right. */
    
    /*private final PIDController pidRight = new PIDController(0.020, 0D, 0.005, encoderRight, new PIDOutput () {
        public void pidWrite (double output) {
        	if (output > 0) PIDRightOut = (output > pid_power_cap) ? pid_power_cap : output;
        	else PIDRightOut = (output < -pid_power_cap) ? -pid_power_cap : output;
        }
    });
    */
    private final PIDController pidUltra = new PIDController(0.020, 0D, 0.005, ultra, new PIDOutput () {
        public void pidWrite (double output) {
        	if (output > 0) PIDUltraOut = (output > pid_power_cap) ? pid_power_cap : output;
        	else PIDUltraOut = (output < -pid_power_cap) ? -pid_power_cap : output;
        }
    });
    
    /**
     * Instantiates a new drive.
     */
    public Drive () {
        //encoderLeft.setPIDSourceType(PIDSourceType.kDisplacement);
        //encoderRight.setPIDSourceType(PIDSourceType.kDisplacement);
        ultra.setPIDSourceType(PIDSourceType.kDisplacement);
        
        //pidLeft.setAbsoluteTolerance(20);
        //pidRight.setAbsoluteTolerance(20);
        pidUltra.setAbsoluteTolerance(0.0235);
        
        //SmartDashboard.putData("Left Drive PID", pidLeft);
        //SmartDashboard.putData("Right Drive PID", pidRight);
        SmartDashboard.putData("Ultra PID", pidUltra);
        
        this.set(new DataMap() {{
            /*
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
            */
            add("Inches", new Data() {
            	public double run() {
            		double aV = ultra.getInches();            		
             		return aV;
            	}
            });
            add("Voltage", new Data() {
            	public double run() {
            		double aV = ultra.getVoltage();
            		return aV;
            	}
            });
            add("Raw", new Data() {
            	public double run() {
            		double aT = ultra.getValue();
             		return aT;
            	}
            });
            add("Error", new Data() {
            	public double run() {
            		return pidUltra.getError();
            	}
            });
        }});
        
        this.set(new TriggerMap() {{
            /*
        	add("At Left Servo Target", new Trigger() {
                private final Timer timer = new Timer();
                private boolean timing = false;
                
                public boolean run () {
                    if (pidLeft.isEnabled() && pidLeft.onTarget()) {
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
                    if (pidRight.isEnabled() && pidRight.onTarget()) {
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
            */
            add("At Ultra Target", new Trigger() {
                private final Timer timer = new Timer();
                private boolean timing = false;
                public boolean run () {
                	if( pidUltra.isEnabled() && pidUltra.onTarget() )
                	{
                		if( !timing )
                		{
                			timing = true;
                			timer.start();
                		}
                		return timer.get() >= 1;
                	}
                	else
                	{
                		if( timing )
                		{
                			timing = false;
                			timer.stop();
                			timer.reset();
                		}
                	}
                	return false;
                }
            });
            add("Past Ultra Target", new Trigger() {
            	public boolean run()
            	{
            		return ultra.getInches() > -50.0;
            	}
            });
            add("Always False", new Trigger() {
            	public boolean run()
            	{
            		return false;
            	}
            });
        }});
        
        this.set(new ElasticController() {{
            addDefault("Off", new Action() {
            	public void begin (ActionData data){
            		//encoderLeft.reset();
            		//encoderRight.reset();
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
            
            add("Dynamic Drive", new Action(new FieldMap () {{
                define("leftY", 0D);
                define("leftX", 0D);
                define("rightY", 0D);
                define("rightX", 0D);
                define("doTank", 1D);
                define("doArcade",0D);
            }}) {
                public void run (ActionData data) {
                	//i++;
                	//if triggerstuff.get("isTank")
                    if( data.get("doTank")==1 )
                    {
                    	drive.tankDrive(data.get("leftY"), data.get("rightY"));
                    }
                    //else
                    //if triggerstuff.get("isArcade")
                    if( data.get("doArcade")==1 )
                    {
                    	drive.arcadeDrive(data.get("leftY"), data.get("rightX"));
                    }
                }
                
                public void end (ActionData data) {
                    drive.stopMotor();
                    //i=0;
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
            /*
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
            */
            add( "Just Drive", new Action(new FieldMap() {{
            }}) {
            	public void run(ActionData data)
            	{
            		drive.tankDrive(0, 0);
            	}
            	public void end(ActionData data) {
            		drive.stopMotor();
            	}
            });
            add("Ultra Drive", new Action(new FieldMap() {{
                define("inches", 0D);
                define("power cap", 0.6D);
            }}) {
            	
                public void begin (ActionData data) {
                	pid_power_cap = data.get("power cap");
                    pidUltra.setSetpoint(data.get("inches")/-42.56);
                    pidUltra.enable();
                }
                
                public void run (ActionData data){
                	if(pidUltra.getSetpoint() != data.get("inches")/-42.56){
                		pidUltra.setSetpoint(data.get("inches")/-42.56);
                	}
                	drive.tankDrive(PIDUltraOut, PIDUltraOut);
                }
                
                public void end (ActionData data) {
                	drive.stopMotor();
                    pidUltra.reset();
                    pidUltra.disable();
                }
            });
        add("Ultra Oscil", new Action(new FieldMap() {{
            define("inches", 0D);
        }}) {
            
            public void run (ActionData data){
            	// at half distance, half power
            	// so like
            	// > 24 inches, 0.8 power
            	// > 12 inches, 0.4 power
            	// > 6 inches, 0.2 power
            	// > 3 inches, 0.1 power
            	// > 1 inches, 0.05 power
            	if( ultra.getInches() < -(data.get("inches")+24) )
            	{
            		drive.tankDrive(0.8, 0.8);
            	}
            	else if( ultra.getInches() < -(data.get("inches")+12) )
            	{
            		drive.tankDrive(0.4, 0.4);
            	}
            	else if( ultra.getInches() < -(data.get("inches")+6) )
            	{
            		drive.tankDrive(0.2, 0.2);
            	}
            	else if( ultra.getInches() < -(data.get("inches")+3) )
            	{
            		drive.tankDrive(0.1, 0.1);
            	}
            	else if( ultra.getInches() < -(data.get("inches")+1) )
            	{
            		drive.tankDrive(0.05, 0.05);
            	}
            	else if( ultra.getInches() > -(data.get("inches")-1) )
            	{
            		drive.tankDrive(-0.05, -0.05);
            	}
            	else if( ultra.getInches() > -(data.get("inches")-3) )
            	{
            		drive.tankDrive(-0.1, -0.1);
            	}
            	else if( ultra.getInches() > -(data.get("inches")-6) )
            	{
            		drive.tankDrive(-0.2, -0.2);
            	}
            	else if( ultra.getInches() > -(data.get("inches")-12) )
            	{
            		drive.tankDrive(-0.4, -0.4);
            	}
            	else if( ultra.getInches() > -(data.get("inches")-24) )
            	{
            		drive.tankDrive(-0.8, -0.8);
            	}
            	else
            	{
            		drive.stopMotor();
            	}
            }
            
            public void end (ActionData data) {
            	drive.stopMotor();
            }
        });
     }});

    }
}
