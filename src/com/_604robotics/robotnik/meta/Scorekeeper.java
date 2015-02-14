package com._604robotics.robotnik.meta;

// TODO: Auto-generated Javadoc
/**
 * The Class Scorekeeper.
 */
public class Scorekeeper {
    
    /** The victor. */
    public Object victor = null;
    
    /** The count. */
    public int count = 0;
    
    /** The base. */
    private final double base;
    
    /** The score. */
    public double score;
    
    /**
     * Instantiates a new scorekeeper.
     *
     * @param base the base
     */
    public Scorekeeper (double base) {
        this.base = this.score = base;
    }
    
    /**
     * Consider.
     *
     * @param item the item
     * @param score the score
     */
    public void consider (Object item, double score) {
        if (this.victor == null || score > this.score) {
            this.victor = item;
            this.score = score;
        }
        
        this.count++;
    }
    
    /**
     * Reset.
     */
    public void reset () {
        this.victor = null;
        this.count = 0;
        
        this.score = this.base;
    }
}
