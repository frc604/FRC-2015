package com._604robotics.robotnik.data;

import com._604robotics.robotnik.Safety;
import com._604robotics.robotnik.memory.IndexedTable.Slice;

/**
 * A reference to data.
 */
public class DataReference implements DataAccess {
    private final Data data;
    private final Slice value;
    
    /**
     * Creates a data reference.
     * @param data Data to refer to.
     * @param value Slice to store the data value in.
     */
    public DataReference (Data data, Slice value) {
        this.data = data;
        this.value = value;
    }
    
    @Override
    public double get () {
        return value.getNumber(0D);
    }
    
    /**
     * Updates the value of data.
     * @param safety Safety mode to operate with.
     */
    public void update (Safety safety) {
        safety.wrap("updating data value", () -> value.putNumber(data.run()));
    }
}
