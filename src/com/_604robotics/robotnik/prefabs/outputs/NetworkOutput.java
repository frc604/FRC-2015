package com._604robotics.robotnik.prefabs.outputs;

import com._604robotics.robotnik.data.DataRecipient;
import java.util.StringTokenizer;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.tables.ITable;

// TODO: Auto-generated Javadoc
/**
 * The Class NetworkOutput.
 */
public class NetworkOutput {
    
    /** The double recipient. */
    private final DataRecipient doubleRecipient;
    
    /** The boolean recipient. */
    private final DataRecipient booleanRecipient;
    
    /**
     * Instantiates a new network output.
     *
     * @param namespace the namespace
     */
    public NetworkOutput (String namespace) {
        final StringTokenizer tokens = new StringTokenizer(namespace, ".");
        
        ITable table = NetworkTable.getTable(tokens.nextToken());
        
        while (tokens.hasMoreTokens()) {
            table = table.getSubTable(tokens.nextToken());
        }
        
        this.doubleRecipient  = new NetworkOutputDataRecipient(table, false);
        this.booleanRecipient = new NetworkOutputDataRecipient(table, true);
    }
    
    /**
     * As double.
     *
     * @param name the name
     * @return the data recipient
     */
    public DataRecipient asDouble (String name) {
        return this.doubleRecipient;
    }
    
    /**
     * As boolean.
     *
     * @param name the name
     * @return the data recipient
     */
    public DataRecipient asBoolean (String name) {
        return this.booleanRecipient;
    }
    
    /**
     * The Class NetworkOutputDataRecipient.
     */
    private class NetworkOutputDataRecipient implements DataRecipient {
        
        /** The table. */
        private final ITable table;
        
        /** The as boolean. */
        private final boolean asBoolean;
        
        /**
         * Instantiates a new network output data recipient.
         *
         * @param table the table
         * @param asBoolean the as boolean
         */
        public NetworkOutputDataRecipient (ITable table, boolean asBoolean) {
            this.table = table;
            this.asBoolean = asBoolean;
        }

        /* (non-Javadoc)
         * @see com._604robotics.robotnik.data.DataRecipient#sendData(java.lang.String, double)
         */
        public void sendData (String fieldName, double dataValue) {
            if (this.asBoolean) {
                this.table.putBoolean(fieldName, dataValue > 0);
            } else {
                this.table.putNumber(fieldName, dataValue);
            }
        }
    }
}