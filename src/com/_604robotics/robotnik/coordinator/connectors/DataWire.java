package com._604robotics.robotnik.coordinator.connectors;

import com._604robotics.robotnik.data.DataAccess;
import com._604robotics.robotnik.data.DataRecipient;
import com._604robotics.robotnik.data.sources.ConstData;
import com._604robotics.robotnik.data.sources.DataTriggerAdaptor;
import com._604robotics.robotnik.trigger.TriggerAccess;

// TODO: Auto-generated Javadoc
/**
 * The Class DataWire.
 */
public class DataWire {
    
    /** The recipient. */
    private final DataRecipient recipient;
    
    /** The field name. */
    private final String fieldName;
    
    /** The data. */
    private final DataAccess data;
    
    /** The activator. */
    private final TriggerAccess activator;
    
    /**
     * Instantiates a new data wire.
     *
     * @param recipient the recipient
     * @param fieldName the field name
     * @param data the data
     */
    public DataWire (DataRecipient recipient, String fieldName, DataAccess data) {
        this(recipient, fieldName, data, null);
    }
    
    /**
     * Instantiates a new data wire.
     *
     * @param recipient the recipient
     * @param fieldName the field name
     * @param data the data
     * @param activator the activator
     */
    public DataWire (DataRecipient recipient, String fieldName, DataAccess data, TriggerAccess activator) {
        this.recipient = recipient;
        
        this.fieldName = fieldName;
        this.data = data;
        this.activator = activator;
    }
    
    /**
     * Instantiates a new data wire.
     *
     * @param recipient the recipient
     * @param fieldName the field name
     * @param trigger the trigger
     */
    public DataWire (DataRecipient recipient, String fieldName, TriggerAccess trigger) {
        this(recipient, fieldName, new DataTriggerAdaptor(trigger), null);
    }
    
    /**
     * Instantiates a new data wire.
     *
     * @param recipient the recipient
     * @param fieldName the field name
     * @param trigger the trigger
     * @param activator the activator
     */
    public DataWire (DataRecipient recipient, String fieldName, TriggerAccess trigger, TriggerAccess activator) {
        this.recipient = recipient;
        
        this.fieldName = fieldName;
        this.data = new DataTriggerAdaptor(trigger);
        this.activator = activator;
    }
    
    /**
     * Instantiates a new data wire.
     *
     * @param recipient the recipient
     * @param fieldName the field name
     * @param value the value
     */
    public DataWire (DataRecipient recipient, String fieldName, double value) {
        this(recipient, fieldName, value, null);
    }
    
    /**
     * Instantiates a new data wire.
     *
     * @param recipient the recipient
     * @param fieldName the field name
     * @param value the value
     * @param activator the activator
     */
    public DataWire (DataRecipient recipient, String fieldName, double value, TriggerAccess activator) {
        this.recipient = recipient;
        
        this.fieldName = fieldName;
        this.data = new ConstData(value);
        this.activator = activator;
    }
    
    /**
     * Instantiates a new data wire.
     *
     * @param recipient the recipient
     * @param fieldName the field name
     * @param value the value
     */
    public DataWire (DataRecipient recipient, String fieldName, boolean value) {
        this(recipient, fieldName, value, null);
    }
    
    /**
     * Instantiates a new data wire.
     *
     * @param recipient the recipient
     * @param fieldName the field name
     * @param value the value
     * @param activator the activator
     */
    public DataWire (DataRecipient recipient, String fieldName, boolean value, TriggerAccess activator) {
        this.recipient = recipient;
        
        this.fieldName = fieldName;
        this.data = new ConstData(value ? 1D : 0D);
        this.activator = activator;
    }
    
    /**
     * Checks if is active.
     *
     * @return true, if is active
     */
    public boolean isActive () {
        return this.activator == null || this.activator.get();
    }

    /**
     * Gets the recipient.
     *
     * @return the recipient
     */
    public DataRecipient getRecipient () {
        return this.recipient;
    }

    /**
     * Gets the data.
     *
     * @return the data
     */
    public DataAccess getData () {
        return this.data;
    }

    /**
     * Gets the field name.
     *
     * @return the field name
     */
    public String getFieldName () {
        return this.fieldName;
    }
}