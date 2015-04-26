package com._604robotics.robot2015.modules;

import com._604robotics.robotnik.action.Action;
import com._604robotics.robotnik.action.ActionData;
import com._604robotics.robotnik.action.controllers.ElasticController;
import com._604robotics.robotnik.action.field.FieldMap;
import com._604robotics.robotnik.trigger.Trigger;
import com._604robotics.robotnik.trigger.TriggerMap;
import com._604robotics.robotnik.module.Module;

public class CanMacro extends Module {
	
    private int stage = -1;
    
    public CanMacro () {
        this.set(new TriggerMap() {{
            add("Moving To Start", new Trigger() {
                public boolean run () {
                    return stage == 0;
                }
            });
            
            add("Dropping Can", new Trigger() {
                public boolean run () {
                    return stage == 1;
                }
            });
            
            add("Backing Up", new Trigger() {
            	public boolean run() {
            		return stage == 2;
            	}
            });
        }});
        
        this.set(new ElasticController() {{
            addDefault("Not Active", new Action());
            
            add("Active", new Action(new FieldMap() {{
                define("at elevator target", false);
                define("at left servo target", false);
            }}) {
                public void begin (ActionData data) {
                    stage = 0;
                }
                public void run (ActionData data){
                	if(data.is("at elevator target")){
                		stage++;
                	}
                }
                public void end (ActionData data){
                	stage = -1;
                }
            });
        }});
    }
}
