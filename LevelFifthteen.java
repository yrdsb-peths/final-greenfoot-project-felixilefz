import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math.*;

/**
 * Level Fifthteen Layout
 * 
 * @author Felix Zhao
 * @version 1/18/2023
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
    
    /**
     * Gives the layout and level to the superclass so the world can be made
     */
    public LevelFifthteen()
    {
        super(floorPlan, blockPlan, 15);
    }
    
    /**
     * Roughly the amount of time I took to beat this level
     */
    public int getOwnerTime() {
        return 52000;
    }
    
    /**
     * Roughly the moves I took to beat this level
     */
    public int getOwnerMoves() {
        return 123;
    }
    
}
