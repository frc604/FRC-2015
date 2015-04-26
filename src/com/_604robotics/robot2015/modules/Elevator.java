package com._604robotics.robot2015.modules;

import com._604robotics.robot2015.utils.AntiWindupPIDController;
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
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.PIDOutput;

public class Elevator extends Module {
	private final Talon motor = new Talon(4);
	private final Encoder encoder = new Encoder(4, 5, false, CounterBase.EncodingType.k4X);
	private final double TOP_CLICKS = 1750;
	private final double BOTTOM_CLICKS = 15;
	private final double INTAKE_CLOSED_BOTTOM = 300;
	private final double SLOW_ZONE_TOP = 150;
	private final double SLOW_ZONE_BOTTOM = 200;
	private final double SLOW_ZONE_AUTON_UP = 170;
	private final double SLOW_ZONE_AUTON_DOWN = 220;
	
	/* Rate control*/
	private final double NOMINAL_RATE = 650;
	private final double SLOW_RATE = 250;
	private final double MAX_RATE = 1500;
	private final double TOLERANCE = 50;
	private final double AUTO_RAMP_RATE = 0.04;
	private final double MANUAL_RAMP_RATE = 0.01;
	private final RateLimitedMotor rateLimitedMotor = new RateLimitedMotor(encoder, NOMINAL_RATE, MAX_RATE, TOLERANCE, motor);
	
    private final AntiWindupPIDController pid = 
    		new AntiWindupPIDController(0.0125, 0.005, Double.MAX_VALUE, 0.5, 0.0125, encoder, rateLimitedMotor);
	
	public Elevator() {
		SmartDashboard.putData("Elevator PID", pid);
		pid.setAbsoluteTolerance(12);
		encoder.setDistancePerPulse(1);
		encoder.reset();
		rateLimitedMotor.setRampRate(MANUAL_RAMP_RATE);
		
		this.set(new DataMap() {{
            add("Elevator Clicks", new Data() {
                public double run () {
                    return encoder.get();
                }
            });
            
            add("Elevator Rate", new Data() {
            	public double run() {
            		return encoder.getRate();
            	}
            });
        }});
		
        this.set(new TriggerMap() {{
            add("At Elevator Target", new Trigger() {
                private final Timer timer = new Timer();
                private boolean timing = false;
                
                public boolean run () {
                    if (pid.isEnable() && pid.onTarget()) {
                        if (!timing) {
                            timing = true;
                            timer.start();
                        }
                        
                        return timer.get() >= 0.25;
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
            
            add("Tote Lifted", new Trigger() {
            	public boolean run () {
            		if(encoder.get() > 250) return true;
            		else return false;
            	}
            });
        }});
        
        this.set(new ElasticController() {{
            addDefault("Manual", new Action(new FieldMap() {{
                define("power", 0D);
                define("force", false);
                define("calibrate", false);
                define("slow mode", false);
                define("intake open", false);
            }}) {
                public void run (ActionData data) {
                	if(data.get("power") == 0) {
                		rateLimitedMotor.stopped();
                	}
                	if(encoder.get() > TOP_CLICKS - SLOW_ZONE_TOP
                			|| encoder.get() <
                				(data.is("intake open") ? BOTTOM_CLICKS : INTAKE_CLOSED_BOTTOM)
                				+ SLOW_ZONE_BOTTOM
                			|| data.is("slow mode")) {
                		rateLimitedMotor.setRate(SLOW_RATE);
                	}
                	else {
                		rateLimitedMotor.setRate(NOMINAL_RATE);
                	}
                	if(data.is("force")){
                		if(data.is("slow mode")){
                			rateLimitedMotor.set(data.get("power"));
                		}
                		else{
                			motor.set(data.get("power"));
                		}
                	}
                	else if((encoder.get() < TOP_CLICKS || data.get("power") < 0) &&
                			(encoder.get() >
                				(data.is("intake open") ? BOTTOM_CLICKS : INTAKE_CLOSED_BOTTOM)
                				|| data.get("power") > 0)){
                		rateLimitedMotor.set(data.get("power"));
                	}
                	else {
                		motor.stopMotor();
                	}
                    if (data.is("calibrate"))
                        encoder.reset();
                }
                
                public void end (ActionData data) {
                    motor.stopMotor();
                }
            });
            
            add("Tessellation Setpoint", new AngleAction());
            add("Trash Can Setpoint", new AngleAction());
            add("Test Setpoint 1", new AngleAction());
            add("Test Setpoint 1.5", new AngleAction());
            add("Test Setpoint 2", new AngleAction());
            add("Test Setpoint 3", new AngleAction());
            
            add("Trash Can Macro Setpoint", new AngleAction());
            
            add("Hold", new Action() {
                public void begin (ActionData data) {
                    pid.setSetpoint(data.data("Elevator Clicks"));
                    pid.enable();
                }
                
                public void end (ActionData data) {
                    pid.reset();
                }
            });
        }});
    }
    
    private class AngleAction extends Action {
    	private boolean up = false; 
    	
        public AngleAction () {
            super(new FieldMap() {{
                define("clicks", 0D);
                define("intake open", true);
            }});
        }

        public void begin(ActionData data) {
        	rateLimitedMotor.stopped();
        	rateLimitedMotor.setRate(NOMINAL_RATE);
        	rateLimitedMotor.setRampRate(AUTO_RAMP_RATE);
        	if(data.is("intake open")){
        		pid.setSetpoint(data.get("clicks"));
        	}
        	else{
        		pid.setSetpoint((data.get("clicks") > INTAKE_CLOSED_BOTTOM) ?
        				data.get("clicks") : INTAKE_CLOSED_BOTTOM);
        	}
            pid.enable();
            if(pid.getSetpoint() > data.get("clicks")){
            	up = true;
            }
            else {
            	up = false;
            }
        }

        public void run(ActionData data) {
            if (Math.abs(pid.getSetpoint() - encoder.get()) < (up ? SLOW_ZONE_AUTON_UP : SLOW_ZONE_AUTON_DOWN)){
            	rateLimitedMotor.setRate(SLOW_RATE);
            }
            else {
            	rateLimitedMotor.setRate(NOMINAL_RATE);
            }
            if(data.is("intake open")){
            	if (data.get("clicks") != pid.getSetpoint()) {
            		pid.setSetpoint(data.get("clicks"));
            	}
        	}
        	else{
        		if (((data.get("clicks") > INTAKE_CLOSED_BOTTOM) ?
        				data.get("clicks") : INTAKE_CLOSED_BOTTOM) != pid.getSetpoint()){
        			pid.setSetpoint((data.get("clicks") > INTAKE_CLOSED_BOTTOM) ?
            				data.get("clicks") : INTAKE_CLOSED_BOTTOM);		
        		}
        	}
        }

        public void end(ActionData data) {
            pid.reset();
        	rateLimitedMotor.setRampRate(MANUAL_RAMP_RATE);
        }
    }
    
	private class RateLimitedMotor implements PIDOutput {
		private double maxRate;
		private double nominalRate;
		private double tolerance;
		private double maxPowerUp;
		private double maxPowerDown;
		private double rampRate;
		private Encoder encoder;
		private Talon motor;
		
		RateLimitedMotor(Encoder encoder, double nominalRate, double maxRate, double tolerance, Talon motor){
			this.encoder = encoder;
			this.motor = motor;
			this.maxRate = maxRate;
			this.nominalRate = nominalRate;
			this.tolerance = tolerance;
			this.maxPowerUp = 1;
			this.maxPowerDown = -1;
			this.rampRate = 0.05;
		}
		public void set(double power){
			if(encoder.getRate() > nominalRate && encoder.getRate() > 0) {
				maxPowerUp -= rampRate;
			}
			if(encoder.getRate() < nominalRate - tolerance && encoder.getRate() > 0) {
				maxPowerUp += rampRate;
			}
			if(encoder.getRate() < -nominalRate && encoder.getRate() < 0) {
				maxPowerDown += rampRate;
			}
			if(encoder.getRate() > -nominalRate + tolerance && encoder.getRate() < 0) {
				maxPowerDown -= rampRate;
			}
			if(encoder.getRate() >= 0) {
				maxPowerDown -= rampRate;
			}
			if(encoder.getRate() <= 0) {
				maxPowerUp += rampRate;
			}
			if(maxPowerUp > 1) {
				maxPowerUp = 1;
			}
			if(maxPowerDown < -1) {
				maxPowerDown = -1;
			}
			motor.set((power > 0) ? 
					((power > maxPowerUp) ? maxPowerUp : power) :
					((power < maxPowerDown) ? maxPowerDown : power));
		}
		public void stopped(){
			maxPowerUp = 0.1;
			maxPowerDown = 0;
			motor.stopMotor();
		}
		public void setRate(double nominalRate){
			this.nominalRate = nominalRate;
		}
		public void setRampRate(double rampRate){
			this.rampRate = rampRate;
		}
		public void pidWrite(double output) {
			set(output);
		}
	}
}
