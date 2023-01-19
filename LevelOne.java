import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math.*;

/**
 * Level Ten Layout
 * 
 * @author Felix Zhao
 * @version 1/18/2023
 */
public class LevelOne extends GameWorld
{
    // The dimensions of the level. Not including outer walls
    private static String wallVertical = "images/tiles/walls/wall_vertical.png";
    private static TileObject[][] floorPlan = {
        {null, null, null, null, null},
        {null, null, null, null, null},
        {null, null, null, null, null},
        {null, null, null, null, null}
    };
    private static TileObject[][] blockPlan = {
        {null, null, new Player(), null, null},
        {null, new Wall(), new Wall(), new Wall(), null},
        {null, new PushBlock(), null, new PushBlock(), null},
        {new Wall(), null, new Finish(), null, new Wall()},    
    };
    
    public LevelOne()
    {
        super(floorPlan, blockPlan, 1);
    }
    
    // Getters
    
    // These are to calculate the grade you get after you finish the level
    // These are based on my times
    public int getOwnerTime() {
        return 2500;
    }
    
    public int getOwnerMoves() {
        return 7;
    }
}
