import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math.*;

/**
 * Level Three Layout
 * 
 * @author Felix Zhao
 * @version 1/18/2023
 */
public class LevelThree extends GameWorld
{
    // The dimensions of the level. Not including outer walls
    private static String wallVertical = "images/tiles/walls/wall_vertical.png";
    private static TileObject[][] floorPlan = {
        {null, null, null, null, null, null},
        {null, null, null, null, null, null},
        {null, null, null, null, null, null},
        {null, null, null, null, null, null}
    };
    private static TileObject[][] blockPlan = {
        {new Player(), null, null, new Door(), new Wall(), new Finish()},
        {null, new Key(), null, new Door(), new Wall(), null},
        {null, new Bomb(), null, new Door(), new Wall(), null},
        {null, null, null, new Door(), new Wall(), null}
    };
    
    public LevelThree()
    {
        super(floorPlan, blockPlan, 3);
    }
    
    public int getOwnerTime() {
        return 5000;
    }
    
    public int getOwnerMoves() {
        return 15;
    }
}
