import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math.*;

/**
 * Level Four Layout
 * 
 * @author Felix Zhao
 * @version 1/18/2023
 */
public class LevelFour extends GameWorld
{
    // The dimensions of the level. Not including outer walls
    private static String wallVertical = "images/tiles/walls/wall_vertical.png";
    private static TileObject[][] floorPlan = {
        {null, null, null, null, null, null, null, null, null},
        {null, null, null, new Ice(), new Ice(), new Ice(), null, null, null},
        {null, null, null, null, new Ice(), null, null, null, null},
        {null, null, null, null, new Ice(), null, null, null, null},
        {null, null, null, new Ice(), new Ice(), new Ice(), null, null, null},
        {null, null, null, null, null, null, null, null, null}
    };
    private static TileObject[][] blockPlan = {
        {null, null, null, new StrongWall(), new Finish(), new StrongWall(), null, null, null},
        {null, null, null, null, null, null, null, new PushBlock(), null},
        {new Player(), null, null, new Wall(), null, new Wall(), null, null, null},
        {null, null, null, new Wall(), null, new Wall(), null, null, null},
        {null, new Key(), null, null, null, null, null, new Bomb(), null},
        {null, null, null, new StrongWall(), new Finish(), new StrongWall(), null, null, null}
    };
    
    /**
     * Gives the layout and level to the superclass so the world can be made
     */
    public LevelFour()
    {
        super(floorPlan, blockPlan, 4);
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
        return 13;
    }
}
