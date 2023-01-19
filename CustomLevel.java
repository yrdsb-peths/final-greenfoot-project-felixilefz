import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class customLevel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CustomLevel extends GameWorld
{
    private static TileObject[][] floorPlan = {
        {null, null, null, null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null, null, null, null}
    };
    private static TileObject[][] blockPlan = {
        {null, null, null, null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null, null, null, null}  
    };
    
    public CustomLevel()
    {
        super(floorPlan, blockPlan, 0);
    }
    
    public static TileObject[][] getBlockPlan() {
        return blockPlan;
    }
    
    public static TileObject[][] getFloorPlan() {
        return floorPlan;
    }
    
    public static void setBlock(int i, int j, TileObject tile) {
        blockPlan[i][j] = tile;
    }
    
    public static void setFloor(int i, int j, TileObject tile) {
        floorPlan[i][j] = tile;
    }
}
