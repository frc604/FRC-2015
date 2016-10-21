package com._604robotics.robotnik;

import com._604robotics.robotnik.logging.Logger;

/**
 * Exception safety modes.
 */
public enum Safety {
    /**
     * Exception safety enabled.
     */
	ENABLED,
	/**
	 * Exception safety disabled.
	 */
	DISABLED;
	
    /**
     * Gets whether the safety mode enables exception safety.
     * @return Whether the safety mode enables exception safety.
     */
	public boolean enabled () {
		return this == ENABLED;
	}
	
    /**
     * Gets whether the safety mode disables exception safety.
     * @return Whether the safety mode disables exception safety.
     */
	public boolean disabled () {
		return this == DISABLED;
	}

	/**
	 * Runs code, safely catching any exceptions if safety is enabled.
	 * @param desc Description of the code to run.
	 * @param todo Code to run.
	 */
	public void wrap (String desc, Runnable todo) {
        if (enabled()) {
            try {
                todo.run();
            } catch (Exception e) {
                Logger.error("Caught exception " + desc, e);
            }
        } else {
            todo.run();
        }
    }
}
