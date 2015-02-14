package com._604robotics.robotnik.meta;

import java.util.Hashtable;

// TODO: Auto-generated Javadoc
/**
 * The Class Repackager.
 */
public abstract class Repackager {
    
    /**
     * Wrap.
     *
     * @param key the key
     * @param value the value
     * @return the object
     */
    protected abstract Object wrap (Object key, Object value);

    /**
     * Compute.
     *
     * @param i the i
     * @return the hashtable
     */
    private Hashtable compute (Iterator i) {
        final Hashtable table = new Hashtable();
        while (i.next()) {
            table.put(i.key, this.wrap(i.key, i.value));
        }
        return table;
    }

    /**
     * Repackage.
     *
     * @param i the i
     * @param r the r
     * @return the hashtable
     */
    public static Hashtable repackage (Iterator i, Repackager r) {
        return r.compute(i);
    }
}
