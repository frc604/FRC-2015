package com._604robotics.robotnik.action.field;

/**
 * An action data field.
 */
public class Field {
    private final String name;
    private final double defaultValue;

    /**
     * Creates a field.
     * @param name Name of the field.
     * @param defaultValue Default value of the field.
     */
    public Field (String name, double defaultValue) {
        this.name = name;
        this.defaultValue = defaultValue;
    }

    /**
     * Gets the name of the field.
     * @return The field's name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the default value of the field.
     * @return The field's default value.
     */
    public double getDefaultValue() {
        return this.defaultValue;
    }
}
