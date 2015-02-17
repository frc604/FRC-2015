package com._604robotics.robot2015.modules;

import com._604robotics.robotnik.action.Action;
import com._604robotics.robotnik.action.ActionData;
import com._604robotics.robotnik.action.controllers.StateController;
import com._604robotics.robotnik.module.Module;
import com._604robotics.robotnik.trigger.Trigger;
import com._604robotics.robotnik.trigger.TriggerMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;

public class Clamp extends Module {
	private final Solenoid piston = new Solenoid(1);
    private final Timer travelTimer = new Timer();
    
	public Clamp() {
		this.set(new TriggerMap() {{
            add("Travelling", new Trigger() {
                public boolean run () {
                    return travelTimer.get() < 0.6; //Placeholder travel time
                }
            });
            add("Open", new Trigger() {
            	public boolean run () {
            		return !piston.get() && getTrigger("Travelling").run();
            	}
            });
        }});
		
		this.set(new StateController () {{
	        addDefault("Open", new Action() {
	            public void begin (ActionData data) {
	                piston.set(false);
	                travelTimer.reset();
	            }
	        });
	        add("Close", new Action() {
	        	public void begin (ActionData data) {
	        	    piston.set(true);
	        	    travelTimer.reset();
	            }
	        });
		}});
	}	    
	
	protected void start () {
        travelTimer.start();
    }
    
    protected void end () {
        travelTimer.stop();
        travelTimer.reset();
    }
}
