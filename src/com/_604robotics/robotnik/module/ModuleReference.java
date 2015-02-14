package com._604robotics.robotnik.module;

import com._604robotics.robotnik.action.ActionManager;
import com._604robotics.robotnik.action.ActionReference;
import com._604robotics.robotnik.data.DataManager;
import com._604robotics.robotnik.data.DataReference;
import com._604robotics.robotnik.memory.IndexedTable;
import com._604robotics.robotnik.trigger.TriggerManager;
import com._604robotics.robotnik.trigger.TriggerReference;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// TODO: Auto-generated Javadoc
/**
 * The Class ModuleReference.
 */
public class ModuleReference {
    
    /** The module. */
    private final Module module;
    
    /** The data manager. */
    private final DataManager dataManager;
    
    /** The trigger manager. */
    private final TriggerManager triggerManager;
    
    /** The action manager. */
    private final ActionManager actionManager;
    
    /**
     * Instantiates a new module reference.
     *
     * @param name the name
     * @param module the module
     * @param table the table
     */
    public ModuleReference (String name, Module module, IndexedTable table) {
        this.dataManager = new DataManager(name, module.getDataMap(), table.getSubTable("data"));
        this.triggerManager = new TriggerManager(name, module.getTriggerMap(), table.getSubTable("triggers"));
        
        this.actionManager = new ActionManager(this, name, module.getActionController(), table.getSubTable("actions"));
        
        this.module = module;
    }
    
    /**
     * Gets the data.
     *
     * @param name the name
     * @return the data
     */
    public DataReference getData (String name) {
        return this.dataManager.getData(name);
    }
    
    /**
     * Gets the trigger.
     *
     * @param name the name
     * @return the trigger
     */
    public TriggerReference getTrigger (String name) {
        return this.triggerManager.getTrigger(name);
    }
    
    /**
     * Gets the action.
     *
     * @param name the name
     * @return the action
     */
    public ActionReference getAction (String name) {
        return this.actionManager.getAction(name);
    }
    
    /**
     * Start.
     */
    public void start () {
        this.module.start();
    }
    
    /**
     * Update.
     */
    public void update () {
        this.dataManager.update();
        this.triggerManager.update();
        
        this.actionManager.reset();
    }
    
    /**
     * Execute.
     */
    public void execute () {
        this.actionManager.update();
        this.actionManager.execute();
    }
    
    /**
     * End.
     */
    public void end () {
        this.actionManager.end();
        this.module.end();
    }
}