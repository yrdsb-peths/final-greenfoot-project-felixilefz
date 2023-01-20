import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The custom level layout the user can make
 * 
 * @author Felix Zhao
 * @version 1/19/2023
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
    
    /**
     * Gives the level and layout
     */
    public CustomLevel()
    {
        super(floorPlan, blockPlan, -1);
    }
    
    /**
     * @return the blockPlan
     */
    public static TileObject[][] getBlockPlan() {
        return blockPlan;
    }
    
    /**
     * @return the floorPlan
     */
    public static TileObject[][] getFloorPlan() {
        return floorPlan;
    }
    
    /**
     * Sets the blockPlan at i, j to the given tile
     */
    public static void setBlock(int i, int j, TileObject tile) {
        blockPlan[i][j] = tile;
    }
    
    /**
     * Sets the floorPlan at i, j to the given tile
     */
    public static void setFloor(int i, int j, TileObject tile) {
        floorPlan[i][j] = tile;
    }
}
