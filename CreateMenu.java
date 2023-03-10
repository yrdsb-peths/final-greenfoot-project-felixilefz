import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The menu that brings you to a place where you can play and create your own levels
 * 
 * @author Felix Zhao
 * @version 1/19/2023
 */
public class CreateMenu extends World
{

    /**
     * Constructor for objects of class CreateMenu.
     * 
     */
    public CreateMenu()
    {    
        super(600, 400, 1); 
        TravelButton playButton = new TravelButton("-1", 192, 64, "images/ui/buttons/play_button", 3);
        TravelButton createButton = new TravelButton("create", 192, 64, "images/ui/buttons/create_button", 3);
        Label text = new Label("You can create your own levels here. \n Although it is limited in what you can do \n You only have a 10x10 space \n and you cannot have blocks tiles \n on special floor tiles", 25);
        addObject(text, getWidth()/2, 60);
        addObject(playButton, getWidth()/2, getHeight()/2+75);
        addObject(createButton, getWidth()/2, getHeight()/2+150);
        addObject(new TravelButton("title", 132, 48, "images/ui/buttons/back_to_level", 3), 75, 350);
    }
}
