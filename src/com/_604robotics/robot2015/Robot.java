package com._604robotics.robot2015;

import com._604robotics.robot2015.modes.AutonomousMode;
import com._604robotics.robot2015.modes.TeleopMode;
import com._604robotics.robot2015.modules.Drive;
import com._604robotics.robotnik.RobotTemplate;
import com._604robotics.robotnik.coordinator.CoordinatorList;
import com._604robotics.robotnik.procedure.ModeMap;
import com._604robotics.robotnik.module.ModuleMap;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends RobotTemplate {
    public Robot () {
        this.set(new ModuleMap() {{
            add("Drive", new Drive());
        }});
        
        this.set(new ModeMap() {{
            setAutonomousMode(new AutonomousMode());
            setTeleopMode(new TeleopMode());
        }});
    }
}
