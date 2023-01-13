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
        {null, null, null, new Ice(), new Ice(), new Water()},
        {null, null, null, null, new Water(), null},
        {null, null, null, null, null, null},
        {null, null, null, null, null, null}
    };
    private static TileObject[][] blockPlan = {
        {new Player(), null, null, null, null, null},
        {null, new PushBlock(), null, new Door(), null, null},
        {null, null, new Bomb(), new Bomb(), null, null},
        {null, null, null, null, null, new Finish()}
    };
    
    public LevelFour()
    {
        super(floorPlan, blockPlan, 4);
        
        
        
    }
}
