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
            add("Geared Tank Drive", driveMode.add("Geared Tank Drive"));
            add("Arcade Drive", driveMode.add("Arcade Drive"));
            add("Stick Drive", driveMode.add("Stick Drive"));
            add("Servo Drive", driveMode.add("Servo Drive"));
            
            final DashboardTriggerChoice driveOn = new DashboardTriggerChoice("Drive On");
            add("Off", driveOn.add("Off"));
            add("On", driveOn.add("On"));
        }});
        this.set(new DataMap() {{
        	add("Scaling Factor", new DashboardData("Scaling Factor", 0.9D));
        	add("Test Setpoint 1", new DashboardData("Test Setpoint 1", 5D));
        	add("Test Setpoint 2", new DashboardData("Test Setpoint 2", 450D));
    		add("Test Setpoint 3", new DashboardData("Test Setpoint 3", 900D));
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
                define("right clicks", 0);
                define("left rate", 0);
                define("right rate", 0);
                define("elevator clicks", 0);
                define("current gear", 0);
                define("current multiplier", 0);
            }}) {
                public void run (ActionData data) {
                    SmartDashboard.putNumber("Elevator Clicks", data.get("elevator clicks"));
        			SmartDashboard.putNumber("Right Clicks", data.get("right clicks"));
        			SmartDashboard.putNumber("Left Clicks", data.get("left clicks"));
        			SmartDashboard.putNumber("Right Rate", data.get("right rate"));
        			SmartDashboard.putNumber("Left Rate", data.get("left rate"));
        			SmartDashboard.putInt("Current Gear", (int) data.get("current gear"));
        	    	SmartDashboard.putNumber("Current Multiplier", data.get("current multiplier"));
                }
            });
        }});
		SmartDashboard.putNumber("Right Clicks", 0);
    	SmartDashboard.putNumber("Right Rate", 0);
		SmartDashboard.putNumber("Left Clicks", 0);
		SmartDashboard.putNumber("Left Rate", 0);
    	SmartDashboard.putNumber("Elevator Clicks", 0);
    	SmartDashboard.putInt("Current Gear", 0);
    	SmartDashboard.putNumber("Current Multiplier", 0);
    }
}
