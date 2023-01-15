import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math.*;

/**
 * Write a description of class LevelFive here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelSix extends GameWorld
{
    // The dimensions of the level. Not including outer walls
    private static String wallVertical = "images/tiles/walls/wall_vertical.png";
    private static TileObject[][] floorPlan = {
        {null, null, null, null, null, null},
        {null, null, null, null, null, null},
        {null, null, null, null, null, null},
        {null, null, null, null, null, null}
    };
    private static TileObject[][] blockPlan = {
        {new Player(), null, null, null, null, null},
        {null, new PushBlock(), new Dynamite(), new Wall(), new Wall(), null},
        {null, null, new Dynamite(), new Wall(), new Wall(), null},
        {null, null, null, null, null, null}
    };
    
    public LevelSix()
    {
        super(floorPlan, blockPlan, 6);
    }
    
    public int getOwnerTime() {
        return 15000;
    }
    
    public int getOwnerMoves() {
        return 15;
    }
}
