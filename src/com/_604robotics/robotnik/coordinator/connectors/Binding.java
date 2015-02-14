package com._604robotics.robotnik.coordinator.connectors;

import com._604robotics.robotnik.prefabs.trigger.TriggerAlways;
import com._604robotics.robotnik.trigger.TriggerAccess;
import com._604robotics.robotnik.trigger.TriggerRecipient;

// TODO: Auto-generated Javadoc
/**
 * The Class Binding.
 */
public class Binding {
    
    /** The recipient. */
    private final TriggerRecipient recipient;
    
    /** The trigger. */
    private final TriggerAccess trigger;
    
    /** The safety. */
    private final boolean safety;
    
    /**
     * Instantiates a new binding.
     *
     * @param recipient the recipient
     */
    public Binding (TriggerRecipient recipient) {
        this(recipient, TriggerAlways.getInstance(), false);
    }
    
    /**
     * Instantiates a new binding.
     *
     * @param recipient the recipient
     * @param safety the safety
     */
    public Binding (TriggerRecipient recipient, boolean safety) {
        this(recipient, TriggerAlways.getInstance(), safety);
    }
    
    /**
     * Instantiates a new binding.
     *
     * @param recipient the recipient
     * @param trigger the trigger
     */
    public Binding (TriggerRecipient recipient, TriggerAccess trigger) {
        this(recipient, trigger, false);
    }
    
    /**
     * Instantiates a new binding.
     *
     * @param recipient the recipient
     * @param trigger the trigger
     * @param safety the safety
     */
    public Binding (TriggerRecipient recipient, TriggerAccess trigger, boolean safety) {
        this.recipient = recipient;
        this.trigger = trigger;
        
        this.safety = safety;
    }

    /**
     * Gets the recipient.
     *
     * @return the recipient
     */
    public TriggerRecipient getRecipient () {
        return this.recipient;
    }

    /**
     * Gets the trigger.
     *
     * @return the trigger
     */
    public TriggerAccess getTrigger () {
        return this.trigger;
    }

    /**
     * Checks if is safety.
     *
     * @return true, if is safety
     */
    public boolean isSafety () {
        return this.safety;
    }
}