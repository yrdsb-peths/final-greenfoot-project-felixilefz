import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The title screen of the game. 
 * Brings the player to help, or the level select
 * 
 * @author Felix Zhao
 * @version 1/18/2023
 */
public class TitleScreen extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        TravelButton playButton = new TravelButton(-2, "images/ui/buttons/play_button", 3);
        TravelButton infoHelpButton = new TravelButton(-1, "images/ui/buttons/info_help", 3);
        playButton.setScale(192, 64);
        infoHelpButton.setScale(192, 64);
        addObject(playButton, getWidth()/2, getHeight()/2);
        addObject(infoHelpButton, getWidth()/2, getHeight()/2+75);
        addObject(new Label("Push Dungeon", 80), getWidth()/2, 60);
    }
}
