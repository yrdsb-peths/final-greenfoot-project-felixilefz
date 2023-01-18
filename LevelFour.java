import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math.*;

/**
 * Write a description of class LevelFour here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
        {null, null, null, new Wall(), new Finish(), new Wall(), null, null, null},
        {null, null, null, null, null, null, null, new PushBlock(), null},
        {new Player(), null, null, new Wall(), null, new Wall(), null, null, null},
        {null, null, null, new Wall(), null, new Wall(), null, null, null},
        {null, new Key(), null, null, null, null, null, new Bomb(), null},
        {null, null, null, new Wall(), new Finish(), new Wall(), null, null, null}
    };
    
    public LevelFour()
    {
        super(floorPlan, blockPlan, 4);
        
        
        
    }
    
    public int getOwnerTime() {
        return 5000;
    }
    
    public int getOwnerMoves() {
        return 13;
    }
}
