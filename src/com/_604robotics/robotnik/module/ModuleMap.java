package com._604robotics.robotnik.module;

import com._604robotics.robotnik.meta.Iterator;
import java.util.Hashtable;

// TODO: Auto-generated Javadoc
/**
 * The Class ModuleMap.
 */
public class ModuleMap {
    
    /** The module table. */
    private final Hashtable moduleTable = new Hashtable();
    
    /**
     * Adds the.
     *
     * @param name the name
     * @param module the module
     */
    protected void add (String name, Module module) {
        this.moduleTable.put(name, module);
    }
    
    /**
     * Gets the module.
     *
     * @param name the name
     * @return the module
     */
    protected Module getModule (String name) {
        return (Module) this.moduleTable.get(name);
    }
    
    /**
     * Iterate.
     *
     * @return the iterator
     */
    protected Iterator iterate () {
        return new Iterator(this.moduleTable);
    }
}
