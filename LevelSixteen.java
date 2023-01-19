import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math.*;

/**
 * The layout for level sixteen
 * 
 * @author Felix Zhao
 * @version 1/18/2023
 */
public class LevelSixteen extends GameWorld
{
    // The dimensions of the level. Not including outer StrongWalls
    
    private static TileObject[][] floorPlan = {
        {new Wall(), new Wall(), new Wall(), new Wall(), new Wall(), new Wall(), new Wall(), new Wall(), new Wall(), new Wall(), new Wall(), new Wall()},
        {new Wall(), new Wall(), new Wall(), new Wall(), new Wall(), new Wall(), new Wall(), new Wall(), new Wall(), new Wall(), new Wall(), new Wall()},
        {new Wall(), new Wall(), new Wall(), new Wall(), new Wall(), new Wall(), new Wall(), new Wall(), new Wall(), new Wall(), new Wall(), new Wall()},
        {new Wall(), new Wall(), new Wall(), new Wall(), new Wall(), new Wall(), new Wall(), new Wall(), new Wall(), new Wall(), new Wall(), new Wall()},
        {new Wall(), new Wall(), new Wall(), new Wall(), new Wall(), new Wall(), new Wall(), new Wall(), new Wall(), new Wall(), new Wall(), new Wall()},
        {new Wall(), new Wall(), new Wall(), new Wall(), new Wall(), new Wall(), new Wall(), new Wall(), new Wall(), new Wall(), new Wall(), new Wall()},
        {new Wall(), new Wall(), new Wall(), new Wall(), new Wall(), new Wall(), new Wall(), new Wall(), new Wall(), new Wall(), new Wall(), new Wall()},
        {new Wall(), new Wall(), new Wall(), new Wall(), new Wall(), new Wall(), new Wall(), new Wall(), new Wall(), new Wall(), new Wall(), new Wall()}
    };
    private static TileObject[][] blockPlan = {
        {new Player(), null, null, null, null, null, null, null, null, null, null, null},
        {null, new Wall(), new Wall(), new Wall(), new Wall(), new Wall(), new Wall(), new Wall(), null, new Wall(), new Wall(), new Wall()},
        {null, new Wall(), null, null, null, null, new Wall(), null, null, new Wall(), null, null},
        {null, null, null, new Wall(), new Wall(), new Wall(), new Wall(), new Wall(), null, null, null, null},
        {null, new Wall(), new Wall(), null, null, null, null, new Wall(), new Wall(), new Wall(), new Wall(), new Wall()},
        {null, null, null, null, new Wall(), new Wall(), null, null, null, null, null, null},
        {null, new Wall(), new Wall(), new Wall(), null, new Wall(), new Wall(), new Wall(), new Wall(), new Wall(), new Wall(), null},
        {null, null, null, null, null, null, null, null, null, null, new Wall(), new Finish()}
    };
    
    /**
     * Gives the layout and level to the superclass so the world can be made
     */
    public LevelSixteen()
    {
        super(floorPlan, blockPlan, 16);
        addObject(new Label("A just for fun level :)", 60), getWidth()/2, getHeight()/2);
    }
    
    /**
     * Roughly the amount of time I took to beat this level
     */
    public int getOwnerTime() {
        return 6000;
    }
    
    /**
     * Roughly the moves I took to beat this level
     */
    public int getOwnerMoves() {
        return 20;
    }
    
}
