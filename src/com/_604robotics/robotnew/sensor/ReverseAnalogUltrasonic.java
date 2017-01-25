package com._604robotics.robotnew.sensor;

import edu.wpi.first.wpilibj.AnalogInput;

// a more intuitive method of using ultrasonic sensors plugged into analog ports
// overwrites and overloads getValue and getVoltage to return more accurate values
// this one returns the value, except negative, to help PIDs.
public class ReverseAnalogUltrasonic extends ReverseAnalogInput {

	private int m_port = 0;
	private final double INCHES_PER_VOLT = 42.56;
	
	public ReverseAnalogUltrasonic(int port)
	{
		super(port);
		this.m_port = port;
	}
	// default getValue, returns analog value sampled 256 times and averaged
	public int getValue()
	{
		int averageValue = 0;
		int total = 0;
		for( int f=0; f<256; f++ )
		{
			total += super.getValue();
		}
		averageValue = total / 256;
		return averageValue;
	}
	// getValue except with custom sample size
	// a value of at the very least 64 is recommended, as the sensor reads at kHz
	public int getValue(int sample)
	{
		int averageValue = 0;
		int total = 0;
		for( int f=0; f<sample; f++ )
		{
			total += super.getValue();
		}
		averageValue = total / sample;
		return averageValue;
	}
	public double getVoltage()
	{
		double averageVoltage = 0;
		double total = 0;
		for( int f=0; f<256; f++ )
		{
			total += super.getVoltage();
		}
		averageVoltage = total/256;
		return averageVoltage;
	}
	public double getVoltage(int sample)
	{
		double averageVoltage = 0;
		double total = 0;
		for( int f=0; f<sample; f++ )
		{
			total += super.getVoltage();
		}
		averageVoltage = total / sample;
		return averageVoltage;
	}
	public double getInches()
	{
		return (double) getValue() * this.INCHES_PER_VOLT;
	}
	public double getInches(int sample)
	{
		return (double) getValue(sample) * this.INCHES_PER_VOLT;
	}
	public double pidGet()
	{
		return getVoltage();
	}
	public double pidGet(int sample)
	{
		return getVoltage(sample);
	}
	public int getPort()
	{
		return this.m_port; 
	}
}
