import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math.*;

/**
 * Level Two Layout
 * 
 * @author Felix Zhao
 * @version 1/18/2023
 */
public class LevelTwo extends GameWorld
{
    // The dimensions of the level. Not including outer walls
    private static String wallVertical = "images/tiles/walls/wall_vertical.png";
    private static TileObject[][] floorPlan = {
        {null, null, null, new Water(), new Water(), null},
        {null, null, null, new Water(), new Water(), null},
        {null, null, null, new Water(), new Water(), null},
        {null, null, null, new Water(), new Water(), null}
    };
    private static TileObject[][] blockPlan = {
        {new Player(), null, null, null, null, null},
        {null, null, new PushBlock(), null, null, null},
        {null, null, new PushBlock(), null, null, null},
        {null, null, null, null, null, new Finish()}
    };
    
    public LevelTwo()
    {
        super(floorPlan, blockPlan, 2);
    }
    
    public int getOwnerTime() {
        return 5000;
    }
    
    public int getOwnerMoves() {
        return 16;
    }
}
