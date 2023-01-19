import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math.*;

/**
 * The layout for level eleven
 * 
 * @author Felix Zhao
 * @version 1/18/2023
 */
public class LevelEleven extends GameWorld
{
    // The dimensions of the level. Not including outer walls
    private static String wallVertical = "images/tiles/walls/wall_vertical.png";
    private static TileObject[][] floorPlan = {
        {null, null, null, null, null, new Ice(), null, null, null, null},
        {null, null, null, null, null, new Ice(), null, null, null, null},
        {null, null, null, null, null, new Ice(), null, null, null, null},
        {null, null, null, null, null, new Ice(), null, null, null, null},
        {null, null, null, null, null, new Ice(), null, null, null, null},
        {null, null, null, null, null, new Ice(), null, null, null, null},
        {null, null, null, null, null, new Ice(), null, null, null, null}
    };
    private static TileObject[][] blockPlan = {
        {new Player(), new StrongWall(), null, null, null, null, null, null, new StrongDoor(), new Finish()},
        {null, null, null, new StrongWall(), new Wall(), null, null, null, new StrongWall(), new StrongWall()},
        {null, new Dynamite(), null, null, new StrongWall(), null, null, null, null, null},
        {null, null, null, null, new StrongWall(), null, null, null, null, null},
        {null, new PushBlock(), null, null, new StrongWall(), null, null, null, null, null},
        {null, null, null, null, new StrongWall(), new Key(), null, new PushBlock(), null, null},
        {null, null, null, null, new StrongWall(), null, null, null, null, null}
    };
    
    public LevelEleven()
    {
        super(floorPlan, blockPlan, 11);
    }
    
    public int getOwnerTime() {
        return 12000;
    }
    
    public int getOwnerMoves() {
        return 36;
    }
}
