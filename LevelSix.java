import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math.*;

/**
 * Level Six Layout
 * 
 * @author Felix Zhao
 * @version 1/18/2023
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
    
    /**
     * Gives the layout and level to the superclass so the world can be made
     */
    public LevelSix()
    {
        super(floorPlan, blockPlan, 6);
    }
    
    /**
     * Roughly the amount of time I took to beat this level
     */
    public int getOwnerTime() {
        return 6000;
    }
    
    /**
     * Roughly the moves I took to beat this level
     */
    public int getOwnerMoves() {
        return 16;
    }
}
