import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math.*;

/**
 * Write a description of class LevelFive here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelFifthteen extends GameWorld
{
    // The dimensions of the level. Not including outer StrongWalls
    private static String StrongWallVertical = "images/tiles/StrongWalls/StrongWall_vertical.png";
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
        {null, new Player(), new StrongWall(), null, null, null, null, null, null, null, null},
        {null, null,  new StrongWall(), null, null, null, null, null, null, null, null},
        {null, new Key(), null, new StrongWall(), new StrongDoor(), new StrongWall(), null, null, null, null, null},
        {null, new Bomb(), null, new StrongWall(), new Finish(), new StrongWall(), null, null, null, null, null},
        {null, new PushBlock(), null, null, new StrongWall(), new StrongWall(), null, null, null, null, null},
        {null, new PushBlock(), null, null, null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null, null, null, null, null}
    };
    
    public LevelFifthteen()
    {
        super(floorPlan, blockPlan, 15);
    }
    
    public int getOwnerTime() {
        return 52000;
    }
    
    public int getOwnerMoves() {
        return 123;
    }
    
}
