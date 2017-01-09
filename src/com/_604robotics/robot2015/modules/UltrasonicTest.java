package com._604robotics.robot2015.modules;

import com._604robotics.robotnik.action.Action;
import com._604robotics.robotnik.action.ActionData;
import com._604robotics.robotnik.action.controllers.ElasticController;
import com._604robotics.robotnik.module.Module;

import edu.wpi.first.wpilibj.AnalogInput;

public class UltrasonicTest extends Module {
	private final AnalogInput ai = new AnalogInput(0 /* Not real port */);
	
	public UltrasonicTest() {
		this.set(new ElasticController () {{
	        addDefault("Off", new Action() {
	            public void begin (ActionData data) {
	            }
	        });
	        add("Ping", new Action() {
	        	public void begin (ActionData data) {
	        		
	        	    int raw = ai.getValue();
	        	    System.out.println("range");
	            }
	        });
		}});
	}

}
