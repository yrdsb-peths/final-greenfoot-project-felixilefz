import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math.*;

/**
 * Level Two Layout
 * 
 * @author Felix Zhao
 * @version 1/18/2023
 */
public class LevelTwo extends GameWorld
{
    // The dimensions of the level. Not including outer walls
    private static String wallVertical = "images/tiles/walls/wall_vertical.png";
    private static TileObject[][] floorPlan = {
        {null, null, null, new Water(), new Water(), null},
        {null, null, null, new Water(), new Water(), null},
        {null, null, null, new Water(), new Water(), null},
        {null, null, null, new Water(), new Water(), null}
    };
    private static TileObject[][] blockPlan = {
        {new Player(), null, null, null, null, null},
        {null, null, new PushBlock(), null, null, null},
        {null, null, new PushBlock(), null, null, null},
        {null, null, null, null, null, new Finish()}
    };
    
    /**
     * Gives the layout and level to the superclass so the world can be made
     */
    public LevelTwo()
    {
        super(floorPlan, blockPlan, 2);
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
        return 16;
    }
}
