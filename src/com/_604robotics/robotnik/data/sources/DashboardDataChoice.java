package com._604robotics.robotnik.data.sources;

import com._604robotics.robotnik.data.Data;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// TODO: Auto-generated Javadoc
/**
 * The Class DashboardDataChoice.
 */
public class DashboardDataChoice extends Data {
    
    /** The chooser. */
    private final SendableChooser chooser = new SendableChooser();
    
    /**
     * Instantiates a new dashboard data choice.
     *
     * @param key the key
     * @param defaultName the default name
     * @param defaultValue the default value
     */
    public DashboardDataChoice (String key, String defaultName, double defaultValue) {
        this.chooser.addDefault(defaultName, Double.valueOf(defaultValue));
        SmartDashboard.putData(key, this.chooser);
    }
    
    /**
     * Adds the.
     *
     * @param name the name
     * @param value the value
     */
    public void add (String name, double value) {
        this.chooser.addObject(name, Double.valueOf(value));
    }

    /* (non-Javadoc)
     * @see com._604robotics.robotnik.data.Data#run()
     */
    public double run () {
        return ((Double) this.chooser.getSelected()).doubleValue();
    }
}