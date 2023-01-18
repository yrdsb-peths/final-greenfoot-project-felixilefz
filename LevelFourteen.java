import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math.*;

/**
 * Write a description of class LevelFive here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
    
    public LevelFourteen()
    {
        super(floorPlan, blockPlan, 14);
    }
    
    public int getOwnerTime() {
        return 30000;
    }
    
    public int getOwnerMoves() {
        return 51;
    }
}