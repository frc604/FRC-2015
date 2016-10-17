package com._604robotics.robotnik.memory;

import java.util.HashSet;
import java.util.Set;
import edu.wpi.first.wpilibj.tables.ITable;

/**
 * An indexed table of values.
 */
public class IndexedTable {
    /**
     * Gets a table.
     * @param key Key of the table.
     * @return The received table.
     */
    public static IndexedTable getTable (String key) {
        return TableCache.getTable(key);
    }

    private final Set<String> keys = new HashSet<String>();
    private final ITable table;

    /**
     * Gets whether the table knows about a key.
     * @param key Key to check.
     * @return Whether the table knows about the key.
     */
    public boolean knowsAbout (String key) {
        return this.keys.contains(key);
    }

    /**
     * Gets a slice from the table.
     * @param key Key of the slice.
     * @return The retrieved slice.
     */
    public Slice getSlice (String key) {
        return new Slice(this, key);
    }

    /**
     * Gets a sub table of the table.
     * @param key Key of the sub table.
     * @return The retrieved sub table.
     */
    public IndexedTable getSubTable(String key) {
        this.addKey(key);
        return TableCache.getSubTable(this.table, key);
    }

    /**
     * Gets a string from the table.
     * @param key Key of the string.
     * @param defaultValue Default value to use if the key is not found.
     * @return The retrieved string.
     */
    public String getString (String key, String  defaultValue) {
        return this.table.getString(key,  defaultValue);
    }

    /**
     * Gets a number from the table.
     * @param key Key of the number.
     * @param defaultValue Default value to use if the key is not found.
     * @return The retrieved number.
     */
    public double getNumber (String key, double defaultValue) {
        return this.table.getNumber(key,  defaultValue);
    }

    /**
     * Gets a boolean from the table.
     * @param key Key of the boolean.
     * @param defaultValue Default value to use if the key is not found.
     * @return The retrieved boolean.
     */
    public boolean getBoolean (String key, boolean defaultValue) {
        return this.table.getBoolean(key, defaultValue);
    }

    /**
     * Gets a raw value from the table.
     * @param key Key of the raw value.
     * @param defaultValue Default value to use if the key is not found.
     * @return The retrieved raw value.
     */
    public Object getValue (String key, Object defaultValue) {
        return this.table.getValue(key, defaultValue);
    }

    /**
     * Puts a string in the table.
     * @param key Key of the string.
     * @param value Value to put.
     */
    public void putString (String key, String value) {
        this.table.putString(key, value);
        this.addKey(key);
    }

    /**
     * Puts a number in the table.
     * @param key Key of the number.
     * @param value Value to put.
     */
    public void putNumber (String key, double value) {
        this.table.putNumber(key, value);
        this.addKey(key);
    }

    /**
     * Puts a boolean in the table.
     * @param key Key of the boolean.
     * @param value Value to put.
     */
    public void putBoolean (String key, boolean value) {
        this.table.putBoolean(key, value);
        this.addKey(key);
    }

    /**
     * Puts a raw value in the table.
     * @param key Key of the raw value.
     * @param value Value to put.
     */
    public void putValue (String key, Object value) {
        this.table.putValue(key, value);
        this.addKey(key);
    }

    private void addKey (String key) {
        if (!this.keys.contains(key)) {
            this.keys.add(key);
            
            final String keyList = this.table.getString("__index", "");
            if (keyList.equals("")) {
                this.table.putString("__index", key);
            } else {
                this.table.putString("__index", keyList + ";" + key);
            }
        }
    }

    /**
     * Creates a table.
     * @param table The backing ITable to use.
     */
    protected IndexedTable (ITable table) {
        this.table = table;
    }

    /**
     * A slice of a table.
     */
    public class Slice {
        private final IndexedTable source;
        private final String key;

        private Slice (IndexedTable source, String key) {
            this.source = source;
            this.key = key;
        }

        /**
         * Gets the slice's string value.
         * @param defaultValue Default value to use if the slice is empty.
         * @return The slice's string value.
         */
        public String getString (String defaultValue) {
            return this.source.getString(this.key, defaultValue);
        }

        /**
         * Gets the slice's number value.
         * @param defaultValue Default value to use if the slice is empty.
         * @return The slice's number value.
         */
        public double getNumber (double defaultValue) {
            return this.source.getNumber(this.key, defaultValue);
        }

        /**
         * Gets the slice's boolean value.
         * @param defaultValue Default value to use if the slice is empty.
         * @return The slice's boolean value.
         */
        public boolean getBoolean (boolean defaultValue) {
            return this.source.getBoolean(this.key, defaultValue);
        }

        /**
         * Gets the slice's raw value.
         * @param defaultValue Default value to use if the slice is empty.
         * @return The slice's raw value.
         */
        public Object getValue (Object defaultValue) {
            return this.source.getValue(this.key, defaultValue);
        }

        /**
         * Puts a string in the slice.
         * @param value Value to put.
         */
        public void putString (String value) {
            this.source.putString(this.key, value);
        }

        /**
         * Puts a number in the slice.
         * @param value Value to put.
         */
        public void putNumber (double value) {
            this.source.putNumber(this.key, value);
        }

        /**
         * Puts a boolean in the slice.
         * @param value Value to put.
         */
        public void putBoolean (boolean value) {
            this.source.putBoolean(this.key, value);
        }

        /**
         * Puts a raw value in the slice.
         * @param value Value to put.
         */
        public void putValue (Object value) {
            this.source.putValue(this.key, value);
        }
    }
}
