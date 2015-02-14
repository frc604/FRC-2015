package com._604robotics.robotnik.module;

import com._604robotics.robotnik.action.ActionController;
import com._604robotics.robotnik.action.controllers.DummyController;
import com._604robotics.robotnik.data.DataMap;
import com._604robotics.robotnik.trigger.TriggerMap;

// TODO: Auto-generated Javadoc
/**
 * The Class Module.
 */
public abstract class Module {
    
    /** The data map. */
    private DataMap dataMap = new DataMap();
    
    /** The trigger map. */
    private TriggerMap triggerMap = new TriggerMap();
    
    /** The action controller. */
    private ActionController actionController = new DummyController();
    
    /**
     * Start.
     */
    protected void start () {}
    
    /**
     * End.
     */
    protected void end () {}
    
    /**
     * Sets the.
     *
     * @param dataMap the data map
     */
    protected void set (DataMap dataMap) {
        this.dataMap = dataMap;
    }
    
    /**
     * Sets the.
     *
     * @param triggerMap the trigger map
     */
    protected void set (TriggerMap triggerMap) {
        this.triggerMap = triggerMap;
    }
    
    /**
     * Sets the.
     *
     * @param actionController the action controller
     */
    protected void set (ActionController actionController) {
        this.actionController = actionController;
    }
    
    /**
     * Gets the data map.
     *
     * @return the data map
     */
    protected DataMap getDataMap () {
        return this.dataMap;
    }
    
    /**
     * Gets the trigger map.
     *
     * @return the trigger map
     */
    protected TriggerMap getTriggerMap () {
        return this.triggerMap;
    }
    
    /**
     * Gets the action controller.
     *
     * @return the action controller
     */
    protected ActionController getActionController () {
        return this.actionController;
    }
}
