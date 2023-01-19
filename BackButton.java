import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Used to delete the menu when the user opens it
 * 
 * @author Felix Zhao
 * @version 1/18/2023
 */
public class BackButton extends Button
{
    public BackButton(String image, int numStates) {
        super(image, numStates);
    }
    
    /**
     * Deletes the menu on screen if there is one
     */
    public void action()
    {
        GameWorld world = (GameWorld) getWorld();
        world.removeMenuAssets();
    }
}
