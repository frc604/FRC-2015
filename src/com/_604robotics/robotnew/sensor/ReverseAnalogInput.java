package com._604robotics.robotnew.sensor;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.livewindow.LiveWindowSendable;

// for use in PIDs: ultrasonic distances decrease as you move forward, which 
// confuses PIDs. You're lazy, so here's an entire class that just returns
// opposites.
public class ReverseAnalogInput extends AnalogInput implements PIDSource, LiveWindowSendable{

	private int m_port = 0;
	
	public ReverseAnalogInput(int port)
	{
		super(port);
		this.m_port = port;
	}
	public double getVoltageOrig()
	{
		return super.getVoltage();
	}
	public int getValue() {
		return super.getValue() * -1;
	}
	public int getAverageValue() {
		return super.getAverageValue() * -1;
	}
	public double getVoltage() {
		return super.getVoltage() * -1;
	}
	public double getAverageVoltage() {
		return super.getAverageVoltage() * -1;
	}
	public double pidGet() {
		return super.pidGet() * -1;
	}
	public int getPort()
	{
		return this.m_port;
	}
	
}
