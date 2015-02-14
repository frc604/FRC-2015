package com._604robotics.robotnik;

import com._604robotics.robotnik.coordinator.CoordinatorList;
import com._604robotics.robotnik.module.ModuleManager;
import com._604robotics.robotnik.logging.Logger;
import com._604robotics.robotnik.procedure.Procedure;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// TODO: Auto-generated Javadoc
/**
 * The Class RobotProxy.
 */
public class RobotProxy {
    
    /** The active. */
    private static boolean active = true;
    
    /**
     * Disable.
     */
    protected static void disable () { active = false; }
    
    /**
     * Tick.
     *
     * @param mode the mode
     * @param modules the modules
     * @param coordinators the coordinators
     */
    public static void tick (Procedure mode, ModuleManager modules, CoordinatorList coordinators) {
        if (active) {
            try {
                process(mode, modules, coordinators);
            } catch (Exception ex) {
                Logger.error("Caught error in main tick loop", ex);
            }
        } else {
            process(mode, modules, coordinators);
        }
    }
    
    /**
     * Process.
     *
     * @param mode the mode
     * @param modules the modules
     * @param coordinators the coordinators
     */
    private static void process (Procedure mode, ModuleManager modules, CoordinatorList coordinators) {
        modules.update();

        coordinators.update();
        mode.update();

        modules.execute();
    }
    
    /**
     * Start.
     *
     * @param modules the modules
     */
    public static void start (ModuleManager modules) {
        modules.start();
    }
    
    /**
     * Update.
     *
     * @param modules the modules
     */
    public static void update (ModuleManager modules) {
        if (active) {
            try {
                modules.update();
            } catch (Exception ex) {
                Logger.error("Caught error in main update loop", ex);
            }
        } else {
            modules.update();
        }
    }
    
    /**
     * End.
     *
     * @param mode the mode
     * @param modules the modules
     */
    public static void end (Procedure mode, ModuleManager modules) {
        if (active) {
            try {
                modules.end();
                mode.reset();
            } catch (Exception ex) {
                Logger.error("Caught error in main loop end", ex);
            }
        } else {
            modules.end();
        }
    }
}
