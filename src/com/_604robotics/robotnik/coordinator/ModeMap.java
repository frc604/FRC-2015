package com._604robotics.robotnik.coordinator;

import com._604robotics.robotnik.GameMode;
import com._604robotics.robotnik.module.ModuleManager;

/**
 * A map containing robot modes.
 */
public class ModeMap {
    private Coordinator autonomousMode = new Coordinator();
    private Coordinator teleopMode = new Coordinator();
    
    /**
     * Attaches the mode map to a set of modules.
     * @param modules Modules to attach to.
     */
    public void attach (ModuleManager modules) {
        this.autonomousMode.attach(modules);
        this.teleopMode.attach(modules);
    }

    /**
     * Sets the map's autonomous mode.
     * @param autonomousMode Autonomous mode coordinator to set.
     */
    protected void setAutonomousMode (Coordinator autonomousMode) {
        this.autonomousMode = autonomousMode;
    }

    /**
     * Sets the map's teleop mode.
     * @param teleopMode Teleop mode coordinator to set.
     */
    protected void setTeleopMode (Coordinator teleopMode) {
        this.teleopMode = teleopMode;
    }

    /**
     * Gets the map's autonomous mode.
     * @return The map's autonomous mode coordinator.
     */
    public Coordinator getAutonomousMode () {
        return this.autonomousMode;
    }

    /**
     * Gets the map's teleop mode.
     * @return The map's teleop mode coordinator.
     */
    public Coordinator getTeleopMode () {
        return this.teleopMode;
    }
    
    /**
     * Gets the coordinator for a game mode.
     * @param gameMode Game mode to get the coordinator for.
     * @return The game mode's coordinator.
     */
    public Coordinator getGameMode (GameMode gameMode) {
        switch (gameMode) {
        case AUTONOMOUS:
            return getAutonomousMode();
        case TELEOP:
            return getTeleopMode();
        default:
            return null;
        }
    }
    
    /**
     * Updates the coordinator for a game mode.
     * @param gameMode Game mode to update the coordinator for.
     */
    public void update (GameMode gameMode) {
        switch (gameMode) {
        case AUTONOMOUS:
            getAutonomousMode().update();
            break;
        case TELEOP:
            getTeleopMode().update();
            break;
        default:
        }
    }
    
    /**
     * Stops the coordinator for a game mode.
     * @param gameMode Game mode to stop the coordinator for.
     */
    public void stop (GameMode gameMode) {
        switch (gameMode) {
        case AUTONOMOUS:
            getAutonomousMode().stop();
            break;
        case TELEOP:
            getTeleopMode().stop();
            break;
        default:
        }
    }
}
