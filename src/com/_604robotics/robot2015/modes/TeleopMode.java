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

public class TeleopMode extends Coordinator {
    //private final JoystickController leftDrive  = new JoystickController(1);
    //private final JoystickController rightDrive = new JgoystickController(2);
    
    private final XboxController     driver = new XboxController(0);
//    private final XboxController manipulator = new XboxController(2);
    
    public TeleopMode () {
        /*leftDrive.axisX.setFactor(-1);
        leftDrive.axisY.setFactor(-1);
        
        rightDrive.axisY.setFactor(-1);*/
        
//        manipulator.leftStick.Y.setFactor(-1);
//        manipulator.leftStick.X.setFactor(-1);
        
        /*leftDrive.axisX.setDeadband(0.3);
        leftDrive.axisY.setDeadband(0.3);
        
        rightDrive.axisY.setDeadband(0.3);*/
        
//        manipulator.leftStick.X.setDeadband(0.3);
//        manipulator.leftStick.Y.setDeadband(0.3);
        
        driver.leftStick.X.setFactor(-1);
        driver.rightStick.X.setFactor(-1);
        
        driver.leftStick.Y.setFactor(-1);
        driver.rightStick.Y.setFactor(-1);
        
        driver.leftStick.X.setDeadband(0.2);
        driver.rightStick.X.setDeadband(0.2);
        
        driver.leftStick.Y.setDeadband(0.2);
        driver.rightStick.Y.setDeadband(0.2);
    }
    
    protected void apply (ModuleManager modules) {
    	/* Drive Controller */
        {
            /* Drive */
            {
                this.bind(new Binding(modules.getModule("Drive").getAction("Tank Drive"), modules.getModule("Dashboard").getTrigger("Tank Drive")));
                this.fill(new DataWire(modules.getModule("Drive").getAction("Tank Drive"), "left",  driver.leftStick.Y));
                this.fill(new DataWire(modules.getModule("Drive").getAction("Tank Drive"), "right", driver.rightStick.Y));
                
                //this.fill(new DataWire(modules.getModule("Drive").getAction("Tank Drive"), "left", leftDrive.axisY));
                //this.fill(new DataWire(modules.getModule("Drive").getAction("Tank Drive"), "right", rightDrive.axisY));
                
                this.bind(new Binding(modules.getModule("Drive").getAction("Arcade Drive"), modules.getModule("Dashboard").getTrigger("Arcade Drive")));
                this.fill(new DataWire(modules.getModule("Drive").getAction("Arcade Drive"), "throttle", driver.leftStick.Y));
                this.fill(new DataWire(modules.getModule("Drive").getAction("Arcade Drive"), "turn",     driver.rightStick.X));
                
                //this.fill(new DataWire(modules.getModule("Drive").getAction("Arcade Drive"), "throttle", rightDrive.axisY));
                //this.fill(new DataWire(modules.getModule("Drive").getAction("Arcade Drive"), "turn", leftDrive.axisX));
                
                this.bind(new Binding(modules.getModule("Drive").getAction("Stick Drive"), modules.getModule("Dashboard").getTrigger("Stick Drive")));
                this.fill(new DataWire(modules.getModule("Drive").getAction("Stick Drive"), "throttle", driver.leftStick.Y));
                this.fill(new DataWire(modules.getModule("Drive").getAction("Stick Drive"), "turn",     driver.leftStick.X));
                
                //this.fill(new DataWire(modules.getModule("Drive").getAction("Stick Drive"), "throttle", leftDrive.axisY));
                //this.fill(new DataWire(modules.getModule("Drive").getAction("Stick Drive"), "turn", leftDrive.axisX));
                
                this.bind(new Binding(modules.getModule("Drive").getAction("Off"), modules.getModule("Dashboard").getTrigger("Off")));
            }
        }
}}
