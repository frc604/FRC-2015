package com._604robotics.robot2015.modules;

import com._604robotics.robot2015.DriveSwitch;
import com._604robotics.robotnik.action.Action;
import com._604robotics.robotnik.action.ActionData;
import com._604robotics.robotnik.action.controllers.ElasticController;
import com._604robotics.robotnik.action.field.FieldMap;
import com._604robotics.robotnik.data.Data;
import com._604robotics.robotnik.data.DataMap;
import com._604robotics.robotnik.module.Module;
import com._604robotics.robotnik.trigger.Trigger;
import com._604robotics.robotnik.trigger.TriggerMap;

public class DynamicToggle extends Module {
	private DriveSwitch driveChange=DriveSwitch.TANK;
	
    public DynamicToggle () {
    	this.set(new TriggerMap() {{
    		add("inTank", new Trigger() {
    			public boolean run() {
    				return driveChange==DriveSwitch.TANK;
    			}
    		});
    		add("inArcade", new Trigger() {
    			public boolean run() {
    				return driveChange==DriveSwitch.ARCADE;
    			}
    		});
    	}});
    	this.set(new DataMap() {{
    		add("inTankData",new Data() {
    			public double run() {
    				if (driveChange==DriveSwitch.TANK) {
    					return 1;
    				}
    				else {
    					return 0;
    				}
    			}
    		});
    		add("inArcadeData",new Data() {
    			public double run() {
    				if (driveChange==DriveSwitch.ARCADE) {
    					return 1;
    				}
    				else {
    					return 0;
    				}
    			}
    		});
    	}});
        this.set(new ElasticController() {{
            addDefault("Check", new Action(new FieldMap () {{
            	define("rightY", 0D);
            	define("rightX", 0D);
            }}) {
				public void begin (ActionData data) {
            		driveChange = DriveSwitch.TANK;
            	}
            	public void run (ActionData data) {
            		if( driveChange==DriveSwitch.TANK )
            		{
            			if( Math.abs(data.get("rightY")) <= 0.2 && Math.abs(data.get("rightX")) > 0.3 )
            			{
            				driveChange=DriveSwitch.ARCADE;
            			}
            		}
            		else //if( driveChange==DriveSwitch.ARCADE )
            		{
            			if( Math.abs(data.get("rightX")) <= 0.2 && Math.abs(data.get("rightY")) > 0.3 )
            			{
            				driveChange=DriveSwitch.TANK;
            			}
            		}
            	}
            });
        }});
    }
}
