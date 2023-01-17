import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math.*;

/**
 * Write a description of class LevelSix here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelSix extends GameWorld
{
    // The dimensions of the level. Not including outer walls
    private static String wallVertical = "images/tiles/walls/wall_vertical.png";
    private static TileObject[][] floorPlan = {
        {null, null, null, null, null, new Water(), null},
        {null, null, null, null, null, new Water(), null},
        {null, null, null, null, null, new Water(), null},
        {null, null, null, null, null, new Water(), null},
        {null, null, null, null, null, new Water(), null},
    };
    private static TileObject[][] blockPlan = {
        {null, null, null, new Wall(), new Wall(), null, null},
        {null, null, new Dynamite(), new Wall(), new Wall(), null, null},
        {new Player(), null, null, new Wall(), new Wall(), null, new Finish()},
        {null, null, new Bomb(), new Wall(), new Wall(), null, null},
        {null, null, null, new Wall(), new Wall(), null, null}
    };
    
    public LevelSix()
    {
        super(floorPlan, blockPlan, 6);
    }
    
    // Getters
    
    // These are to calculate the grade you get after you finish the level
    // These are based on my times
    public int getOwnerTime() {
        return 6000;
    }
    
    public int getOwnerMoves() {
        return 16;
    }
}
