package com._604robotics.robotnik.data.sources;

import java.util.StringTokenizer;

import com._604robotics.robotnik.data.Data;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.tables.ITable;

/**
 * Data from a network table.
 */
public class NetworkData implements Data {
    private final ITable table;
    private final String key;
    private final double defaultValue;
    
    /**
     * Creates network data.
     * @param namespace Namespace of the data.
     * @param key Key of the data.
     * @param defaultValue Default value of the data.
     */
    public NetworkData (String namespace, String key, double defaultValue) {
        this.key = key;
        this.defaultValue = defaultValue;

        final StringTokenizer tokens = new StringTokenizer(namespace, ".");
        
        ITable workingTable = NetworkTable.getTable(tokens.nextToken());
        while (tokens.hasMoreTokens()) workingTable = workingTable.getSubTable(tokens.nextToken());
        
        this.table = workingTable;
    }

    @Override
    public double run () {
        return this.table.getNumber(this.key, this.defaultValue);
    }
}