package com._604robotics.robotnik.procedure;

import com._604robotics.robotnik.coordinator.Coordinator;
import com._604robotics.robotnik.logging.Logger;
import com._604robotics.robotnik.module.ModuleManager;
import java.util.Enumeration;
import java.util.Vector;

// TODO: Auto-generated Javadoc
/**
 * The Class Procedure.
 */
public class Procedure {
    
    /** The global. */
    private final Coordinator global;
    
    /** The names. */
    private final Vector names = new Vector();
    
    /** The steps. */
    private final Vector steps = new Vector();
    
    /** The current step. */
    private int currentStep = 0;
    
    /** The initialized. */
    private boolean initialized = false;
    
    /**
     * Instantiates a new procedure.
     */
    public Procedure () {
        this(new Coordinator());
    }
    
    /**
     * Instantiates a new procedure.
     *
     * @param global the global
     */
    public Procedure (Coordinator global) {
        this.global = global;
    }
    
    /**
     * Apply.
     *
     * @param modules the modules
     */
    protected void apply (ModuleManager modules) {}
    
    /**
     * Attach.
     *
     * @param modules the modules
     */
    public void attach (ModuleManager modules) {
        global.attach(modules);
        
        steps.removeAllElements();
        this.apply(modules);
        
        final Enumeration i = steps.elements();
        while (i.hasMoreElements()) ((Step) i.nextElement()).attach(modules);
    }
    
    /**
     * Adds the.
     *
     * @param name the name
     * @param step the step
     */
    protected void add (String name, Step step) {
        names.addElement(name);
        steps.addElement(step);
    }
    
    /**
     * Update.
     */
    public void update () {
        global.update();
        
        if (currentStep < steps.size()) {
            final Step step = (Step) steps.elementAt(currentStep);

            if (step.complete()) {
                Logger.log(" ---- Completed step: " + names.elementAt(currentStep));
                
                currentStep++;
                initialized = false;
            } else {
                if (!initialized) {
                    initialized = true;
                    step.initialize();
                    
                    Logger.log(" ---- Entered step: " + names.elementAt(currentStep));
                }
                step.update();
            }
        }
    }
    
    /**
     * Reset.
     */
    public void reset () {
        currentStep = 0;
        initialized = false;
    }
}
