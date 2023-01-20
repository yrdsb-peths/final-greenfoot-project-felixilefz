import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Where all the infomation and help is stored
 * 
 * @author Felix Zhao
 * @version 1/18/2023
 */
public class InfoWorld extends World
{

    /**
     * Constructor for objects of class InfoWorld.
     * Adds a back button to get back
     * The background image the of world is where the all the information is
     */
    public InfoWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addObject(new TravelButton("title", 132, 48, "images/ui/buttons/back_to_level", 3), 75, 30);
    }
}
