package com._604robotics.robotnik.meta;

import java.util.Enumeration;
import java.util.Hashtable;

// TODO: Auto-generated Javadoc
// TODO: figure out why Iterator isn't used. http://docs.oracle.com/javase/6/docs/api/java/util/Iterator.html
/**
 * The Class Iterator. Iterates through a hashtable. 
 */
public class Iterator {
    
    /** The keys. */
    @SuppressWarnings("rawtypes")
	private final Enumeration keys;
    
    /** The values. */
    @SuppressWarnings("rawtypes")
	private final Enumeration values;
    
    /** The key. */
    public Object key = null;
    
    /** The value. */
    public Object value = null;

    /**
     * Instantiates a new iterator.
     *
     * @param table the table
     */
    @SuppressWarnings("rawtypes")
	public Iterator (Hashtable table) {
        this.keys = table.keys();
        this.values = table.elements();
    }

    /**
     * Next.
     *
     * @return true, if successful
     */
    public boolean next () {
        if (this.keys.hasMoreElements() && this.values.hasMoreElements()) {
            this.key = this.keys.nextElement();
            this.value = this.values.nextElement();
            return true;
        } else {
            this.key = null;
            this.value = null;
            return false;
        }
    }
}
