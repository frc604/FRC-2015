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

public class Elevator extends Module {
	private final Talon motor = new Talon(4);
	private final Encoder encoder = new Encoder(4, 5, false, CounterBase.EncodingType.k4X);
	private final double TOP_CLICKS = 900;	//TODO: determine actual value of MAXTICKS
	
    private final AntiWindupPIDController pid = new AntiWindupPIDController(0.0125, 0, Double.MIN_VALUE, -0.5, 0.0125, encoder, motor);
	
	public Elevator() {
		SmartDashboard.putData("Elevator PID", pid);
		pid.setPercentTolerance(5.0D);
		encoder.reset();
		
		this.set(new DataMap() {{
            add("Elevator Clicks", new Data() {
                public double run () {
                    return encoder.get();
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
        }});
        
        this.set(new ElasticController() {{
            addDefault("Manual", new Action(new FieldMap() {{
                define("power", 0D);
                define("calibrate", false);
            }}) {
                public void run (ActionData data) {
                	if(encoder.get() < TOP_CLICKS - data.get("power") * 150 
                			|| data.get("power") < 0) motor.set(data.get("power"));
                	else motor.stopMotor();
                    if (data.is("calibrate"))
                        encoder.reset();
                }
                
                public void end (ActionData data) {
                    motor.stopMotor();
                }
            });
            
            add("Test Setpoint 1", new AngleAction());
            add("Test Setpoint 2", new AngleAction());
            add("Test Setpoint 3", new AngleAction());
            
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
        public AngleAction () {
            super(new FieldMap() {{
                define("clicks", 0D);
            }});
        }

        public void begin(ActionData data) {
            pid.setSetpoint(data.get("clicks"));
            pid.enable();
        }

        public void run(ActionData data) {
            final double setpoint = data.get("clicks");
            if (setpoint != pid.getSetpoint()) {
                pid.setSetpoint(setpoint);
            }
        }

        public void end(ActionData data) {
            pid.reset();
        }
    }
}
