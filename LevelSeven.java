import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math.*;

/**
 * Level Seven Layout
 * 
 * @author Felix Zhao
 * @version 1/18/2023
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
    
    /**
     * Gives the layout and level to the superclass so the world can be made
     */
    public LevelSeven()
    {
        super(floorPlan, blockPlan, 7);
    }
    
    /**
     * Roughly the amount of time I took to beat this level
     */
    public int getOwnerTime() {
        return 5000;
    }
    
    /**
     * Roughly the moves I took to beat this level
     */
    public int getOwnerMoves() {
        return 11;
    }
}
