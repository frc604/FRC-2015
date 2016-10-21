package com._604robotics.robotnik.data.sources;

import com._604robotics.robotnik.data.Data;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * A choice of data from the smart dashboard.
 */
public class DashboardDataChoice implements Data {
    private final SendableChooser chooser = new SendableChooser();
    
    /**
     * Creates a dashboard data choice.
     * @param key Key of the data in smart dashboard.
     * @param defaultName Name of the data choice.
     * @param defaultValue Default value of the data.
     */
    public DashboardDataChoice (String key, String defaultName, double defaultValue) {
        this.chooser.addDefault(defaultName, Double.valueOf(defaultValue));
        SmartDashboard.putData(key, this.chooser);
    }
    
    /**
     * Adds a choice to the data chooser.
     * @param name Name of the choise.
     * @param defaultValue Default value of the choice.
     */
    public void add (String name, double defaultValue) {
        this.chooser.addObject(name, Double.valueOf(defaultValue));
    }

    @Override
    public double run () {
        return ((Double) this.chooser.getSelected()).doubleValue();
    }
}