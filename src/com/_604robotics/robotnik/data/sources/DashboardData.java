package com._604robotics.robotnik.data.sources;

import com._604robotics.robotnik.data.Data;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Data from the smart dashboard.
 */
public class DashboardData implements Data {
    private final String key;
    private final double defaultValue;

    /**
     * Creates dashboard data.
     * @param key Key of the data in smart dashboard.
     * @param defaultValue Default value of the data.
     */
    public DashboardData (String key, double defaultValue) {
        this.key = key;
        this.defaultValue = defaultValue;
        
        SmartDashboard.putNumber(key, defaultValue);
    }

    @Override
    public double run () {
        return SmartDashboard.getNumber(this.key, this.defaultValue);
    }
}