package com._604robotics.robotnik.action;

import com._604robotics.robotnik.action.field.FieldMap;
import com._604robotics.robotnik.module.ModuleReference;

// TODO: Auto-generated Javadoc
/**
 * The Class Action.
 */
public class Action {
    
    /** The field map. */
    private final FieldMap fieldMap;
    
    /**
     * Instantiates a new action.
     */
    public Action () {
        this.fieldMap = new FieldMap();
    }
    
    /**
     * Instantiates a new action.
     *
     * @param fieldMap the field map
     */
    public Action (FieldMap fieldMap) {
        this.fieldMap = fieldMap;
    }
    
    /**
     * Begin.
     *
     * @param data the data
     */
    public void begin (ActionData data) {}
    
    /**
     * Run.
     *
     * @param data the data
     */
    public void run (ActionData data) {}
    
    /**
     * End.
     *
     * @param data the data
     */
    public void end (ActionData data) {}
    
    /**
     * Gets the field map.
     *
     * @return the field map
     */
    protected FieldMap getFieldMap () {
        return this.fieldMap;
    }
}