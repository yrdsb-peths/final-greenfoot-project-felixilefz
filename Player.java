import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    
    
    public Player(int x, int y, int scale) {
        GreenfootImage image = getImage();
        image.scale(scale, scale);
        setImage(image);
    }
    
    public void act()
    {
        // Add your action code here.
        GameWorld world = (GameWorld) getWorld();
        
    }
}
