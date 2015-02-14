package com._604robotics.robotnik.prefabs.measure;

import com._604robotics.robotnik.procedure.Measure;
import com._604robotics.robotnik.trigger.TriggerAccess;

// TODO: Auto-generated Javadoc
/**
 * The Class TriggerMeasure.
 */
public class TriggerMeasure extends Measure {
    
    /** The trigger. */
    private final TriggerAccess trigger;

    /**
     * Instantiates a new trigger measure.
     *
     * @param trigger the trigger
     */
    public TriggerMeasure(TriggerAccess trigger) {
        this.trigger = trigger;
    }

    /* (non-Javadoc)
     * @see com._604robotics.robotnik.procedure.Measure#complete()
     */
    public boolean complete () {
        return trigger.get();
    }
}
