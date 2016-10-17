package com._604robotics.robotnik.data;

/**
 * A recipient of data.
 */
public interface DataRecipient {
    /**
     * Sends data to this recipient.
     * @param fieldName Name of the data field.
     * @param dataValue Value of the data.
     */
    public void sendData (String fieldName, double dataValue);
}
