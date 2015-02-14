package com._604robotics.robot2015.modules;

import com._604robotics.robotnik.action.Action;
import com._604robotics.robotnik.action.ActionData;
import com._604robotics.robotnik.action.controllers.ElasticController;
import com._604robotics.robotnik.module.Module;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;

public class Elevator extends Module {
	private final Talon motor = new Talon(4); //Placeholder Talon position
	private final Encoder encoder = new Encoder(1, 2);	//TODO: encoder, channels TBD
	private final double MAXTICKS = 100;	//TODO: determine actual value of MAXTICKS
	private final double MINTICKS = 0;	//TODO: determine actual value of MINTICKS, probably still 0
	
	public Elevator() {
		encoder.reset();
		
        this.set(new ElasticController() {{
            addDefault("Off", new Action() {
                public void run(ActionData data) {
                    motor.stopMotor();
                }
            });

            add("Up", new Action() {
                public void run(ActionData data) {
                    /*while(encoder.get() <= MAXTICKS) {	//
                    	motor.set(1D);					// new code
                    }*/									//
                }

                public void end(ActionData data) {
                    motor.stopMotor();
                }
            });
            add("Down", new Action() {
                public void run(ActionData data) {
                    motor.set(-1D);
                }
                public void end(ActionData data){
                    motor.stopMotor();
                }
            });
        }});
	}
}
