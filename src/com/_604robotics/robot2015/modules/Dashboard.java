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
            add("Geared Tank Drive", driveMode.add("Geared Tank Drive"));
            add("Tank Drive", driveMode.addDefault("Tank Drive"));
            add("Arcade Drive", driveMode.add("Arcade Drive"));
            add("Stick Drive", driveMode.add("Stick Drive"));
            add("Servo Drive", driveMode.add("Servo Drive"));
            
            final DashboardTriggerChoice driveOn = new DashboardTriggerChoice("Drive On");
            add("Drive On", driveOn.add("Drive On"));
            add("Drive Off", driveOn.add("Drive Off"));
            
            final DashboardTriggerChoice autonOn = new DashboardTriggerChoice("Auton On");
            add("Auton On", autonOn.add("Auton On"));
            add("Auton Off", autonOn.add("Auton Off"));
            
            final DashboardTriggerChoice autonMode = new DashboardTriggerChoice("Auton Mode");
            add("Full Auton", autonMode.add("Full Auton"));
            add("Drive Only", autonMode.add("Drive Only"));
            
            final DashboardTriggerChoice debuggingOn = new DashboardTriggerChoice("Debugging On");
            add("Debugging Off", debuggingOn.add("Debugging Off"));
            add("Debugging On", debuggingOn.add("Debugging On"));
        }});
        this.set(new DataMap() {{
        	add("Scaling Factor", new DashboardData("Scaling Factor", 0.9D));
        	add("Tessellation Setpoint", new DashboardData("Tessellation Setpoint", 250D));
        	add("Trash Can Setpoint", new DashboardData("Trash Can Setpoint", 775D));
        	add("Trash Can Macro Setpoint", new DashboardData("Trash Can Macro Setpoint", 1680D));
        	add("Test Setpoint 1", new DashboardData("Test Setpoint 1", 5D));
        	add("Test Setpoint 1.5", new DashboardData("Test Setpoint 1.5", 500D));
        	add("Test Setpoint 2", new DashboardData("Test Setpoint 2", 1000D));
    		add("Test Setpoint 3", new DashboardData("Test Setpoint 3", 1850D));
        	/* Drive servo testing */
        	{
        		add("Left Drive Servo", new DashboardData("Left Drive Servo", -120D));
        		add("Right Drive Servo", new DashboardData("Right Drive Servo", -120D));
        		add("Drive Servo Power Cap", new DashboardData("Drive Servo Power Cap", 0.5D));
        	}
    	}});
    }
}
