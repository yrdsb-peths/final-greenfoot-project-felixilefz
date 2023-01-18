import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
        TravelButton settingsButton = new TravelButton(-2, "images/ui/buttons/game_setting", 3);
        TravelButton infoHelpButton = new TravelButton(-1, "images/ui/buttons/info_help", 3);
        playButton.setScale(192, 64);
        settingsButton.setScale(192, 64);
        infoHelpButton.setScale(192, 64);
        addObject(playButton, getWidth()/2, getHeight()/2-25);
        addObject(settingsButton, getWidth()/2, getHeight()/2+50);
        addObject(infoHelpButton, getWidth()/2, getHeight()/2+125);
    }
}
