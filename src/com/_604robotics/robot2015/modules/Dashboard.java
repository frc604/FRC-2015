package com._604robotics.robot2015.modules;

import com._604robotics.robotnik.action.Action;
import com._604robotics.robotnik.action.ActionData;
import com._604robotics.robotnik.action.controllers.ElasticController;
import com._604robotics.robotnik.data.DataMap;
import com._604robotics.robotnik.data.sources.DashboardData;
import com._604robotics.robotnik.module.Module;
import com._604robotics.robotnik.trigger.TriggerMap;
import com._604robotics.robotnik.trigger.sources.DashboardTriggerChoice;
import com._604robotics.robotnik.action.field.FieldMap;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// TODO: Auto-generated Javadoc
/**
 * The Class Dashboard.
 */
public class Dashboard extends Module {
    
    /**
     * Instantiates a new dashboard.
     */
    public Dashboard () {
        this.set(new TriggerMap() {{
            final DashboardTriggerChoice driveMode = new DashboardTriggerChoice("Drive Mode");
            add("Tank Drive", driveMode.addDefault("Tank Drive"));
            add("Throttled Tank Drive", driveMode.add("Throttled Tank Drive"));
            add("Arcade Drive", driveMode.add("Arcade Drive"));
            add("Servo Drive", driveMode.add("Servo Drive"));
            add("Off", driveMode.add("Off"));
        }});
        this.set(new DataMap() {{
        	add("Throttle", new DashboardData("Throttle", 1D));
        	add("Manual Setpoint", new DashboardData("Manual Setpoint", 0D));
        	/* Drive servo testing */
        	{
        		add("Left Drive Servo", new DashboardData("Left Drive Servo", 0D));
        		add("Right Drive Servo", new DashboardData("Right Drive Servo", 0D));
        	}
    	}});
        this.set(new ElasticController() {{
        	addDefault("Resting", new Action() {
        	});
        	addDefault("Display", new Action(new FieldMap () {{
                define("left clicks", 0);
                define("elevator clicks", 0);
            }}) {
        		public void begin (ActionData data) {
        	    	SmartDashboard.putNumber("Left Clicks", 0);
        	    	SmartDashboard.putNumber("Elevator Clicks", 0);
        		}
                public void run (ActionData data) {
                    SmartDashboard.putNumber("Elevator Clicks", data.get("elevator clicks"));
                }
            });
        }});
    }
}
