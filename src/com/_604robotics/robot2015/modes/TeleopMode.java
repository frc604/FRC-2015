package com._604robotics.robot2015.modes;

import com._604robotics.robotnik.coordinator.Coordinator;
import com._604robotics.robotnik.coordinator.connectors.Binding;
import com._604robotics.robotnik.coordinator.connectors.DataWire;
import com._604robotics.robotnik.module.ModuleManager;
import com._604robotics.robotnik.prefabs.controller.xbox.XboxController;
import com._604robotics.robotnik.prefabs.trigger.TriggerAnd;
import com._604robotics.robotnik.prefabs.trigger.TriggerNot;
import com._604robotics.robotnik.prefabs.trigger.TriggerOr;
import com._604robotics.robotnik.prefabs.trigger.TriggerToggle;
import com._604robotics.robotnik.trigger.TriggerAccess;

// TODO: Auto-generated Javadoc
/**
 * The Class TeleopMode.
 */
public class TeleopMode extends Coordinator {
    /** The driver. */
    private final XboxController     driver = new XboxController(0);

    /** The manipulator */
    private final XboxController manipulator = new XboxController(2);
    
    /**
 * Instantiates a new teleop mode.
 */
public TeleopMode () {
        
        manipulator.leftStick.Y.setFactor(-1);
        manipulator.leftStick.X.setFactor(-1);
        
        manipulator.leftStick.X.setDeadband(0.3);
        manipulator.leftStick.Y.setDeadband(0.3);
        
        driver.leftStick.X.setFactor(-1);
        driver.rightStick.X.setFactor(-1);
        
        driver.leftStick.Y.setFactor(-1);
        driver.rightStick.Y.setFactor(-1);
        
        driver.leftStick.X.setDeadband(0.2);
        driver.rightStick.X.setDeadband(0.2);
        
        driver.leftStick.Y.setDeadband(0.2);
        driver.rightStick.Y.setDeadband(0.2);
    }
    
    /* (non-Javadoc)
     * @see com._604robotics.robotnik.coordinator.Coordinator#apply(com._604robotics.robotnik.module.ModuleManager)
     */
    protected void apply (ModuleManager modules) {
    	/* Drive Controller */
        {
            /* Drive */
            {
                this.bind(new Binding(modules.getModule("Drive").getAction("Tank Drive"), new TriggerAnd(new TriggerAccess[] {
                		modules.getModule("Dashboard").getTrigger("On"), modules.getModule("Dashboard").getTrigger("Tank Drive")})));
                this.fill(new DataWire(modules.getModule("Drive").getAction("Tank Drive"), "left",  driver.leftStick.Y));
                this.fill(new DataWire(modules.getModule("Drive").getAction("Tank Drive"), "right", driver.rightStick.Y));
                
                this.bind(new Binding(modules.getModule("Drive").getAction("Throttled Tank Drive"), new TriggerAnd(new TriggerAccess[] {
                		modules.getModule("Dashboard").getTrigger("On"), modules.getModule("Dashboard").getTrigger("Geared Tank Drive")})));
                this.fill(new DataWire(modules.getModule("Drive").getAction("Throttled Tank Drive"), "left",  driver.leftStick.Y));
                this.fill(new DataWire(modules.getModule("Drive").getAction("Throttled Tank Drive"), "right", driver.rightStick.Y));
                
                this.bind(new Binding(modules.getModule("Drive").getAction("Arcade Drive"), new TriggerAnd(new TriggerAccess[] {
                		modules.getModule("Dashboard").getTrigger("On"), modules.getModule("Dashboard").getTrigger("Arcade Drive")})));
                this.fill(new DataWire(modules.getModule("Drive").getAction("Arcade Drive"), "throttle", driver.leftStick.Y));
                this.fill(new DataWire(modules.getModule("Drive").getAction("Arcade Drive"), "turn",     driver.rightStick.X));
                
                this.bind(new Binding(modules.getModule("Drive").getAction("Stick Drive"), new TriggerAnd(new TriggerAccess[] {
                		modules.getModule("Dashboard").getTrigger("On"), modules.getModule("Dashboard").getTrigger("Stick Drive")})));
                this.fill(new DataWire(modules.getModule("Drive").getAction("Stick Drive"), "throttle", driver.leftStick.Y));
                this.fill(new DataWire(modules.getModule("Drive").getAction("Stick Drive"), "turn",     driver.leftStick.X));
                
                this.bind(new Binding(modules.getModule("Drive").getAction("Off"), modules.getModule("Dashboard").getTrigger("Off")));
                
                this.bind(new Binding(modules.getModule("Gear").getAction("Upshift"), driver.buttons.RB));
                this.bind(new Binding(modules.getModule("Gear").getAction("Downshift"), driver.buttons.LB));
                
                /* Testing Drive Servo mode */
                this.bind(new Binding(modules.getModule("Drive").getAction("Servo Drive"), new TriggerAnd(new TriggerAccess[] {
                		modules.getModule("Dashboard").getTrigger("Servo Drive"), driver.buttons.A})));
            }
        }
        /* Manipulator Controller */
        {
        	/* Manual Operation */
            {
                this.fill(new DataWire(modules.getModule("Elevator").getAction("Manual"), "power",     manipulator.leftStick.Y));
                this.fill(new DataWire(modules.getModule("Elevator").getAction("Manual"), "calibrate", manipulator.buttons.Back));
            
                this.bind(new Binding(modules.getModule("Elevator").getAction("Hold"),         manipulator.buttons.X));
                this.bind(new Binding(modules.getModule("Elevator").getAction("Test Setpoint 1"), manipulator.buttons.A));
                this.bind(new Binding(modules.getModule("Elevator").getAction("Test Setpoint 2"), manipulator.buttons.B));
                this.bind(new Binding(modules.getModule("Elevator").getAction("Test Setpoint 3"), manipulator.buttons.Y));
            }
        }
        {
        	{
        		 
//                 this.bind(new Binding(modules.getModule("clamp").getAction("Open"),   manipulator.buttons.Y));
//                 this.bind(new Binding(modules.getModule("clamp").getAction("Close"), manipulator.buttons.B));
        	}
        	
        }
    }
}
