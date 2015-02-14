package com._604robotics.robotnik.trigger.sources;

import com._604robotics.robotnik.trigger.Trigger;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// TODO: Auto-generated Javadoc
/**
 * The Class DashboardTriggerChoice.
 */
public class DashboardTriggerChoice {
    
    /** The chooser. */
    private final SendableChooser chooser = new SendableChooser();
    
    /**
     * The Class DashboardTriggerOption.
     */
    private class DashboardTriggerOption extends Trigger {
        
        /* (non-Javadoc)
         * @see com._604robotics.robotnik.trigger.Trigger#run()
         */
        public boolean run () {
            return chooser.getSelected() == this;
        }
    }
    
    /**
     * Instantiates a new dashboard trigger choice.
     *
     * @param key the key
     */
    public DashboardTriggerChoice (String key) {
        SmartDashboard.putData(key, this.chooser);
    }
    
    /**
     * Adds the default.
     *
     * @param name the name
     * @return the trigger
     */
    public Trigger addDefault (String name) {
        final DashboardTriggerOption option = new DashboardTriggerOption();
        this.chooser.addDefault(name, option);
        return option;
    }
    
    /**
     * Adds the.
     *
     * @param name the name
     * @return the trigger
     */
    public Trigger add (String name) {
        final DashboardTriggerOption option = new DashboardTriggerOption();
        this.chooser.addObject(name, option);
        return option;
    }
}