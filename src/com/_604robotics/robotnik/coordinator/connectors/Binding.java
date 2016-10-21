package com._604robotics.robotnik.coordinator.connectors;

import com._604robotics.robotnik.prefabs.trigger.TriggerAlways;
import com._604robotics.robotnik.trigger.TriggerAccess;
import com._604robotics.robotnik.trigger.TriggerRecipient;

/**
 * Binds a trigger access to a trigger recipient.
 */
public class Binding {
    private final TriggerRecipient recipient;
    private final TriggerAccess trigger;
    private final boolean safety;

    /**
     * Creates a binding that is always triggered.
     * @param recipient Recipient of the trigger.
     */
    public Binding (TriggerRecipient recipient) {
        this(recipient, TriggerAlways.getInstance(), false);
    }

    /**
     * Creates a binding that is always triggered.
     * @param recipient Recipient of the trigger.
     * @param safety Whether the binding is safety-related.
     */
    public Binding (TriggerRecipient recipient, boolean safety) {
        this(recipient, TriggerAlways.getInstance(), safety);
    }

    /**
     * Creates a binding.
     * @param recipient Recipient of the trigger.
     * @param trigger Trigger to bind.
     */
    public Binding (TriggerRecipient recipient, TriggerAccess trigger) {
        this(recipient, trigger, false);
    }

    /**
     * Creates a binding.
     * @param recipient Recipient of the trigger.
     * @param trigger Trigger to bind.
     * @param safety Whether the binding is safety-related.
     */
    public Binding (TriggerRecipient recipient, TriggerAccess trigger, boolean safety) {
        this.recipient = recipient;
        this.trigger = trigger;
        
        this.safety = safety;
    }

    /**
     * Gets the recipient of the trigger.
     * @return The trigger's recipient.
     */
    public TriggerRecipient getRecipient () {
        return this.recipient;
    }

    /**
     * Gets the source trigger of the binding.
     * @return The binding's source trigger.
     */
    public TriggerAccess getTrigger () {
        return this.trigger;
    }

    /**
     * Gets whether the binding is safety-related.
     * @return Whether the binding is safety-related.
     */
    public boolean isSafety () {
        return this.safety;
    }
    
    /**
     * Conducts the binding.
     */
    public void conduct () {
        if (getTrigger().get()) {
            getRecipient().sendTrigger(isSafety() ? 2D : 1D);
        }
    }
}