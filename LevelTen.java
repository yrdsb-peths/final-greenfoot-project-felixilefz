import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math.*;

/**
 * Write a description of class LevelFive here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelTen extends GameWorld
{
    // The dimensions of the level. Not including outer walls
    private static String wallVertical = "images/tiles/walls/wall_vertical.png";
    private static TileObject[][] floorPlan = {
        {null, null, null, null, null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null, null, null, null, null}
    };
    private static TileObject[][] blockPlan = {
        {new Player(), null, null, new StrongWall(), new Finish(), new Wall(), null, null, null, null, null},
        {null, null, null, new StrongWall(), null, new StrongWall(), null, null, null, null, null},
        {null, null, null, new StrongWall(), new Dynamite(), new StrongWall(), null, null, null, null, null},
        {null, new Dynamite(), null, null, null, new StrongDoor(), new Key(), null, new Key(), null, new StrongDoor()},
        {null, null, null, new StrongWall(), null, new StrongWall(), null, null, null, new Wall(), new StrongDoor()},
        {null, null, null, new StrongWall(), null, new StrongWall(), null, null, null, new Wall(), new StrongDoor()},
        {null, null, null, null, null, new StrongWall(), null, null, null, new Wall(), new Finish()}
    };
    
    public LevelTen()
    {
        super(floorPlan, blockPlan, 10);
    }
    
    public int getOwnerTime() {
        return 16000;
    }
    
    public int getOwnerMoves() {
        return 46;
    }
}
