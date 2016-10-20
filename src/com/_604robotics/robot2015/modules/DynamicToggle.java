package com._604robotics.robot2015.modules;

import com._604robotics.robot2015.GlobalVariables;
import com._604robotics.robotnik.action.Action;
import com._604robotics.robotnik.action.ActionData;
import com._604robotics.robotnik.action.controllers.ElasticController;
import com._604robotics.robotnik.action.field.FieldMap;
import com._604robotics.robotnik.module.Module;

public class DynamicToggle extends Module {
    
    public DynamicToggle () {
        this.set(new ElasticController() {{
            addDefault("Check", new Action(new FieldMap () {{
            	define("rightY", 0D);
            	define("rightX", 0D);
            }}) {
            	public void run (ActionData data) {
            		if( GlobalVariables.tankLast )
            		{
            			if( data.get("rightY") == 0 && Math.abs(data.get("rightX")) > 0 )
            			{
            				GlobalVariables.tankLast = false;
            				GlobalVariables.arcadeLast = true;
            			}
            		}
            		else if( GlobalVariables.arcadeLast )
            		{
            			if( data.get("rightX") == 0 && Math.abs(data.get("rightY")) > 0 )
            			{
            				GlobalVariables.tankLast = true;
            				GlobalVariables.arcadeLast = false;
            			}
            		}
            	}
            });
        }});
    }
}
