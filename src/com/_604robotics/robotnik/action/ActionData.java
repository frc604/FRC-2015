package com._604robotics.robotnik.action;

import com._604robotics.robotnik.action.field.Field;
import com._604robotics.robotnik.action.field.FieldMap;
import com._604robotics.robotnik.data.DataReference;
import com._604robotics.robotnik.logging.Logger;
import com._604robotics.robotnik.memory.IndexedTable;
import com._604robotics.robotnik.module.ModuleReference;
import com._604robotics.robotnik.trigger.TriggerReference;

/**
 * Provides data for an action to access during its operation.
 */
public class ActionData {
    private final FieldMap map;
    private final IndexedTable table;
    private final ModuleReference module;

    /**
     * Creates action data.
     * @param map Map of the data fields to provide.
     * @param table The table to retrieve data from.
     * @param module Reference to the module this action data belongs to.
     */
    public ActionData (FieldMap map, IndexedTable table, ModuleReference module) {
        this.map = map;
        this.table = table;
        this.module = module;
    }

    /**
     * Gets the value of a data field.
     * @param name Name of the field.
     * @return The field's value.
     */
    public double get (String name) {
        return this.lookup(name);
    }

    /**
     * Gets whether a data field's value is non-zero.
     * @param name Name of the field.
     * @return Whether the field's value is non-zero.
     */
    public boolean is (String name) {
        return this.lookup(name) > 0;
    }

    /**
     * Gets a trigger from the module this action data belongs to.
     * @param name Name of the trigger.
     * @return The retrieved trigger.
     */
    public boolean trigger (String name) {
        final TriggerReference trigger = module.getTrigger(name);
        if (trigger == null) {
            Logger.missing("TriggerReference", name);
            return false;
        } else {
            return trigger.get();
        }
    }

    /**
     * Gets data from the module this action data belongs to.
     * @param name Name of the data.
     * @return The retrieved data.
     */
    public double data (String name) {
        final DataReference data = module.getData(name);
        if (data == null) {
            Logger.missing("DataReference", name);
            return 0D;
        } else {
            return data.get();
        }
    }

    /**
     * Resets the values of the action data.
     */
    protected void reset () {
        for (Field field : this.map) {
            this.table.putNumber(field.getName(), field.getDefaultValue());
        }
    }

    private double lookup (String name) {
        if (!this.table.knowsAbout(name)) Logger.missing("Field", name);
        return this.table.getNumber(name, 0D);
    }
}
