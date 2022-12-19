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
    
    private static final int LEVEL_COUNT = 6;
    private static final int BUTTON_SCALE = 50;
    private static final int BUTTONS_PER_ROW = 3;
    private static final int BUTTON_PADDING = 100;
    
    
    
    public LevelSelect()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        int x = BUTTON_PADDING; // Starting number is the distance between edge and the button on a new row
        int y = 100; // same thing as above
        int spacing = (600 - BUTTON_PADDING * 2) / (BUTTONS_PER_ROW-1);
        int totalRows = LEVEL_COUNT / BUTTONS_PER_ROW;
        
        for (int i = 0; i < totalRows; i++) {
            for (int j = 0; j < BUTTONS_PER_ROW; j++) {
                Button button = new Button(new GameWorld(), BUTTON_SCALE, BUTTON_SCALE, new GreenfootImage("images/buttons/level_button" + (i * BUTTONS_PER_ROW + j + 1)  + ".png"));
                addObject(button, x, y);
                x += spacing;
            }
            y += 100;
            x = BUTTON_PADDING;
        }
        
        // Checks if there's remaining buttons and adds it to the world
        if (LEVEL_COUNT % BUTTONS_PER_ROW != 0) {
            for (int i = 0; i < LEVEL_COUNT % BUTTONS_PER_ROW; i++) {
                Button button = new Button(new GameWorld(), BUTTON_SCALE, BUTTON_SCALE, new GreenfootImage("images/buttons/level_button" + (totalRows * BUTTONS_PER_ROW + i + 1)  + ".png"));
                addObject(button, x, y);
                x += spacing;
            }
        }
    }
}
