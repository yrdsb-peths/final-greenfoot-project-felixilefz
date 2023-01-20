import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CreateMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
    }
}
