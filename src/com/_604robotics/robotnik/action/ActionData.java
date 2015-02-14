package com._604robotics.robotnik.action;

import com._604robotics.robotnik.action.field.Field;
import com._604robotics.robotnik.action.field.FieldMap;
import com._604robotics.robotnik.data.DataReference;
import com._604robotics.robotnik.memory.IndexedTable;
import com._604robotics.robotnik.logging.InternalLogger;
import com._604robotics.robotnik.module.ModuleReference;
import com._604robotics.robotnik.trigger.TriggerReference;
import java.util.Enumeration;

// TODO: Auto-generated Javadoc
/**
 * The Class ActionData.
 */
public class ActionData {
    
    /** The map. */
    private final FieldMap map;
    
    /** The table. */
    private final IndexedTable table;
    
    /** The module. */
    private final ModuleReference module;
    
    /**
     * Instantiates a new action data.
     *
     * @param map the map
     * @param table the table
     * @param module the module
     */
    public ActionData (FieldMap map, IndexedTable table, ModuleReference module) {
        this.map = map;
        this.table = table;
        this.module = module;
    }
    
    /**
     * Gets the.
     *
     * @param name the name
     * @return the double
     */
    public double get (String name) {
        return this.lookup(name);
    }
    
    /**
     * Checks if is.
     *
     * @param name the name
     * @return true, if successful
     */
    public boolean is (String name) {
        return this.lookup(name) > 0;
    }
    
    /**
     * Trigger.
     *
     * @param name the name
     * @return true, if successful
     */
    public boolean trigger (String name) {
        final TriggerReference trigger = module.getTrigger(name);
        if (trigger == null) {
            InternalLogger.missing("TriggerReference", name);
            return false;
        } else {
            return trigger.get();
        }
    }
    
    /**
     * Data.
     *
     * @param name the name
     * @return the double
     */
    public double data (String name) {
        final DataReference data = module.getData(name);
        if (data == null) {
            InternalLogger.missing("DataReference", name);
            return 0D;
        } else {
            return data.get();
        }
    }
    
    /**
     * Reset.
     */
    protected void reset () {
        final Enumeration fields = map.enumerate();
        Field field;
        
        while (fields.hasMoreElements()) {
            field = (Field) fields.nextElement();
            this.table.putNumber(field.getName(), field.getDefaultValue());
        }
    }
    
    /**
     * Lookup.
     *
     * @param name the name
     * @return the double
     */
    private double lookup (String name) {
        if (!this.table.knowsAbout(name)) InternalLogger.missing("Field", name);
        return this.table.getNumber(name, 0D);
    }
}
