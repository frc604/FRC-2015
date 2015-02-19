package com._604robotics.robotnik.meta;

import java.util.Hashtable;

// TODO: Auto-generated Javadoc
/**
 * It "repackages" by moving all the keys and values from one hashtable to a second hashtable
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
     * Puts all the keys and values into the hashtable using the iterator
     *
     * @param iterator used to iterate through the hashtable
     * @return the hashtable that all the keys and values from the iterator have been put in
     */
    private Hashtable compute (Iterator i) {
        final Hashtable table = new Hashtable();
        while (i.next()) {
            table.put(i.key, this.wrap(i.key, i.value));
        }
        return table;
    }

    /**
     * Uses the private compute method to repackage a hashtable
     *
     * @param the iterator the hashtable is attached to
     * @param r the r
     * @return the repackaged hashtable
     */
    public static Hashtable repackage (Iterator i, Repackager r) {
        return r.compute(i);
    }
}
