package com._604robotics.robotnik.trigger.sources;

import com._604robotics.robotnik.trigger.Trigger;
import java.util.StringTokenizer;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.tables.ITable;

// TODO: Auto-generated Javadoc
/**
 * The Class NetworkTrigger.
 */
public class NetworkTrigger extends Trigger {
    
    /** The table. */
    private final ITable table;
    
    /** The key. */
    private final String key;
    
    /** The default value. */
    private final boolean defaultValue;
    
    /**
     * Instantiates a new network trigger.
     *
     * @param namespace the namespace
     * @param key the key
     * @param defaultValue the default value
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

    /* (non-Javadoc)
     * @see com._604robotics.robotnik.trigger.Trigger#run()
     */
    public boolean run () {
        return this.table.getBoolean(this.key, this.defaultValue);
    }
}