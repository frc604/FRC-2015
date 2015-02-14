package com._604robotics.robotnik.prefabs.measure;

import com._604robotics.robotnik.procedure.Measure;
import edu.wpi.first.wpilibj.Timer;

// TODO: Auto-generated Javadoc
/**
 * The Class TimeMeasure.
 */
public class TimeMeasure extends Measure {
    
    /** The timer. */
    private final Timer timer = new Timer();
    
    /** The seconds. */
    private final double seconds;

    /**
     * Instantiates a new time measure.
     *
     * @param seconds the seconds
     */
    public TimeMeasure (double seconds) {
        this.seconds = seconds;
    }

    /* (non-Javadoc)
     * @see com._604robotics.robotnik.procedure.Measure#initialize()
     */
    public void initialize() {
        timer.reset();
        timer.start();
    }

    /* (non-Javadoc)
     * @see com._604robotics.robotnik.procedure.Measure#complete()
     */
    public boolean complete () {
        final boolean complete = timer.get() > seconds;
        if (complete)
            timer.stop();
        return complete;
    }
}
