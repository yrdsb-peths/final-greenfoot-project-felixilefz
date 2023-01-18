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
    
    private static final int BUTTON_SCALE = 75;
    private static final int BUTTONS_PER_ROW = 4;
    private static final int BUTTON_PADDING = 100;
    
    public LevelSelect(int levelCount, int offset)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        int x = BUTTON_PADDING; // Starting number is the distance between edge and the button on a new row
        int y = 100; // same thing as above
        int spacing = (getWidth() - BUTTON_PADDING * 2) / (BUTTONS_PER_ROW-1);
        int totalRows = levelCount / BUTTONS_PER_ROW;
        
        addObject(new TravelButton(0, 132, 48, "images/ui/buttons/back_to_level", 3), 75, 30);
        
        for (int i = 0; i < totalRows; i++) {
            for (int j = 0; j < BUTTONS_PER_ROW; j++) {
                //if (i * BUTTONS_PER_ROW + j + 1 + offset > GameWorld.getHighestLevel()+1) {
                //    return;
                //}
                addObject(new TravelButton(i * BUTTONS_PER_ROW + j + 1 + offset,  BUTTON_SCALE, BUTTON_SCALE, "images/ui/buttons/level_button" + (i * BUTTONS_PER_ROW + j + 1 + offset), 3), x, y);
                x += spacing;
            }
            y += 100;
            x = BUTTON_PADDING;
        }
        
        // Checks if there's remaining buttons and adds it to the world
        if (levelCount % BUTTONS_PER_ROW != 0) {
            for (int i = 0; i < levelCount % BUTTONS_PER_ROW; i++) {
                addObject(new TravelButton(totalRows * BUTTONS_PER_ROW + i + 1 + offset, BUTTON_SCALE, BUTTON_SCALE, "images/ui/buttons/level_button" + (totalRows * BUTTONS_PER_ROW + i + 1 + offset), 3), x, y);
                x += spacing;
            }
        }
        
        
        
        
    }
}
