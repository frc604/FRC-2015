package com._604robotics.robotnik.module;

import com._604robotics.robotnik.action.ActionController;
import com._604robotics.robotnik.action.controllers.DummyController;
import com._604robotics.robotnik.data.DataMap;
import com._604robotics.robotnik.trigger.TriggerMap;

/**
 * A module of a robot.
 */
public abstract class Module {
    private DataMap dataMap = new DataMap();
    private TriggerMap triggerMap = new TriggerMap();
    private ActionController actionController = new DummyController();

    /**
     * Called when the module's life cycle begins.
     */
    protected void begin () {}

    /**
     * Called when the module's life cycle ends.
     */
    protected void end () {}

    /**
     * Sets the data map of the module.
     * @param dataMap The module's data map.
     */
    protected void set (DataMap dataMap) {
        this.dataMap = dataMap;
    }

    /**
     * Sets the trigger map of the module.
     * @param triggerMap The module's trigger map.
     */
    protected void set (TriggerMap triggerMap) {
        this.triggerMap = triggerMap;
    }

    /**
     * Sets the action controller of the module.
     * @param actionController The module's action controller.
     */
    protected void set (ActionController actionController) {
        this.actionController = actionController;
    }

    /**
     * Gets the module's data map.
     * @return The module's data map.
     */
    protected DataMap getDataMap () {
        return this.dataMap;
    }

    /**
     * Gets the module's trigger map.
     * @return The module's trigger map.
     */
    protected TriggerMap getTriggerMap () {
        return this.triggerMap;
    }

    /**
     * Gets the module's action controller.
     * @return The module's action controller.
     */
    protected ActionController getActionController () {
        return this.actionController;
    }
}
