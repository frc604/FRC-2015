package com._604robotics.robotnik.action.field;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A map of action data fields.
 */
public class FieldMap implements Iterable<Field> {
    private final List<Field> fields = new ArrayList<Field>();

    /**
     * Defines a double field.
     * @param name Name of the field.
     * @param defaultValue Default value of the field.
     */
    public void define (String name, double defaultValue) {
        this.fields.add(new Field(name, defaultValue));
    }

    /**
     * Defines a boolean field.
     * @param name Name of the field.
     * @param defaultValue Default value of the field.
     */
    public void define (String name, boolean defaultValue) {
        this.fields.add(new Field(name, defaultValue ? 1 : 0));
    }

    @Override
    public Iterator<Field> iterator () {
        return this.fields.iterator();
    }
}
