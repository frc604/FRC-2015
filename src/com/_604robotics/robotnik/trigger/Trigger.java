package com._604robotics.robotnik.trigger;

/**
 * A general-purpose trigger.
 */
public interface Trigger {
    /**
     * Retrieves the current value of the trigger.
     * @return The trigger's current value.
     */
    public boolean run ();
}
