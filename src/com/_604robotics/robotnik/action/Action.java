package com._604robotics.robotnik.action;

import com._604robotics.robotnik.action.field.FieldMap;

/**
 * An action that a robot can perform.
 */
public class Action {
    private final FieldMap fieldMap;

    /**
     * Creates an action.
     */
    public Action () {
        this.fieldMap = new FieldMap();
    }

    /**
     * Creates an action.
     * @param fieldMap Data fields to provide to the action.
     */
    public Action (FieldMap fieldMap) {
        this.fieldMap = fieldMap;
    }

    /**
     * Called when the action has begun.
     * @param data Data provided to the action.
     */
    public void begin (ActionData data) {}

    /**
     * Called when the action is running.
     * @param data Data provided to the action.
     */
    public void run (ActionData data) {}

    /**
     * Called when the action has ended.
     * @param data Data provided to the action.
     */
    public void end (ActionData data) {}

    /**
     * Gets a map of action data fields.
     * @return A map of action data fields.
     */
    protected FieldMap getFieldMap () {
        return this.fieldMap;
    }
}