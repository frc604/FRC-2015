package com._604robotics.robot2015.modules;

import com._604robotics.robotnik.action.Action;
import com._604robotics.robotnik.action.ActionData;
import com._604robotics.robotnik.action.controllers.ElasticController;
import com._604robotics.robotnik.action.field.FieldMap;
import com._604robotics.robotnik.module.Module;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Timer;

public class Ultrasonic extends Module {
	private AnalogInput ai = new AnalogInput(0);
	private Timer t = new Timer();
	private boolean done = false;
	
	public Ultrasonic()
	{
		this.set(new ElasticController() {{
            addDefault("Off", new Action() {
                public void run(ActionData data) {
                	done = false;
                }
            });

            add("Ping", new Action(new FieldMap() {{
            }}) {
                public void run(ActionData data) {
                	int raw = ai.getValue();
                	if( !done )
                	{
                    	System.out.println(raw);
                	}
                	done = true;
                }
            });
        }});
	}
}
