package com._604robotics.robotnik.trigger.sources;

import com._604robotics.robotnik.trigger.Trigger;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// TODO: Auto-generated Javadoc
/**
 * The Class DashboardTrigger.
 */
public class DashboardTrigger extends Trigger {
    
    /** The key. */
    private final String key;
    
    /** The default value. */
    private final boolean defaultValue;
    
    /**
     * Instantiates a new dashboard trigger.
     *
     * @param key the key
     * @param defaultValue the default value
     */
    public DashboardTrigger (String key, boolean defaultValue) {
        this.key = key;
        this.defaultValue = defaultValue;
        
        SmartDashboard.putBoolean(key, defaultValue);
    }

    /* (non-Javadoc)
     * @see com._604robotics.robotnik.trigger.Trigger#run()
     */
    public boolean run () {
        return SmartDashboard.getBoolean(this.key, this.defaultValue);
    }
}