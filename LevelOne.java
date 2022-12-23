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
    private static String[][] floorPlan = {
        {"", "", ""},
        {"", "", ""},
        {"", "", ""},
        {"", "", ""}
    };
    private static String[][] blockPlan = {
        {"", "", ""},
        {"", "PushBlock", ""},
        {"", "", ""},
        {"", "", ""}
    };
    
    public LevelOne()
    {
        super(spawnLocationX, spawnLocationY, floorPlan, blockPlan);
        
        addObject(new PushBlock(new GreenfootImage("images/tiles/interactables/push_block.png"), scale, 2, 2), 0, 0);
        
    }
}
