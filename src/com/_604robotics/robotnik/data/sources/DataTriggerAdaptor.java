package com._604robotics.robotnik.data.sources;

import com._604robotics.robotnik.data.DataAccess;
import com._604robotics.robotnik.trigger.TriggerAccess;

/**
 * Data supplied by a trigger.
 */
public class DataTriggerAdaptor implements DataAccess {
    private final TriggerAccess trigger;
    
    /**
     * Creates a data trigger adaptor.
     * @param trigger Trigger to supply data with.
     */
    public DataTriggerAdaptor (TriggerAccess trigger) {
        this.trigger = trigger;
    }
    
    @Override
    public double get () {
        return this.trigger.get() ? 1D : 0D;
    }
}
