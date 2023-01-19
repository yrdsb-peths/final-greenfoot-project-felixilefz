import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math.*;

/**
 * Level Nine Layout
 * 
 * @author Felix Zhao
 * @version 1/18/2023
 */
public class LevelNine extends GameWorld
{
    
    private static TileObject[][] floorPlan = {
        {null, null, null, null, null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null, null, null, null, null},
        {null, null, new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Water(), null},
        {null, null, new Water(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), null},
        {null, null, new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), new Ice(), null},
        {null, null, null, null, null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null, null, null, null, null}
    };
    private static TileObject[][] blockPlan = {
        {new Player(), null, null, null, null, null, null, null, null, null, null},
        {null, null, null, null, new Dynamite(), null, null, null, null, new Wall(), new Wall()},
        {null, null, null, null, null, null, null, null, null, null, new Wall()},
        {null, new Wall(), null, null, new Key(), null, null, null, null, null, new Door()},
        {null, null, null, null, null, null, null, null, null, new Wall(), new Finish()},
        {null, null, null, null, null, null, null, null, null, new Wall(), new Wall()},
        {null, null, null, null, null, null, null, null, null, null, null}
    };
    
    public LevelNine()
    {
        super(floorPlan, blockPlan, 9);
    }
    
    public int getOwnerTime() {
        return 15000;
    }
    
    public int getOwnerMoves() {
        return 26;
    }
}
