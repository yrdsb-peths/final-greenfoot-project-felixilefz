import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Water here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Water extends TileObject
{
    public Water(GreenfootImage image, int scale, int x, int y) {
        super(image, scale, x , y);
    }
    
    public Water(String image) {
        setImage(new GreenfootImage(image));
    }
    
    public Water() {
        super();
    }
    
    public void act() 
    {
        // Add your action code here.
        GameWorld world = (GameWorld) getWorld();
        
    }   
}
