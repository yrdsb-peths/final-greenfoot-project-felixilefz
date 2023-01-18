import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math.*;

/**
 * Write a description of class LevelFour here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelTen extends GameWorld
{
    // The dimensions of the level. Not including outer walls
    private static String wallVertical = "images/tiles/walls/wall_vertical.png";
    private static TileObject[][] floorPlan = {
        {new Ice(), new Water(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice()},
        {new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice()},
        {new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice()},
        {new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice()},
        {new Ice(), new Ice(), new Ice(), new Water(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice()},
        {new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice()},
    };
    private static TileObject[][] blockPlan = {
        {new Player(), null, new Wall(), null, new Wall(), null, null, null, new Wall()},
        {null, null, null, null, null, null, null, null, null},
        {null, new PushBlock(), null, null, null, new Wall(), null, null, null},
        {new PushBlock(), null, null, null, null, null, null, null, null},
        {null, null, null, null, new Finish(), new Wall(), null, null, null},
        {null, new Wall(), null, null, null, null, null, null, new Wall()}
    };
    
    public LevelTen()
    {
        super(floorPlan, blockPlan, 10);
        
        
        
    }
    
    public int getOwnerTime() {
        return 12000;
    }
    
    public int getOwnerMoves() {
        return 15;
    }
}