import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SelectItemButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SelectItemButton extends Button
{
    private String item;
    
    public SelectItemButton(String image, String item, int scale) {
        super(image, 1);
        this.item = item;
        getImage().scale(scale, scale);
    }
    
    /**
     * Deletes the menu on screen if there is one
     */
    public void action()
    {
        LevelCreator world = (LevelCreator) getWorld();
        world.setItem(item);
    }
}
