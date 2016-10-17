package com._604robotics.robotnik.trigger.sources;

import com._604robotics.robotnik.trigger.Trigger;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * A trigger from the smart dashboard.
 */
public class DashboardTrigger implements Trigger {
    private final String key;
    private final boolean defaultValue;

    /**
     * Creates a dashboard trigger.
     * @param key Key of the trigger.
     * @param defaultValue Default value of the trigger.
     */
    public DashboardTrigger (String key, boolean defaultValue) {
        this.key = key;
        this.defaultValue = defaultValue;
        
        SmartDashboard.putBoolean(key, defaultValue);
    }

    @Override
    public boolean run () {
        return SmartDashboard.getBoolean(this.key, this.defaultValue);
    }
}