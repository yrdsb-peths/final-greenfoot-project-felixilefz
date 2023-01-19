import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math.*;

/**
 * Write a description of class LevelFive here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
    
    public LevelSixteen()
    {
        super(floorPlan, blockPlan, 16);
        addObject(new Label("A just for fun level :)", 60), getWidth()/2, getHeight()/2);
    }
    
    public int getOwnerTime() {
        return 6000;
    }
    
    public int getOwnerMoves() {
        return 20;
    }
    
}
