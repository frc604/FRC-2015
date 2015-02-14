package com._604robotics.robotnik.logging;

import com._604robotics.robotnik.logging.Logger;
import edu.wpi.first.wpilibj.Timer;

// TODO: Auto-generated Javadoc
/**
 * The Class TimeSampler.
 */
public class TimeSampler {
    
    /** The timer. */
    private final Timer timer = new Timer();
    
    /** The name. */
    private final String name;
    
    /** The time. */
    private final double time;
    
    /** The samples. */
    private int samples;
    
    /**
     * Instantiates a new time sampler.
     *
     * @param name the name
     * @param time the time
     */
    public TimeSampler (String name, double time) {
        this.name = name;
        this.time = time;
    }
    
    /**
     * Start.
     */
    public void start () {
        this.samples = 0;
        this.timer.start();
    }
    
    /**
     * Sample.
     */
    public void sample () {
        this.samples++;
        
        if (this.timer.get() >= this.time) {
            Logger.log(" --- " + name + " time: " + Math.round((this.timer.get() / this.samples) * 1000) + " ms (" + this.samples + " loops / second)");

            this.samples = 0;
            this.timer.reset();
        }
    }
    
    /**
     * Stop.
     */
    public void stop () {
        this.timer.stop();
        this.timer.reset();
    }
}
