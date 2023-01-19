import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BackButton here.
 * 
 * @author Felix Zhao
 * @version (a version number or a date)
 */
public class BackButton extends Button
{
    public BackButton(String image, int numStates) {
        super(image, numStates);
    }
    
    public void action()
    {
        GameWorld world = (GameWorld) getWorld();
        world.removeMenuAssets();
    }
}
