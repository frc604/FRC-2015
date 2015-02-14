package com._604robotics.robotnik.data;

// TODO: Auto-generated Javadoc
/**
 * The Interface DataRecipient.
 */
public interface DataRecipient {
    
    /**
     * Send data.
     *
     * @param fieldName the field name
     * @param dataValue the data value
     */
    public abstract void sendData (String fieldName, double dataValue);
}
