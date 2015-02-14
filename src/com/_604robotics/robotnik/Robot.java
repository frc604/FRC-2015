package com._604robotics.robotnik;

import com._604robotics.robotnik.coordinator.CoordinatorList;
import com._604robotics.robotnik.procedure.ModeMap;
import com._604robotics.robotnik.module.ModuleManager;
import com._604robotics.robotnik.module.ModuleMap;
import com._604robotics.robotnik.memory.IndexedTable;
import com._604robotics.robotnik.logging.Logger;
import com._604robotics.robotnik.logging.TimeSampler;
import com._604robotics.robotnik.procedure.Procedure;

import edu.wpi.first.wpilibj.SampleRobot;

// TODO: Auto-generated Javadoc
/**
 * The Class Robot.
 */
public class Robot extends SampleRobot {
    
    /**
     * The Interface Safety.
     */
    public static interface Safety {
        
        /** The enabled. */
        public static boolean ENABLED  = true;
        
        /** The disabled. */
        public static boolean DISABLED = false;
    }
    
    /** The table. */
    private final IndexedTable table = IndexedTable.getTable("robotnik");
    
    /** The loop time. */
    private final TimeSampler loopTime = new TimeSampler("Loop", 1D);
    
    /** The module manager. */
    private ModuleManager moduleManager = new ModuleManager(new ModuleMap(), this.table.getSubTable("modules"));
    
    /** The coordinator list. */
    private CoordinatorList coordinatorList = new CoordinatorList();
    
    /** The mode map. */
    private ModeMap modeMap = new ModeMap();
    
    /**
     * Instantiates a new robot.
     */
    public Robot () {}
    
    /**
     * Instantiates a new robot.
     *
     * @param safetyEnabled the safety enabled
     */
    public Robot (boolean safetyEnabled) {
        if (!safetyEnabled) {
            RobotProxy.disable();
            
            DataProxy.disable();
            TriggerProxy.disable();
            ActionProxy.disable();

            ConnectorProxy.disable();

            Logger.warn("Exception protection has been disabled. Make sure you know what you're doing!");
        }
    }
    
    /**
     * Sets the.
     *
     * @param moduleMap the module map
     */
    protected void set (ModuleMap moduleMap) {
        this.moduleManager = new ModuleManager(moduleMap, this.table.getSubTable("modules"));
    }
    
    /**
     * Sets the.
     *
     * @param coordinatorList the coordinator list
     */
    protected void set (CoordinatorList coordinatorList) {
        this.coordinatorList = coordinatorList;
    }
    
    /**
     * Sets the.
     *
     * @param modeMap the mode map
     */
    protected void set (ModeMap modeMap) {
        this.modeMap = modeMap;
    }
    
    /* (non-Javadoc)
     * @see edu.wpi.first.wpilibj.SampleRobot#robotInit()
     */
    public void robotInit () {
        this.coordinatorList.attach(this.moduleManager);
        this.modeMap.attach(this.moduleManager);
    }
    
    /* (non-Javadoc)
     * @see edu.wpi.first.wpilibj.SampleRobot#autonomous()
     */
    public void autonomous () {
        Logger.log(" -- Autonomous mode begin.");
        
        this.loopTime.start();
        RobotProxy.start(moduleManager);
        
        final Procedure mode = this.modeMap.getAutonomousMode();
        while (this.isEnabled() && this.isAutonomous()) {
            RobotProxy.tick(mode, moduleManager, coordinatorList);
            this.loopTime.sample();
        }
        
        RobotProxy.end(mode, moduleManager);
        this.loopTime.stop();

        Logger.log(" -- Autonomous mode end.");
    }
    
    /* (non-Javadoc)
     * @see edu.wpi.first.wpilibj.SampleRobot#operatorControl()
     */
    public void operatorControl () {
        Logger.log(" -- Teleop mode begin.");
        this.loopTime.start();
        RobotProxy.start(moduleManager);
        
        final Procedure mode = this.modeMap.getTeleopMode();
        while (this.isEnabled() && this.isOperatorControl()) {
        	System.out.println("teleop tick");
            RobotProxy.tick(mode, moduleManager, coordinatorList);
            this.loopTime.sample();
        }
        
        RobotProxy.end(mode, moduleManager);
        this.loopTime.stop();
        
        Logger.log(" -- Teleop mode end.");
    }
    
    /* (non-Javadoc)
     * @see edu.wpi.first.wpilibj.SampleRobot#disabled()
     */
    public void disabled () {
        Logger.log(" -- Disabled mode begin.");
        
        while (!this.isEnabled()) RobotProxy.update(moduleManager);
        
        Logger.log(" -- Disabled mode end.");
    }
}