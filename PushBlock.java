import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Interactables here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PushBlock extends TileObject
{
    /**
     * Act - do whatever the Interactables wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public PushBlock(GreenfootImage image, int scale, int x, int y) {
        super(image, scale, x, y);
    }
    
    public void act() 
    {
        // Add your action code here.
        super.act();
    }
    
    public void push(int dx, int dy) {
        
        if (dx > 0) {
            x++;
        }
        
        if (dx < -1) {
            x--;
        }
        
        if (dy > 0) {
            y++;
        }
        
        if (dy < -1) {
            y--;
        }
    }
    
    
}
