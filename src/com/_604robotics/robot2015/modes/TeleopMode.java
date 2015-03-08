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
        manipulator.rightStick.Y.setFactor(-1);
        
        manipulator.leftStick.Y.setDeadband(0.2);
        manipulator.rightStick.Y.setDeadband(0.2);
        
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
            	/* Standard Drive */
            	{
            		this.bind(new Binding(modules.getModule("Drive").getAction("Throttled Tank Drive"), new TriggerOr(new TriggerAccess[] {
                    		modules.getModule("Dashboard").getTrigger("Debugging Off"),
                    		new TriggerAnd(new TriggerAccess[] {
                    				modules.getModule("Dashboard").getTrigger("Drive On"),
                    				modules.getModule("Dashboard").getTrigger("Debugging On"),
                    				modules.getModule("Dashboard").getTrigger("Geared Tank Drive")
                    		})
                    		})));
                    this.fill(new DataWire(modules.getModule("Drive").getAction("Throttled Tank Drive"), "left",  driver.leftStick.Y));
                    this.fill(new DataWire(modules.getModule("Drive").getAction("Throttled Tank Drive"), "right", driver.rightStick.Y));
                    /* Gear Shifting */
                    {
                    	this.bind(new Binding(modules.getModule("Gear").getAction("Upshift"),   driver.buttons.RB));
                        this.bind(new Binding(modules.getModule("Gear").getAction("Downshift"), driver.buttons.LB));
                    }
            	}
            	/* Debugging and other Movement*/
            	{
            		this.bind(new Binding(modules.getModule("Drive").getAction("Off"), new TriggerAnd(new TriggerAccess[] {
                    		modules.getModule("Dashboard").getTrigger("Drive Off"),
                    		modules.getModule("Dashboard").getTrigger("Debugging On")})));
            		
            		this.bind(new Binding(modules.getModule("Drive").getAction("Tank Drive"), new TriggerAnd(new TriggerAccess[] {
                    		modules.getModule("Dashboard").getTrigger("Drive On"),
                    		modules.getModule("Dashboard").getTrigger("Debugging On"),
                    		modules.getModule("Dashboard").getTrigger("Tank Drive")})));
                    this.fill(new DataWire(modules.getModule("Drive").getAction("Tank Drive"), "left",  driver.leftStick.Y));
                    this.fill(new DataWire(modules.getModule("Drive").getAction("Tank Drive"), "right", driver.rightStick.Y));
                    
                    this.bind(new Binding(modules.getModule("Drive").getAction("Arcade Drive"), new TriggerAnd(new TriggerAccess[] {
                    		modules.getModule("Dashboard").getTrigger("Drive On"),
                    		modules.getModule("Dashboard").getTrigger("Debugging On"),
                    		modules.getModule("Dashboard").getTrigger("Arcade Drive")})));
                    this.fill(new DataWire(modules.getModule("Drive").getAction("Arcade Drive"), "throttle", driver.leftStick.Y));
                    this.fill(new DataWire(modules.getModule("Drive").getAction("Arcade Drive"), "turn",     driver.rightStick.X));
                    
                    this.bind(new Binding(modules.getModule("Drive").getAction("Stick Drive"), new TriggerAnd(new TriggerAccess[] {
                    		modules.getModule("Dashboard").getTrigger("Drive On"),
                    		modules.getModule("Dashboard").getTrigger("Debugging On"),
                    		modules.getModule("Dashboard").getTrigger("Stick Drive")})));
                    this.fill(new DataWire(modules.getModule("Drive").getAction("Stick Drive"), "throttle", driver.leftStick.Y));
                    this.fill(new DataWire(modules.getModule("Drive").getAction("Stick Drive"), "turn",     driver.leftStick.X));
                    
                    this.bind(new Binding(modules.getModule("Drive").getAction("Servo Drive"), new TriggerAnd(new TriggerAccess[] {
                    		modules.getModule("Dashboard").getTrigger("Drive On"),
                    		modules.getModule("Dashboard").getTrigger("Debugging On"),
                    		modules.getModule("Dashboard").getTrigger("Servo Drive"),
                    		driver.buttons.Back})));
            	}
            }
        }
        /* Manipulator Controller */
        {
        	/* Elevator Manual Operation */
            {
                this.fill(new DataWire(modules.getModule("Elevator").getAction("Manual"), "power",     manipulator.leftStick.Y));
                this.fill(new DataWire(modules.getModule("Elevator").getAction("Manual"), "force",     manipulator.buttons.RightStick));
                this.fill(new DataWire(modules.getModule("Elevator").getAction("Manual"), "calibrate", manipulator.buttons.Back));
                this.fill(new DataWire(modules.getModule("Elevator").getAction("Manual"), "slow mode", manipulator.buttons.LT));
            }
            /* Elevator Setpoints */
            {
            	this.bind(new Binding(modules.getModule("Elevator").getAction("Hold"),            manipulator.buttons.X));
            	this.bind(new Binding(modules.getModule("Elevator").getAction("Teselation Setpoint"), manipulator.buttons.RT));
                this.bind(new Binding(modules.getModule("Elevator").getAction("Test Setpoint 1"), manipulator.buttons.A));
                this.bind(new Binding(modules.getModule("Elevator").getAction("Test Setpoint 1.5"), manipulator.dpad.imprecise.DOWN));
                this.bind(new Binding(modules.getModule("Elevator").getAction("Test Setpoint 2"), manipulator.buttons.B));
                this.bind(new Binding(modules.getModule("Elevator").getAction("Test Setpoint 3"), new TriggerOr(new TriggerAccess[] {
                		manipulator.buttons.Y, manipulator.dpad.imprecise.UP
                })));
            }
            /* Intake */
        	{	
                this.bind(new Binding(modules.getModule("Clamp").getAction("Open"),  manipulator.buttons.LB));
                this.bind(new Binding(modules.getModule("Clamp").getAction("Close"), manipulator.buttons.RB));
                
                
                this.bind(new Binding(modules.getModule("Intake").getAction("Run")));
                this.fill(new DataWire(modules.getModule("Intake").getAction("Run"), "power", driver.rightStick.Y));
        	}
        }
    }
}
