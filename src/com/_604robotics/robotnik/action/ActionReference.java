package com._604robotics.robotnik.action;

import com._604robotics.robotnik.data.DataRecipient;
import com._604robotics.robotnik.memory.IndexedTable;
import com._604robotics.robotnik.memory.IndexedTable.Slice;
import com._604robotics.robotnik.module.ModuleReference;
import com._604robotics.robotnik.prefabs.trigger.TriggerManual;
import com._604robotics.robotnik.trigger.TriggerAccess;
import com._604robotics.robotnik.trigger.TriggerRecipient;

// TODO: Auto-generated Javadoc
/**
 * The Class ActionReference.
 */
public class ActionReference implements DataRecipient, TriggerRecipient {
    
    /** The action. */
    private final Action action;
    
    /** The trigger. */
    private final Slice trigger;
    
    /** The data table. */
    private final IndexedTable dataTable;
    
    /** The action data. */
    private final ActionData actionData;
    
    /** The active trigger. */
    private final TriggerManual activeTrigger = new TriggerManual(false);
    
    /**
     * Instantiates a new action reference.
     *
     * @param module the module
     * @param action the action
     * @param triggered the triggered
     * @param dataTable the data table
     */
    public ActionReference (ModuleReference module, Action action, Slice triggered, IndexedTable dataTable) {
        this.action = action;
        
        this.trigger = triggered;
        this.dataTable = dataTable;        
        this.actionData = new ActionData(this.action.getFieldMap(), this.dataTable, module);
    }
    
    /**
     * Reset.
     */
    public void reset () {
        this.trigger.putNumber(0D);
        this.actionData.reset();
    }
    
    /* (non-Javadoc)
     * @see com._604robotics.robotnik.trigger.TriggerRecipient#sendTrigger(double)
     */
    public void sendTrigger (double precedence) {
        final double current = this.trigger.getNumber(0D);
        
        if (precedence > current) {
            this.trigger.putNumber(precedence);
        }
    }
    
    /* (non-Javadoc)
     * @see com._604robotics.robotnik.data.DataRecipient#sendData(java.lang.String, double)
     */
    public void sendData (String fieldName, double dataValue) {
        this.dataTable.putNumber(fieldName, dataValue);
    }
    
    /**
     * Begin.
     */
    public void begin () {
        this.action.begin(this.actionData);
        this.activeTrigger.set(true);
    }
    
    /**
     * Run.
     */
    public void run () {
        this.action.run(this.actionData);
    }
    
    /**
     * End.
     */
    public void end () {
        this.action.end(this.actionData);
        this.activeTrigger.set(false);
    }
    
    /**
     * Active.
     *
     * @return the trigger access
     */
    public TriggerAccess active () {
        return (TriggerAccess) this.activeTrigger;
    }
}