package com._604robotics.robotnik.action;

import com._604robotics.robotnik.Safety;
import com._604robotics.robotnik.data.DataRecipient;
import com._604robotics.robotnik.memory.IndexedTable;
import com._604robotics.robotnik.memory.IndexedTable.Slice;
import com._604robotics.robotnik.module.ModuleReference;
import com._604robotics.robotnik.prefabs.trigger.TriggerManual;
import com._604robotics.robotnik.trigger.TriggerAccess;
import com._604robotics.robotnik.trigger.TriggerRecipient;

/**
 * A reference to an action.
 */
public class ActionReference implements DataRecipient, TriggerRecipient {
    private final Action action;
    private final Slice trigger;
    private final IndexedTable dataTable;
    private final ActionData actionData;
    private final TriggerManual activeTrigger = new TriggerManual(false);

    /**
     * Creates an action reference.
     * @param module Reference to the module this reference belongs to.
     * @param action Action this reference refers to.
     * @param triggered The data slice to contain whether this action has been triggered.
     * @param dataTable Data table to retrieve action data from.
     */
    public ActionReference (ModuleReference module, Action action, Slice triggered, IndexedTable dataTable) {
        this.action = action;
        
        this.trigger = triggered;
        this.dataTable = dataTable;        
        this.actionData = new ActionData(this.action.getFieldMap(), this.dataTable, module);
    }

    /**
     * Resets the action reference.
     */
    public void reset () {
        this.trigger.putNumber(0D);
        this.actionData.reset();
    }
    
    @Override
    public void sendTrigger (double precedence) {
        final double current = this.trigger.getNumber(0D);
        
        if (precedence > current) {
            this.trigger.putNumber(precedence);
        }
    }
    
    @Override
    public void sendData (String fieldName, double dataValue) {
        this.dataTable.putNumber(fieldName, dataValue);
    }

    /**
     * Begins the action.
     * @param safety Safety mode to operate with.
     */
    public void begin (Safety safety) {
        safety.wrap("action begin phase", () -> action.begin(actionData));
        this.activeTrigger.set(true);
    }

    /**
     * Runs the action.
     * @param safety Safety mode to operate with.
     */
    public void run (Safety safety) {
        safety.wrap("action run phase", () -> action.run(actionData));
    }

    /**
     * Ends the action.
     * @param safety Safety mode to operate with.
     */
    public void end (Safety safety) {
        safety.wrap("action end phase", () -> action.end(actionData));
        this.activeTrigger.set(false);
    }

    /**
     * Gets a trigger fired when the reference's action is active.
     * @return The action's trigger.
     */
    public TriggerAccess active () {
        return (TriggerAccess) this.activeTrigger;
    }
}