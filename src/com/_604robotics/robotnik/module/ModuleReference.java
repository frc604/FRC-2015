package com._604robotics.robotnik.module;

import com._604robotics.robotnik.Safety;
import com._604robotics.robotnik.action.ActionManager;
import com._604robotics.robotnik.action.ActionReference;
import com._604robotics.robotnik.data.DataManager;
import com._604robotics.robotnik.data.DataReference;
import com._604robotics.robotnik.memory.IndexedTable;
import com._604robotics.robotnik.trigger.TriggerManager;
import com._604robotics.robotnik.trigger.TriggerReference;

/**
 * A reference to a module.
 */
public class ModuleReference {
    private final Module module;

    private final DataManager dataManager;
    private final TriggerManager triggerManager;
    private final ActionManager actionManager;
    
    /**
     * Creates a module reference.
     * @param name Name of the module.
     * @param module Module to refer to.
     * @param table Table to store module data in.
     */
    public ModuleReference (String name, Module module, IndexedTable table) {
        this.dataManager = new DataManager(module.getDataMap(), table.getSubTable("data"));
        this.triggerManager = new TriggerManager(module.getTriggerMap(), table.getSubTable("triggers"));
        
        this.actionManager = new ActionManager(this, module.getActionController(), table.getSubTable("actions"));
        
        this.module = module;
    }
    
    /**
     * Gets data belonging to the module.
     * @param name Name of the data.
     * @return The retrieved data.
     */
    public DataReference getData (String name) {
        return this.dataManager.getData(name);
    }
    
    /**
     * Gets a trigger belonging to the module.
     * @param name Name of the trigger.
     * @return The retrieved trigger.
     */
    public TriggerReference getTrigger (String name) {
        return this.triggerManager.getTrigger(name);
    }
    
    /**
     * Gets an action belonging to the module.
     * @param name Name of the action.
     * @return The retrieved action.
     */
    public ActionReference getAction (String name) {
        return this.actionManager.getAction(name);
    }
    
    /**
     * Starts the module.
     * @param safety Safety mode to operate with.
     */
    public void start (Safety safety) {
        safety.wrap("module begin phase", module::begin);
    }
    
    /**
     * Updates the module.
     * @param safety Safety mode to operate with.
     */
    public void update (Safety safety) {
        this.dataManager.update(safety);
        this.triggerManager.update(safety);
        
        this.actionManager.reset();
    }

    /**
     * Executes the module.
     * @param safety Safety mode to operate with.
     */
    public void execute (Safety safety) {
        this.actionManager.update();
        this.actionManager.execute(safety);
    }
    
    /**
     * Stops the module.
     * @param safety Safety mode to operate with.
     */
    public void stop (Safety safety) {
        this.actionManager.stop(safety);
        safety.wrap("module end phase", module::end);
    }
}