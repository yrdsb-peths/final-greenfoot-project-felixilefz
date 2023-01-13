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
        {new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice()},
        {new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice()},
        {new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice()},
        {new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice()},
        {new Ice(), new Ice(), new Ice(), new Water(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice()},
        {new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice()},
    };
    private static TileObject[][] blockPlan = {
        {new Player(), new Water(), new Wall(), null, null, null, null, null, new Wall()},
        {null, null, null, null, null, null, null, null, null},
        {null, new PushBlock(), null, null, null, new Wall(), null, null, null},
        {new PushBlock(), null, null, null, null, null, null, null, null},
        {null, null, null, null, new Finish(), new Wall(), null, null, null},
        {null, new Wall(), null, null, null, null, null, null, new Wall()}
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
