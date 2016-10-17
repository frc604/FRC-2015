package com._604robotics.robotnik.action;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Contains a set of actions, controlling which to run at a given time.
 */
public abstract class ActionController implements Iterable<Map.Entry<String, Action>> {
    private final Map<String, Action> actionTable = new HashMap<String, Action>();
    private String defaultAction = "";

    /**
     * Picks an action to run.
     * @param lastAction The name of the last action that ran.
     * @param triggeredAction The name of the current triggered action.
     * @return The name of the action to run.
     */
    protected abstract String pickAction (String lastAction, String triggeredAction);

    /**
     * Adds an action.
     * @param name Name of the action.
     * @param action Action to add.
     */
    public void add (String name, Action action) {
        this.actionTable.put(name, action);
    }

    /**
     * Adds an empty action.
     * @param name Name of the action.
     */
    public void add (String name) {
        this.add(name, new Action());
    }

    /**
     * Adds an action, setting it as the default.
     * @param name Name of the action.
     * @param action Action to add.
     */
    public void addDefault (String name, Action action) {
        this.add(name, action);
        this.defaultAction = name;
    }

    /**
     * Adds an empty action, setting it as the default.
     * @param name Name of the action.
     */
    public void addDefault (String name) {
        this.addDefault(name, new Action());
    }

    /**
     * Gets the name of the default action.
     * @return The name of the default action.
     */
    protected String getDefaultAction () {
        return this.defaultAction;
    }

    /**
     * Gets an action by its name.
     * @param name Name of the action.
     * @return The action with the given name.
     */
    protected Action getAction (String name) {
        return this.actionTable.get(name);
    }

    @Override
    public Iterator<Map.Entry<String, Action>> iterator () {
        return this.actionTable.entrySet().iterator();
    }
}