import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Sets the item that will be placed in the custom level creator world
 * 
 * @author Felix Zhao
 * @version 1/19/2023
 */
public class SelectItemButton extends Button
{
    private String item;
    /**
     * Creats the button's looks and sets the item that it is related to
     */
    public SelectItemButton(String image, String item, int scale) {
        super(image, 1);
        this.item = item;
        getImage().scale(scale, scale);
    }
    
    /**
     * Sets the item to be placed in the custom level world
     */
    public void action()
    {
        LevelCreator world = (LevelCreator) getWorld();
        world.setItem(item);
    }
}
