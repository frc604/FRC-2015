package com._604robotics.robotnik.prefabs.outputs;

import com._604robotics.robotnik.data.DataRecipient;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// TODO: Auto-generated Javadoc
/**
 * The Class DashboardOutput.
 */
public class DashboardOutput implements DataRecipient {
    
    /** The double instance. */
    private static DashboardOutput doubleInstance = null;
    
    /** The boolean instance. */
    private static DashboardOutput booleanInstance = null;
    
    /** The as boolean. */
    private final boolean asBoolean;
    
    /**
     * As double.
     *
     * @return the dashboard output
     */
    public static DashboardOutput asDouble () {
        if (doubleInstance == null) {
            doubleInstance = new DashboardOutput(false);
        }
        
        return doubleInstance;
    }
    
    /**
     * As boolean.
     *
     * @return the dashboard output
     */
    public static DashboardOutput asBoolean () {
        if (booleanInstance == null) {
            booleanInstance = new DashboardOutput(true);
        }
        
        return booleanInstance;
    }
    
    /**
     * Instantiates a new dashboard output.
     *
     * @param asBoolean the as boolean
     */
    private DashboardOutput (boolean asBoolean) {
        this.asBoolean = asBoolean;
    }
    
    /* (non-Javadoc)
     * @see com._604robotics.robotnik.data.DataRecipient#sendData(java.lang.String, double)
     */
    public void sendData (String fieldName, double dataValue) {
        if (this.asBoolean) {
            SmartDashboard.putBoolean(fieldName, dataValue > 0);
        } else {
            SmartDashboard.putNumber(fieldName, dataValue);
        }
    }
}
