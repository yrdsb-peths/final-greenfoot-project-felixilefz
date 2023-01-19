import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Undos the previous move by the player when pressed
 * Only appears when the player dies
 * 
 * @author Felix Zhao
 * @version 1/18/2023
 */
public class UndoButton extends Button
{
    public UndoButton(String image, int numStates) {
        super(image, numStates);
    }
    
    /**
     * Undos the player's last move and removes menu assets if there is any
     */
    public void action()
    {
        GameWorld world = (GameWorld) getWorld();
        world.undoMove();
        world.removeMenuAssets();
    }
}
