package com._604robotics.robot2015.modules;

import com._604robotics.robotnik.action.Action;
import com._604robotics.robotnik.action.ActionData;
import com._604robotics.robotnik.action.controllers.ElasticController;
import com._604robotics.robotnik.action.field.FieldMap;
import com._604robotics.robotnik.data.Data;
import com._604robotics.robotnik.data.DataMap;
import com._604robotics.robotnik.module.Module;

import edu.wpi.first.wpilibj.AnalogInput;

// Raw Value: 20 rv = 1 inch
// Effective Range: ~11.8" - 16.5"
// Accuracy: +- rv (0.25")
// Set sensors 5.2" behind the bumper.

public class Ultrasonic extends Module {
	private AnalogInput ai = new AnalogInput(0);
	private double inches = 0;
	private double VpI = 5.0/512;
	private boolean convert = false;
	
	public Ultrasonic()
	{
		this.set(new DataMap()  {{
			add("Inches", new Data() {
                public double run () {
                    return inches;
                }
            });
		}});
		this.set(new ElasticController() {{
            addDefault("Off", new Action() {
                public void run(ActionData data) {
                	
                }
            });
            add("Average", new Action(new FieldMap() {{
            }}) {
            	public void run(ActionData data) {
            		double total = 0;
            		for( int f=0; f<128; f++ )
            		{
            			total += ai.getVoltage();
            		}
            		double aV = total/128;
            		inches = aV;
            		if( convert )
            		{
            			inches = aV/VpI;
            		}
            		System.out.println(inches);
            	}
            });
            add("Norm", new Action(new FieldMap() {{            	
            }}) {
            	public void run(ActionData data) {
            		double mV = ai.getVoltage();
            		inches = mV;
            		if( convert )
            		{
            			inches = mV/VpI;
            		}
            		System.out.println(inches);
            }});
            add("Analog", new Action(new FieldMap() {{            	
            }}) {
            	public void run(ActionData data) {
            		inches = ai.getAverageValue();
            		System.out.println(inches);
            }});
            add("Weird", new Action(new FieldMap() {{
            }}) {
                public void run(ActionData data) {
                  	ai.setAverageBits(10);
                  	ai.setOversampleBits(10);
                	inches = ai.getAverageValue()* 5 * 0.0393701;
               		System.out.println(inches);
                }
            });
        }});
		
	}
}
