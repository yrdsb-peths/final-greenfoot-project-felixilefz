import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{

    private World destination;
    
    public Button(World destination, int width, int height, GreenfootImage image) {
        this.destination = destination;
        image.scale(width, height);
        setImage(image);
    }
    
    public void act() 
    {
        if (Greenfoot.mousePressed(this)) {
            
            Greenfoot.setWorld(destination);
            
        }
        
    }

}
