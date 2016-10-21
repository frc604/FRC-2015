package com._604robotics.robotnik;

import edu.wpi.first.wpilibj.DriverStation;

/**
 * A stage of a robot match.
 */
public enum GameMode {
    /**
     * Robot disabled.
     */
    DISABLED("Disabled") {
        @Override
        public boolean active () {
            return !DriverStation.getInstance().isEnabled();
        }
    },
    /**
     * Robot is operating autonomously.
     */
    AUTONOMOUS("Autonomous") {
        @Override
        public boolean active () {
            return DriverStation.getInstance().isEnabled() && DriverStation.getInstance().isAutonomous();
        }
    },
    /**
     * Robot is operated by humans.
     */
    TELEOP("Teleop") {
        @Override
        public boolean active () {
            return DriverStation.getInstance().isEnabled() && DriverStation.getInstance().isOperatorControl();
        }
    };

    private final String prettyName;

    private GameMode (String prettyName) {
        this.prettyName = prettyName;
    }

    /**
     * Gets whether the game mode is active.
     * @return Whether the game mode is active.
     */
    public abstract boolean active ();

    /**
     * Gets a pretty name for the game mode, useful for text output.
     * @return The game mode's pretty name.
     */
    public String prettyName () {
        return prettyName;
    }
}
