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
    private static int width = 3; 
    private static int height = 3;
    private static int spawnLocationX = 1;
    private static int spawnLocationY = 1;
    
    public LevelOne()
    {
        super(width, height, spawnLocationX, spawnLocationY);
        
        addObject(new PushBlock(new GreenfootImage("images/tiles/interactables/push_block.png"), scale, 2, 2), 0, 0);
        
    }
}
