import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
