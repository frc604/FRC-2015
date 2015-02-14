package com._604robotics.robotnik.action;

import com._604robotics.robotnik.meta.Iterator;
import java.util.Hashtable;

// TODO: Auto-generated Javadoc
/**
 * The Class ActionController.
 */
public abstract class ActionController {
    
    /** The action table. */
    private final Hashtable actionTable = new Hashtable();
    
    /** The default action. */
    private String defaultAction = "";
    
    /**
     * Pick action.
     *
     * @param lastAction the last action
     * @param triggeredAction the triggered action
     * @return the string
     */
    protected abstract String pickAction (String lastAction, String triggeredAction);
    
    /**
     * Adds the.
     *
     * @param name the name
     * @param action the action
     */
    public void add (String name, Action action) {
        this.actionTable.put(name, action);
    }
    
    /**
     * Adds the.
     *
     * @param name the name
     */
    public void add (String name) {
        this.add(name, new Action());
    }
    
    /**
     * Adds the default.
     *
     * @param name the name
     * @param action the action
     */
    public void addDefault (String name, Action action) {
        this.add(name, action);
        this.defaultAction = name;
    }
    
    /**
     * Adds the default.
     *
     * @param name the name
     */
    public void addDefault (String name) {
        this.addDefault(name, new Action());
    }
    
    /**
     * Gets the default action.
     *
     * @return the default action
     */
    protected String getDefaultAction () {
        return this.defaultAction;
    }
    
    /**
     * Gets the action.
     *
     * @param name the name
     * @return the action
     */
    protected Action getAction (String name) {
        return (Action) this.actionTable.get(name);
    }
    
    /**
     * Iterate.
     *
     * @return the iterator
     */
    protected Iterator iterate () {
        return new Iterator(this.actionTable);
    }
}