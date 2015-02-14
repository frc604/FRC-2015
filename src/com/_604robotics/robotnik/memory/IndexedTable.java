package com._604robotics.robotnik.memory;

import edu.wpi.first.wpilibj.networktables2.util.Set;
import edu.wpi.first.wpilibj.tables.ITable;
import edu.wpi.first.wpilibj.tables.TableKeyNotDefinedException;

// TODO: Auto-generated Javadoc
/**
 * The Class IndexedTable.
 */
public class IndexedTable {
    
    /**
     * Gets the table.
     *
     * @param key the key
     * @return the table
     */
    public static IndexedTable getTable (String key) {
        return TableCache.getTable(key);
    }
    
    /** The keys. */
    private final Set keys = new Set();
    
    /** The table. */
    private final ITable table;
    
    /**
     * Knows about.
     *
     * @param key the key
     * @return true, if successful
     */
    public boolean knowsAbout (String key) {
        return this.keys.contains(key);
    }
    
    /**
     * Gets the slice.
     *
     * @param key the key
     * @return the slice
     */
    public Slice getSlice (String key) {
        return new Slice(this, key);
    }
    
    /**
     * Gets the sub table.
     *
     * @param key the key
     * @return the sub table
     */
    public IndexedTable getSubTable(String key) {
        this.addKey(key);
        return TableCache.getSubTable(this.table, key);
    }
    
    /**
     * Gets the string.
     *
     * @param key the key
     * @param defaultValue the default value
     * @return the string
     */
    public String  getString  (String key, String  defaultValue) { return this.table.getString (key,  defaultValue); }
    
    /**
     * Gets the number.
     *
     * @param key the key
     * @param defaultValue the default value
     * @return the number
     */
    public double  getNumber  (String key, double  defaultValue) { return this.table.getNumber (key,  defaultValue); }
    
    /**
     * Gets the boolean.
     *
     * @param key the key
     * @param defaultValue the default value
     * @return the boolean
     */
    public boolean getBoolean (String key, boolean defaultValue) { return this.table.getBoolean(key, defaultValue); }
    
    /**
     * Gets the value.
     *
     * @param key the key
     * @return the value
     * @throws TableKeyNotDefinedException the table key not defined exception
     */
    public Object  getValue   (String key) throws TableKeyNotDefinedException { return this.table.getValue(key); }
    
    /**
     * Put string.
     *
     * @param key the key
     * @param value the value
     */
    public void putString  (String key, String  value) { this.table.putString (key, value); this.addKey(key); }
    
    /**
     * Put number.
     *
     * @param key the key
     * @param value the value
     */
    public void putNumber  (String key, double  value) { this.table.putNumber (key, value); this.addKey(key); }
    
    /**
     * Put boolean.
     *
     * @param key the key
     * @param value the value
     */
    public void putBoolean (String key, boolean value) { this.table.putBoolean(key, value); this.addKey(key); }
    
    /**
     * Put value.
     *
     * @param key the key
     * @param value the value
     */
    public void putValue   (String key, Object  value) { this.table.putValue  (key, value); this.addKey(key); }
    
    /**
     * Adds the key.
     *
     * @param key the key
     */
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
     * Instantiates a new indexed table.
     *
     * @param table the table
     */
    protected IndexedTable (ITable table) {
        this.table = table;
    }
    
    /**
     * The Class Slice.
     */
    public class Slice {
        
        /** The source. */
        private final IndexedTable source;
        
        /** The key. */
        private final String key;
        
        /**
         * Instantiates a new slice.
         *
         * @param source the source
         * @param key the key
         */
        private Slice (IndexedTable source, String key) {
            this.source = source;
            this.key = key;
        }
        
        /**
         * Gets the string.
         *
         * @param defaultValue the default value
         * @return the string
         */
        public String  getString  (String  defaultValue) { return this.source.getString (this.key, defaultValue); }
        
        /**
         * Gets the number.
         *
         * @param defaultValue the default value
         * @return the number
         */
        public double  getNumber  (double  defaultValue) { return this.source.getNumber (this.key, defaultValue); }
        
        /**
         * Gets the boolean.
         *
         * @param defaultValue the default value
         * @return the boolean
         */
        public boolean getBoolean (boolean defaultValue) { return this.source.getBoolean(this.key, defaultValue); }
        
        /**
         * Gets the value.
         *
         * @return the value
         * @throws TableKeyNotDefinedException the table key not defined exception
         */
        public Object  getValue   () throws TableKeyNotDefinedException { return this.source.getValue(this.key); }
        
        /**
         * Put string.
         *
         * @param value the value
         */
        public void putString  (String  value) { this.source.putString (this.key, value); }
        
        /**
         * Put number.
         *
         * @param value the value
         */
        public void putNumber  (double  value) { this.source.putNumber (this.key, value); }
        
        /**
         * Put boolean.
         *
         * @param value the value
         */
        public void putBoolean (boolean value) { this.source.putBoolean(this.key, value); }
        
        /**
         * Put value.
         *
         * @param value the value
         */
        public void putValue   (Object  value) { this.source.putValue  (this.key, value); }
    }
}
