package com._604robotics.robotnik.data.sources;

import com._604robotics.robotnik.data.Data;
import java.util.StringTokenizer;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.tables.ITable;

// TODO: Auto-generated Javadoc
/**
 * The Class NetworkData.
 */
public class NetworkData extends Data {
    
    /** The table. */
    private final ITable table;
    
    /** The key. */
    private final String key;
    
    /** The default value. */
    private final double defaultValue;
    
    /**
     * Instantiates a new network data.
     *
     * @param namespace the namespace
     * @param key the key
     * @param defaultValue the default value
     */
    public NetworkData (String namespace, String key, double defaultValue) {
        this.key = key;
        this.defaultValue = defaultValue;

        final StringTokenizer tokens = new StringTokenizer(namespace, ".");
        
        ITable workingTable = NetworkTable.getTable(tokens.nextToken());
        while (tokens.hasMoreTokens()) workingTable = workingTable.getSubTable(tokens.nextToken());
        
        this.table = workingTable;
    }

    /* (non-Javadoc)
     * @see com._604robotics.robotnik.data.Data#run()
     */
    public double run () {
        return this.table.getNumber(this.key, this.defaultValue);
    }
}