package com._604robotics.robotnik.data.sources;

import com._604robotics.robotnik.data.Data;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// TODO: Auto-generated Javadoc
/**
 * The Class DashboardData.
 */
public class DashboardData extends Data {
    
    /** The key. */
    private final String key;
    
    /** The default value. */
    private final double defaultValue;
    
    /**
     * Instantiates a new dashboard data.
     *
     * @param key the key
     * @param defaultValue the default value
     */
    public DashboardData (String key, double defaultValue) {
        this.key = key;
        this.defaultValue = defaultValue;
        
        SmartDashboard.putNumber(key, defaultValue);
    }

    /* (non-Javadoc)
     * @see com._604robotics.robotnik.data.Data#run()
     */
    public double run () {
        return SmartDashboard.getNumber(this.key, this.defaultValue);
    }
}