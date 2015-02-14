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
            add("Stick Drive", driveMode.add("Stick Drive"));
            add("Off", driveMode.add("Off"));
        }});
        this.set(new DataMap() {{
        	add("Throttle", new DashboardData("Throttle", 1D));
    	}});
        this.set(new ElasticController() {{
        	addDefault("Resting", new Action() {
        	});
        	addDefault("Display", new Action(new FieldMap () {{
                define("dpad", -1000);
            }}) {
        		public void begin (ActionData data) {
        	    	SmartDashboard.putNumber("Dpad Testing", -1000D);
        		}
                public void run (ActionData data) {
                    SmartDashboard.putNumber("Dpad Testing", data.get("dpad"));
                }
            });
        }});
    }
}
