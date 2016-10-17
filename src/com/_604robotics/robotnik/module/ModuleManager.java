package com._604robotics.robotnik.module;

import java.util.HashMap;
import java.util.Map;

import com._604robotics.robotnik.Safety;
import com._604robotics.robotnik.logging.Logger;
import com._604robotics.robotnik.memory.IndexedTable;

/**
 * Manages modules.
 */
public class ModuleManager {
    private final Map<String, ModuleReference> moduleTable;

    /**
     * Creates a module manager.
     * @param moduleMap Map of modules to manage.
     * @param table Table to store module data in.
     */
    public ModuleManager (ModuleMap moduleMap, final IndexedTable table) {
        this.moduleTable = new HashMap<String, ModuleReference>();
        for (Map.Entry<String, Module> entry : moduleMap) {
            this.moduleTable.put(entry.getKey(), new ModuleReference(entry.getKey(), entry.getValue(), table.getSubTable(entry.getKey())));
        }
    }

    /**
     * Gets a reference to a module.
     * @param name Name of the module.
     * @return The retrieved module reference.
     */
    public ModuleReference getModule (String name) {
        ModuleReference ref = this.moduleTable.get(name);
        if (ref == null) Logger.missing("ModuleReference", name);
        return ref;
    }

    /**
     * Starts all modules.
     * @param safety Safety mode to operate under.
     */
    public void start (Safety safety) {
        for (ModuleReference ref : this.moduleTable.values()) {
            ref.start(safety);
        }
    }

    /**
     * Updates all modules.
     * @param safety Safety mode to operate under.
     */
    public void update (Safety safety) {
        for (ModuleReference ref : this.moduleTable.values()) {
            ref.update(safety);
        }
    }

    /**
     * Executes all modules.
     * @param safety Safety mode to operate under.
     */
    public void execute (Safety safety) {
        for (ModuleReference ref : this.moduleTable.values()) {
            ref.execute(safety);
        }
    }

    /**
     * Stops all modules.
     * @param safety Safety mode to operate under.
     */
    public void stop (Safety safety) {
        for (ModuleReference ref : this.moduleTable.values()) {
            ref.stop(safety);
        }
    }
}