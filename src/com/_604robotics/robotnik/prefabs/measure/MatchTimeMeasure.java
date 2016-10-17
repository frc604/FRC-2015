package com._604robotics.robotnik.prefabs.measure;

import com._604robotics.robotnik.coordinator.steps.Measure;

import edu.wpi.first.wpilibj.DriverStation;

/**
 * Measures match time, reporting completion when a duration has elapsed.
 */
public class MatchTimeMeasure extends Measure {
    private final double seconds;

    /**
     * Creates a match time measure.
     * @param seconds Target elapsed time to measure for.
     */
    public MatchTimeMeasure (double seconds) {
        this.seconds = seconds;
    }

    @Override
    public boolean complete () {
        return DriverStation.getInstance().getMatchTime() >= seconds;
    }
}
