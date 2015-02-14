package com._604robotics.robotnik.action.field;

import java.util.Enumeration;
import java.util.Vector;

// TODO: Auto-generated Javadoc
/**
 * The Class FieldMap.
 */
public class FieldMap {
    
    /** The fields. */
    private final Vector fields = new Vector();
    
    /**
     * Define.
     *
     * @param name the name
     * @param value the value
     */
    public void define (String name, double value) {
        this.fields.addElement(new Field(name, value));
    }
    
    /**
     * Define.
     *
     * @param name the name
     * @param value the value
     */
    public void define (String name, boolean value) {
        this.fields.addElement(new Field(name, value ? 1D : 0D));
    }
    
    /**
     * Enumerate.
     *
     * @return the enumeration
     */
    public Enumeration enumerate () {
        return this.fields.elements();
    }
}
