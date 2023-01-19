import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math.*;

/**
 * Level Thirteen Layout
 * 
 * @author Felix Zhao
 * @version 1/18/2023
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
    
    /**
     * Gives the layout and level to the superclass so the world can be made
     */
    public LevelThirteen()
    {
        super(floorPlan, blockPlan, 13);
    }
    
    /**
     * Roughly the amount of time I took to beat this level
     */
    public int getOwnerTime() {
        return 15000;
    }
    
    /**
     * Roughly the moves I took to beat this level
     */
    public int getOwnerMoves() {
        return 23;
    }
}
