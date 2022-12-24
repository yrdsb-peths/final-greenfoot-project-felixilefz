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
    private static int width = 3; // Useless
    private static int height = 3; // Useless
    private static int spawnLocationX = 1;
    private static int spawnLocationY = 1;
    private static TileObject[][] floorPlan = {
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null}
    };
    private static TileObject[][] blockPlan = {
        {new Player(), null, new Wall(), null},
        {null, new PushBlock(), new PushBlock(), null},
        {null, null, null, null},
        {null, null, null, null}
    };
    
    public LevelOne()
    {
        super(floorPlan, blockPlan);
        
        
        
    }
}
