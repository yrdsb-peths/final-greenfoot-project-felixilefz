import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math.*;

/**
 * Write a description of class LevelThree here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelEight extends GameWorld
{
    // The dimensions of the level. Not including outer walls
    private static String wallVertical = "images/tiles/walls/wall_vertical.png";
    private static TileObject[][] floorPlan = {
        {null, null, null, new Water(), null, null, null, null, null},
        {null, null, null, new Water(), null, new Water(), new Ice(), new Ice(), new Ice()},
        {null, null, null, new Water(), null, null, new Ice(), new Ice(), new Ice()},
        {null, null, null, new Water(), null, null, new Ice(), new Ice(), new Ice()},
        {null, null, null, new Water(), null, new Water(), new Ice(), new Ice(), new Ice()},
        {null, null, null, new Water(), null, null, null, null, null}
    };
    private static TileObject[][] blockPlan = {
        {new Player(), null, null, null, new Wall(), new Wall(), new Finish(), new Wall(), new Wall()},
        {null, new Key(), null, null,new Wall(), null, null, null, null},
        {null, new PushBlock(), null, null,new Door(), new Door(), null, null, null},
        {null, new Bomb(), null, null,new Door(), new Door(), null, null, null},
        {null, new Key(), null,null, new Wall(), null, null, null, null},
        {null, null, null, null, new Wall(), new Wall(), new Finish(), new Wall(), new Wall()}
    };
    
    public LevelEight()
    {
        super(floorPlan, blockPlan, 8);
    }
    
    public int getOwnerTime() {
        return 15000;
    }
    
    public int getOwnerMoves() {
        return 55;
    }
}
