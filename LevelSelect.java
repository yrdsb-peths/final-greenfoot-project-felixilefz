import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelSelect here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelSelect extends World
{

    /**
     * Constructor for objects of class LevelSelect.
     * 
     */
    
    private static final int LEVEL_COUNT = 4;
    private static final int SCALE = 75;
    
    public LevelSelect()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        int x = 100; // Starting number is the distance between edge and the button on a new row
        int y = 100; // same thing as above
        
        for (int i = 1; i <= LEVEL_COUNT; i++) {
            Button button = new Button(new GameWorld(), SCALE, SCALE, new GreenfootImage("images/buttons/level_button" + i + ".png"));
            addObject(button, x, y);
            x += SCALE + 50;
        }
    }
}
