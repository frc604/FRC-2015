package com._604robotics.robot2015.modules;

import com._604robotics.robotnik.action.Action;
import com._604robotics.robotnik.action.ActionData;
import com._604robotics.robotnik.action.controllers.ElasticController;
import com._604robotics.robotnik.action.field.FieldMap;
import com._604robotics.robotnik.module.Module;

import edu.wpi.first.wpilibj.AnalogInput;

// Raw Value: 20 rv = 1 inch
// Effective Range: ~11.8" - 16.5"
// Accuracy: +- rv (0.25")
// Set sensors 5.2" behind the bumper.

public class Ultrasonic extends Module {
	private AnalogInput ai = new AnalogInput(0);
	
	public Ultrasonic()
	{
		ai.setOversampleBits(64);
		this.set(new ElasticController() {{
            addDefault("Off", new Action() {
                public void run(ActionData data) {
                	
                }
            });

            add("Ping", new Action(new FieldMap() {{
            }}) {
                public void run(ActionData data) {
                	int total = 0;
                	for( int f=0; f<64; f++ )
                	{
                		total += ai.getValue();
                	}
                	
                	int avRaw = (int) total/64;
                	System.out.println(avRaw);
                }
            });
        }});
	}
}
