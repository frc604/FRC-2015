package com._604robotics.robotnik.prefabs.outputs;

import com._604robotics.robotnik.data.DataRecipient;
import java.util.StringTokenizer;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.tables.ITable;

/**
 * A data recipient for outputting data to the network.
 */
public class NetworkOutput {
    private final DataRecipient doubleRecipient;
    private final DataRecipient booleanRecipient;

    /**
     * Creates a network output.
     * @param namespace Namespace to output data to.
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
     * Gets an output for double data.
     * @return An output for double data.
     */
    public DataRecipient asDouble () {
        return this.doubleRecipient;
    }

    /**
     * Gets an output for boolean data.
     * @return An output for boolean data.
     */
    public DataRecipient asBoolean () {
        return this.booleanRecipient;
    }

    private class NetworkOutputDataRecipient implements DataRecipient {
        private final ITable table;
        private final boolean asBoolean;

        private NetworkOutputDataRecipient (ITable table, boolean asBoolean) {
            this.table = table;
            this.asBoolean = asBoolean;
        }

        @Override
        public void sendData (String fieldName, double dataValue) {
            if (this.asBoolean) {
                this.table.putBoolean(fieldName, dataValue > 0);
            } else {
                this.table.putNumber(fieldName, dataValue);
            }
        }
    }
}