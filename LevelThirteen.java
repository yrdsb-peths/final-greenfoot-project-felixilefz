import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math.*;

/**
 * Write a description of class LevelFive here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelThirteen extends GameWorld
{
    // The dimensions of the level. Not including outer walls
    private static String wallVertical = "images/tiles/walls/wall_vertical.png";
    private static TileObject[][] floorPlan = {
        {null, null, null, null, null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null, null, null, null, null}
    };
    private static TileObject[][] blockPlan = {
        {new Wall(), new Dynamite(), null, new Dynamite(), new Dynamite(), new Wall(), new Wall(), new Dynamite(), new Wall(), null, null},
        {new Dynamite(), new Wall(), new Dynamite(), new Wall(), new Wall(), new Dynamite(), new Wall(), new Dynamite(), new Wall(), new Wall(), new Wall()},
        {null, new Dynamite(), new Player(), new Dynamite(), new Wall(), new Wall(), new Wall(), new Dynamite(), new Wall(), new Wall(), new Wall()},
        {new Dynamite(), new Wall(), null, null, null, new Wall(), new Wall(), new Dynamite(), new Wall(), new Wall(), new Finish()},
        {new Dynamite(), new Wall(), new Dynamite(), new Wall(), new Dynamite(), new Wall(), new Wall(), new Dynamite(), new Wall(), new Wall(), new Wall()},
        {new Dynamite(), new Wall(), null, new Wall(), null, null, new Wall(), new Dynamite(), new Bomb(), new Wall(), new Wall()},
        {null, new Dynamite(), null, new Dynamite(), new Dynamite(), new Dynamite(), new Dynamite(), new Wall(), new Wall(), null, null}
    };
    
    public LevelThirteen()
    {
        super(floorPlan, blockPlan, 13);
    }
    
    public int getOwnerTime() {
        return 15000;
    }
    
    public int getOwnerMoves() {
        return 23;
    }
}
