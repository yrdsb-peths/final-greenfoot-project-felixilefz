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
    public LevelSelectTwo()
    {
        super(4, 12);
    }
    
    
    // Getters
    
    public String getPrev() {
        return "select1";
    }
    
    public String getNext() {
        return null;
    }
}
