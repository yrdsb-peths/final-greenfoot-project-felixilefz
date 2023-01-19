import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math.*;

/**
 * Level Fourteen Layout
 * 
 * @author Felix Zhao
 * @version 1/18/2023
 */
public class LevelFourteen extends GameWorld
{
    // The dimensions of the level. Not including outer walls
    private static String wallVertical = "images/tiles/walls/wall_vertical.png";
    private static TileObject[][] floorPlan = {
        {new Water(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice()},
        {new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice()},
        {new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice()},
        {new Ice(), new Ice(), new Ice(), new Water(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice()},
        {new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice()},
        {new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice()},
        {new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice()},
    };
    private static TileObject[][] blockPlan = {
        {null, null, null, null, null, new PushBlock(), null, null, null, null, new Wall()},
        {new Player(), new Wall(), null, new Key(), null, null, null, new Wall(), null, null, new Wall()},
        {null, null, null, null, null, new Door(), null, null, null, null, new Wall()},
        {null, new PushBlock(), null, null, new Wall(), new Finish(), new Wall(), null, null, null, new Wall()},
        {null, null, new Wall(), null, null, new Wall(), new Wall(), null, null, null, null},
        {new PushBlock(), null, null, null, null, null, null, null, null, null, null},
        {null, null, null, new Wall(), null, new Wall(), null, null, new PushBlock(), null, null}
    };
    
    /**
     * Gives the layout and level to the superclass so the world can be made
     */
    public LevelFourteen()
    {
        super(floorPlan, blockPlan, 14);
    }
    
    /**
     * Roughly the amount of time I took to beat this level
     */
    public int getOwnerTime() {
        return 30000;
    }
    
    /**
     * Roughly the moves I took to beat this level
     */
    public int getOwnerMoves() {
        return 51;
    }
}
