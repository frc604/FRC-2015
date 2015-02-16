package com._604robotics.robot2015.modules;

import com._604robotics.robotnik.action.Action;
import com._604robotics.robotnik.action.ActionData;
import com._604robotics.robotnik.action.controllers.StateController;
import com._604robotics.robotnik.module.Module;

import edu.wpi.first.wpilibj.Solenoid;

public class Clamp extends Module {
	private final Solenoid piston = new Solenoid(4);
	public Clamp() {
		this.set(new StateController () {{
	        addDefault("Close", new Action() {
	            public void begin (ActionData data) {
	                piston.set(false);
	            }
	        });
		    }});
		
	    this.set(new StateController () {{
	        add("Open", new Action() {
	        	public void begin (ActionData data) {
	        	    piston.set(true);          
	            }
	        });
	        }});
	    
	    this.set(new StateController () {{
	        add("Close", new Action() {
	        	public void begin (ActionData data) {
	        	    piston.set(false);          
	            }
	        });
	        }});
	 
	}	    
}
