package com._604robotics.robotnik.logging;

import com._604robotics.robotnik.logging.Logger;
import edu.wpi.first.wpilibj.Timer;

/**
 * Samples operation time, logging it to the console.
 */
public class TimeSampler {
    private final Timer timer = new Timer();
    private final String name;
    private final double time;
    private int samples;

    /**
     * Creates a time sampler.
     * @param name Name of the sampler.
     * @param time Time between each line of console output.
     */
    public TimeSampler (String name, double time) {
        this.name = name;
        this.time = time;
    }

    /**
     * Starts sampling.
     */
    public void start () {
        this.samples = 0;
        this.timer.start();
    }

    /**
     * Samples time.
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
     * Stops sampling.
     */
    public void stop () {
        this.timer.stop();
        this.timer.reset();
    }
}
