package com._604robotics.robotnik.trigger.sources;

import com._604robotics.robotnik.trigger.Trigger;
import java.util.StringTokenizer;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.tables.ITable;

/**
 * A trigger from the network.
 */
public class NetworkTrigger implements Trigger {
    private final ITable table;
    private final String key;
    private final boolean defaultValue;

    /**
     * Creates a network trigger.
     * @param namespace Namespace of the trigger.
     * @param key Key of the trigger.
     * @param defaultValue Default value of the trigger.
     */
    public NetworkTrigger (String namespace, String key, boolean defaultValue) {
        this.key = key;
        this.defaultValue = defaultValue;

        final StringTokenizer tokens = new StringTokenizer(namespace, ".");
        
        ITable workingTable = NetworkTable.getTable(tokens.nextToken());
        
        while (tokens.hasMoreTokens()) {
            workingTable = workingTable.getSubTable(tokens.nextToken());
        }
        
        this.table = workingTable;
    }

    @Override
    public boolean run () {
        return this.table.getBoolean(this.key, this.defaultValue);
    }
}