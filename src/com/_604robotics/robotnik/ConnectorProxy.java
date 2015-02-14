package com._604robotics.robotnik;

import com._604robotics.robotnik.coordinator.connectors.Binding;
import com._604robotics.robotnik.coordinator.connectors.DataWire;
import com._604robotics.robotnik.logging.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class ConnectorProxy.
 */
public class ConnectorProxy {
    
    /** The active. */
    private static boolean active = true;
    
    /**
     * Disable.
     */
    protected static void disable () { active = false; }
    
    /**
     * Pipe.
     *
     * @param binding the binding
     */
    public static void pipe (Binding binding) {
        if (active) {
            try {
                conduct(binding);
            } catch (Exception ex) {
                Logger.error("Caught error while piping a Binding", ex);
            }
        } else {
            conduct(binding);
        }
    }
    
    /**
     * Pipe.
     *
     * @param wire the wire
     */
    public static void pipe (DataWire wire) {
        if (active) {
            try {
                conduct(wire);
            } catch (Exception ex) {
                Logger.error("Caught error while piping a DataWire", ex);
            }
        } else {
            conduct(wire);
        }
    }
    
    /**
     * Conduct.
     *
     * @param binding the binding
     */
    private static void conduct(Binding binding) {
        if (binding.getTrigger().get()) {
            binding.getRecipient().sendTrigger(binding.isSafety() ? 2D : 1D);
        }
    }
    
    /**
     * Conduct.
     *
     * @param wire the wire
     */
    private static void conduct (DataWire wire) {
        if (wire.isActive())
            wire.getRecipient().sendData(wire.getFieldName(), wire.getData().get());
    }
}
