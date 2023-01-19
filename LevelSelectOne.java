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
    public LevelSelectOne()
    {
        super(12, 0);
    }
    
    // Getters
    public Integer getPrev() {
        return null;
    }
    
    public Integer getNext() {
        return -3;
    }
}
