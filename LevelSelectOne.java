import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Select Screen One
 * Has levels from 1-12
 * 
 * @author Felix Zhao
 * @version 1/18/2023
 */
public class LevelSelectOne extends LevelSelect
{
    /**
     * Gives how many levels there will be to the superclass
     *Gives how many levels there were before it (offset)
     */
    public LevelSelectOne()
    {
        super(12, 0);
    }
    
    // Getters
    /**
     * @return the previous selection world if there is one
     */
    public String getPrev() {
        return null;
    }
    
    /**
     * @return the next selection world if there is one
     */
    public String getNext() {
        return "select2";
    }
}
