import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math.*;

/**
 * Level Five Layout
 * 
 * @author Felix Zhao
 * @version 1/18/2023
 */
public class LevelFive extends GameWorld
{
    // The dimensions of the level. Not including outer walls
    private static String wallVertical = "images/tiles/walls/wall_vertical.png";
    private static TileObject[][] floorPlan = {
        {null, null, null, null, null, null, null, null},
        {null, null, null, new Ice(), new Ice(), new Ice(), new Ice(), new Water()},
        {null, null, null, null, new Ice(), null, null, null},
        {null, null, null, new Ice(), new Ice(), new Ice(), new Ice(), new Water()},
        {null, null, null, null, null, null, null, null}
    };
    private static TileObject[][] blockPlan = {
        {null, null, null, new Wall(), new Wall(), new Wall(), new Finish(), new Wall()},
        {null, null, new PushBlock(), null, null, null, null, null},
        {new Player(), null, new Wall(), new Wall(), null, new Wall(), new Wall(), new Wall()},
        {null, null, new PushBlock(), null, null, null, null, null},
        {null, null, null, new Wall(), new Wall(), new Wall(), new Finish(), new Wall()}
    };
    
    /**
     * Gives the layout and level to the superclass so the world can be made
     */
    public LevelFive()
    {
        super(floorPlan, blockPlan, 5);
    }
    
    /**
     * Roughly the amount of time I took to beat this level
     */
    public int getOwnerTime() {
        return 8000;
    }
    
    /**
     * Roughly the moves I took to beat this level
     */
    public int getOwnerMoves() {
        return 21;
    }
}
