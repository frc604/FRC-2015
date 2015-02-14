package com._604robotics.robotnik.action.field;

// TODO: Auto-generated Javadoc
/**
 * The Class Field.
 */
public class Field {
    
    /** The name. */
    private final String name;
    
    /** The default value. */
    private final double defaultValue;
    
    /**
     * Instantiates a new field.
     *
     * @param name the name
     * @param defaultValue the default value
     */
    public Field (String name, double defaultValue) {
        this.name = name;
        this.defaultValue = defaultValue;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the default value.
     *
     * @return the default value
     */
    public double getDefaultValue() {
        return this.defaultValue;
    }
}
