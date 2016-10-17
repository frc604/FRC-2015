package com._604robotics.robotnik.trigger;

/**
 * A recipient of a trigger.
 */
public interface TriggerRecipient {
    /**
     * Sends a trigger value to this recipient.
     * @param precedence The trigger's value, greater if its precedence is higher.
     */
    public void sendTrigger (double precedence);
}
