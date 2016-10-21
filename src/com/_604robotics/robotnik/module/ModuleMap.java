package com._604robotics.robotnik.module;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * A map containing modules.
 */
public class ModuleMap implements Iterable<Map.Entry<String, Module>> {
    private final Map<String, Module> moduleTable = new HashMap<String, Module>();

    /**
     * Adds a module.
     * @param name Name of the module.
     * @param module Module to add.
     */
    protected void add (String name, Module module) {
        this.moduleTable.put(name, module);
    }

    /**
     * Gets a module.
     * @param name Name of the module.
     * @return The retrieved module.
     */
    protected Module getModule (String name) {
        return this.moduleTable.get(name);
    }

    @Override
    public Iterator<Map.Entry<String, Module>> iterator () {
        return this.moduleTable.entrySet().iterator();
    }
}
