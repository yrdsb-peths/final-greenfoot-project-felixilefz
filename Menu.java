import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Allows multiple items to be listed in a list
 * Automactially scales the item to be a percentage of the menu's width
 * 
 * @author Felix Zhao
 * @version 1/18/2023
 */

public class Menu extends Actor
{
    private int itemOffSet;
    public Menu(int width, int height) {
        GreenfootImage image = new GreenfootImage("images/ui/menu/menu_background.png");
        image.scale(width, height);
        setImage(image);
        itemOffSet = 25;
    }
    
    /**
     * Adds an item to the menu
     * 
     * @param actor gets the actor to put on the list
     * @param scale the percent of the width the actor should be relative to the menu. Does not scale if scale is under 0 
     */
    public void addItem(Actor actor, double scale) {
        World world = getWorld();
        
        GreenfootImage actorImage = actor.getImage();
        
        if (scale > 0) {
            int newWidth = (int) (getImage().getWidth()*scale);
            int newHeight = (int) (getImage().getWidth()*scale / actorImage.getWidth() * actorImage.getHeight()); 
            actorImage.scale(newWidth, newHeight);
            actorImage.scale(newWidth, newHeight);
            if (actor instanceof Button) {
                ((Button) actor).setScale(newWidth, newHeight);
            }
        }
        
        
        
        
        world.addObject(actor, getX(), getY() - getImage().getHeight()/2 + itemOffSet);
        itemOffSet += actor.getImage().getHeight() + 5;
    }
}
