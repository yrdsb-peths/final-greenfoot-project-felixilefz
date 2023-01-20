import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Used to delete the menu when the user opens it
 * 
 * @author Felix Zhao
 * @version 1/18/2023
 */
public class BackButton extends Button
{
    /**
     * Creates the looks of the button
     * @param image the image of the button
     * @param numStates the number of states the image is supposed to have
     */
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
