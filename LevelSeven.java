import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math.*;

/**
 * Write a description of class LevelFour here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelSeven extends GameWorld
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
        {new Player(), null, new Wall(), new Dynamite(), new Dynamite(), new Finish()},
        {null, new Dynamite(), new Wall(), null, new Wall(), null},
        {null, null, new Wall(), new Dynamite(), new Wall(), null},
        {null, null, new Wall(), null, new Wall(), null},
    };
    
    public LevelSeven()
    {
        super(floorPlan, blockPlan, 7);
    }
    
    public int getOwnerTime() {
        return 5000;
    }
    
    public int getOwnerMoves() {
        return 11;
    }
}
