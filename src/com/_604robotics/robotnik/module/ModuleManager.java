package com._604robotics.robotnik.module;

import com._604robotics.robotnik.meta.Iterator;
import com._604robotics.robotnik.meta.Repackager;
import com._604robotics.robotnik.memory.IndexedTable;
import com._604robotics.robotnik.logging.InternalLogger;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.util.Hashtable;

// TODO: Auto-generated Javadoc
/**
 * The Class ModuleManager.
 */
public class ModuleManager {
    
    /** The module table. */
    private final Hashtable moduleTable;
    
    /**
     * Instantiates a new module manager.
     *
     * @param moduleMap the module map
     * @param table the table
     */
    public ModuleManager (ModuleMap moduleMap, final IndexedTable table) {
        this.moduleTable = Repackager.repackage(moduleMap.iterate(), new Repackager() {
            public Object wrap (Object key, Object value) {
                return new ModuleReference((String) key, (Module) value, table.getSubTable((String) key));
            }
        });
    }
    
    /**
     * Gets the module.
     *
     * @param name the name
     * @return the module
     */
    public ModuleReference getModule (String name) {
        ModuleReference ref = (ModuleReference) this.moduleTable.get(name);
        if (ref == null) InternalLogger.missing("ModuleReference", name);
        return ref;
    }
    
    /**
     * Start.
     */
    public void start () {
        final Iterator i = new Iterator(this.moduleTable);
        while (i.next()) ((ModuleReference) i.value).start();
    }
    
    /**
     * Update.
     */
    public void update () {
        final Iterator i = new Iterator(this.moduleTable);
        while (i.next()) ((ModuleReference) i.value).update();
    }
    
    /**
     * Execute.
     */
    public void execute () {
        final Iterator i = new Iterator(this.moduleTable);
        while (i.next()) ((ModuleReference) i.value).execute();
    }
    
    /**
     * End.
     */
    public void end () {
        final Iterator i = new Iterator(this.moduleTable);
        while (i.next()) ((ModuleReference) i.value).end();
    }
}