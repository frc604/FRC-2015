package com._604robotics.robot2015;

import com._604robotics.robot2015.systems.DashboardSystem;
import com._604robotics.robot2015.modes.AutonomousMode;
import com._604robotics.robot2015.modes.TeleopMode;
import com._604robotics.robot2015.modules.Drive;
import com._604robotics.robot2015.modules.Dashboard;
import com._604robotics.robot2015.modules.Elevator;
<<<<<<< Updated upstream
=======
import com._604robotics.robot2015.modules.Intake;
>>>>>>> Stashed changes
import com._604robotics.robotnik.Robot;
import com._604robotics.robotnik.coordinator.CoordinatorList;
import com._604robotics.robotnik.procedure.ModeMap;
import com._604robotics.robotnik.module.ModuleMap;


// TODO: Auto-generated Javadoc
/**
 * The Class Robot2015.
 */
public class Robot2015 extends Robot {
    
    /**
     * Instantiates a new robot2015.
     */
    public Robot2015 () {
        this.set(new ModuleMap() {{ //creates a module map containing all of the modules
            add("Drive", new Drive());
            add("Dashboard", new Dashboard());
            add("Elevator", new Elevator());
<<<<<<< Updated upstream
=======
            add("Intake", new Intake());
>>>>>>> Stashed changes
        }});
        
        this.set(new ModeMap() {{
            setAutonomousMode(new AutonomousMode());
            setTeleopMode(new TeleopMode());
        }});
        
        this.set(new CoordinatorList() {{
            add(new DashboardSystem());
        }});
    }
}
