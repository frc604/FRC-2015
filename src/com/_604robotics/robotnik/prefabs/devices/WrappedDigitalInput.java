package com._604robotics.robotnik.prefabs.devices;

import edu.wpi.first.wpilibj.DigitalInput;

public class WrappedDigitalInput
{
    private final DigitalInput input;
    
    public WrappedDigitalInput (int channel)
    {
        input = new DigitalInput(channel);
    }
    public boolean getValue()
    {
        return input.get();
    }
}
