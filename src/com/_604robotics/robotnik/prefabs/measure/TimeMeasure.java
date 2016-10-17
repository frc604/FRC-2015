package com._604robotics.robotnik.prefabs.measure;

import com._604robotics.robotnik.coordinator.steps.Measure;

import edu.wpi.first.wpilibj.Timer;

/**
 * Measures time, reporting completion when a duration has elapsed.
 */
public class TimeMeasure extends Measure {
    private final Timer timer = new Timer();
    private final double seconds;

    /**
     * Creates a time measure.
     * @param seconds Target elapsed time to measure for.
     */
    public TimeMeasure (double seconds) {
        this.seconds = seconds;
    }

    @Override
    public void initialize() {
        timer.reset();
        timer.start();
    }

    @Override
    public boolean complete () {
        final boolean complete = timer.get() > seconds;
        if (complete)
            timer.stop();
        return complete;
    }
}
