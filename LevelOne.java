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
        {null, null, null, null, new Water(), null},
        {null, null, null, null, null, null},
    };
    private static TileObject[][] blockPlan = {
        {new Player(), null, null, null, null, null},
        {null, null, null, null, new PushBlock(), new PushBlock()},
        {null, null, null, new Wall(), null, null},
        {null, null, null, new Wall(wallVertical), null, new Finish()},
    };
    
    public LevelOne()
    {
        super(floorPlan, blockPlan);
        
        
        
    }
}
