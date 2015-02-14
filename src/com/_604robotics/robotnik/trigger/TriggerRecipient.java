package com._604robotics.robotnik.trigger;

// TODO: Auto-generated Javadoc
/**
 * The Interface TriggerRecipient.
 */
public interface TriggerRecipient {
    
    /**
     * Send trigger.
     *
     * @param precedence the precedence
     */
    public abstract void sendTrigger (double precedence);
}
