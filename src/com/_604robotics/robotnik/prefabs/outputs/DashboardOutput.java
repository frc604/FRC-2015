package com._604robotics.robotnik.prefabs.outputs;

import com._604robotics.robotnik.data.DataRecipient;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * A data recipient outputting data on the smart dashboard.
 */
public class DashboardOutput {
    private static DoubleDashboardOutput doubleInstance = null;
    private static BooleanDashboardOutput booleanInstance = null;
    
    private DashboardOutput () {}
    
    /**
     * Gets an output for double data.
     * @return An output for double data.
     */
    public static DataRecipient asDouble () {
        if (doubleInstance == null) {
            doubleInstance = new DoubleDashboardOutput();
        }
        
        return doubleInstance;
    }
    
    /**
     * Gets an output for boolean data.
     * @return An output for boolean data.
     */
    public static DataRecipient asBoolean () {
        if (booleanInstance == null) {
            booleanInstance = new BooleanDashboardOutput();
        }
        
        return booleanInstance;
    }
    
    /**
     * Gets an output for boolean data, displaying certain text for false and true values.
     * @param falseText Text to display when the value is false.
     * @param trueText Text to display when the value is true.
     * @return An output for boolean data.
     */
    public static DataRecipient asBoolean (String falseText, String trueText) {
        return new FancyBooleanDashboardOutput(falseText, trueText);
    }
    
    private static class DoubleDashboardOutput implements DataRecipient {
        @Override
        public void sendData (String fieldName, double dataValue) {
            SmartDashboard.putNumber(fieldName, dataValue);
        }
    }

    private static class BooleanDashboardOutput implements DataRecipient {
        @Override
        public void sendData (String fieldName, double dataValue) {
            SmartDashboard.putBoolean(fieldName, dataValue > 0);
        }
    }

    private static class FancyBooleanDashboardOutput implements DataRecipient {
        private final String falseText;
        private final String trueText;
        
        private FancyBooleanDashboardOutput (String falseText, String trueText) {
            this.falseText = falseText;
            this.trueText = trueText;
        }

        @Override
        public void sendData (String fieldName, double dataValue) {
            SmartDashboard.putString(fieldName, dataValue > 0 ? this.trueText : this.falseText);
        }
    }
}
