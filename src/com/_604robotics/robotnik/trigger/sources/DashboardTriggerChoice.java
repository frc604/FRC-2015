package com._604robotics.robotnik.trigger.sources;

import com._604robotics.robotnik.trigger.Trigger;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * A choice of triggers from the smart dashboard.
 */
public class DashboardTriggerChoice {
    private final SendableChooser chooser = new SendableChooser();
    private class DashboardTriggerOption implements Trigger {
        @Override
        public boolean run () {
            return chooser.getSelected() == this;
        }
    }

    /**
     * Creates a dashboard trigger choice.
     * @param key Key of the trigger.
     */
    public DashboardTriggerChoice (String key) {
        SmartDashboard.putData(key, this.chooser);
    }

    /**
     * Adds the default choice.
     * @param name Name of the choice.
     * @return The trigger representing the choice.
     */
    public Trigger addDefault (String name) {
        final DashboardTriggerOption option = new DashboardTriggerOption();
        this.chooser.addDefault(name, option);
        return option;
    }

    /**
     * Adds a choice.
     * @param name Name of the choice.
     * @return The trigger representing the choice.
     */
    public Trigger add (String name) {
        final DashboardTriggerOption option = new DashboardTriggerOption();
        this.chooser.addObject(name, option);
        return option;
    }
}