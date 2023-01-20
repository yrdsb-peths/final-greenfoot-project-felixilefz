import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Level Select Two
 * Has levels 13-16
 * 
 * @author Felix Zhao
 * @version 1/18/2023
 */
public class LevelSelectTwo extends LevelSelect
{
    /**
     * Gives how many levels there will be to the super class
     * Gives how many levels there were before it (offset)
     */
    public LevelSelectTwo()
    {
        super(4, 12);
    }
    
    
    // Getters
    /**
     * @return the previous selection world if there is one
     */
    public String getPrev() {
        return "select1";
    }
    
    /**
     * @return the next selection world if there is one
     */
    public String getNext() {
        return null;
    }
}
