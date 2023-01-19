import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math.*;

/**
 * Level One Layout
 * 
 * @author Felix Zhao
 * @version 1/18/2023
 */
public class LevelOne extends GameWorld
{
    private static TileObject[][] floorPlan = {
        {null, null, null, null, null},
        {null, null, null, null, null},
        {null, null, null, null, null},
        {null, null, null, null, null}
    };
    private static TileObject[][] blockPlan = {
        {null, null, new Player(), null, null},
        {null, new Wall(), new Wall(), new Wall(), null},
        {null, new PushBlock(), null, new PushBlock(), null},
        {new Wall(), null, new Finish(), null, new Wall()},    
    };
    
    /**
     * Gives the layout and level to the superclass so the world can be made
     */
    public LevelOne()
    {
        super(floorPlan, blockPlan, 1);
    }
    
    /**
     * Roughly the amount of time I took to beat this level
     */
    public int getOwnerTime() {
        return 2500;
    }
    
    /**
     * Roughly the moves I took to beat this level
     */
    public int getOwnerMoves() {
        return 7;
    }
}
