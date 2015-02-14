package com._604robotics.robotnik.prefabs.measure;

import com._604robotics.robotnik.procedure.Measure;
import edu.wpi.first.wpilibj.DriverStation;

// TODO: Auto-generated Javadoc
/**
 * The Class MatchTimeMeasure.
 */
public class MatchTimeMeasure extends Measure {
    
    /** The seconds. */
    private final double seconds;

    /**
     * Instantiates a new match time measure.
     *
     * @param seconds the seconds
     */
    public MatchTimeMeasure (double seconds) {
        this.seconds = seconds;
    }

    /* (non-Javadoc)
     * @see com._604robotics.robotnik.procedure.Measure#complete()
     */
    public boolean complete () {
        return DriverStation.getInstance().getMatchTime() >= seconds;
    }
}
