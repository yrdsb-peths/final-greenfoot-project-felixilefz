import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math.*;

/**
 * Level Tweleve Layout
 * 
 * @author Felix Zhao
 * @version 1/18/2023
 */
public class LevelTwelve extends GameWorld
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
    
    public LevelTwelve()
    {
        super(floorPlan, blockPlan, 12);
    }
    
    public int getOwnerTime() {
        return 12000;
    }
    
    public int getOwnerMoves() {
        return 15;
    }
}
