import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math.*;

/**
 * Write a description of class LevelOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelOne extends GameWorld
{
    // The dimensions of the level. Not including outer walls
    private static String wallVertical = "images/tiles/walls/wall_vertical.png";
    private static TileObject[][] floorPlan = {
        {null, null, null, null, null, null},
        {null, null, null, null, null, null},
        {null, null, null, null, null, null},
        {null, null, null, null, null, null},
    };
    private static TileObject[][] blockPlan = {
        {null, null, new Player(), null, null},
        {null, new Wall(), new Wall(), new Wall(), null},
        {null, new PushBlock(), null, new PushBlock(), null},
        {new Wall(), null, new Finish(), null, new Wall()},    
    };
    
    public LevelOne()
    {
        super(floorPlan, blockPlan);
        
        
        
    }
}
