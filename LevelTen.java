import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math.*;

/**
 * Write a description of class LevelFive here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelTen extends GameWorld
{
    // The dimensions of the level. Not including outer walls
    private static String wallVertical = "images/tiles/walls/wall_vertical.png";
    private static TileObject[][] floorPlan = {
        {null, null, null, new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice()},
        {null, null, null, new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice()},
        {null, null, null, new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice()},
        {null, null, null, new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice()},
        {null, null, null, new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice()},
        {null, null, null, new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice()},
        {null, null, null, new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice()}
    };
    private static TileObject[][] blockPlan = {
        {null, new Player(), null, new Wall(), null, null, null, null, null, null, null},
        {null, null, null,  new Wall(), null, null, null, null, null, null, null},
        {null, new Key(), null, null, new Wall(), new Door(), new Wall(), null, null, null, null},
        {null, new Bomb(), null, null, new Wall(), new Finish(), new Wall(), null, null, null, null},
        {null, new PushBlock(), null, null, null, new Wall(), new Wall(), null, null, null, null},
        {null, new PushBlock(), null, null, null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null, null, null, null, null}
    };
    
    public LevelTen()
    {
        super(floorPlan, blockPlan, 10);
    }
    
    public int getOwnerTime() {
        return 30000;
    }
    
    public int getOwnerMoves() {
        return 51;
    }
    
}
