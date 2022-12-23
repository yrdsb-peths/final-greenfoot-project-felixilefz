import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class TravelButton extends Actor
{

    private int level;
    
    public TravelButton(int level, int width, int height, GreenfootImage image) {
        this.level = level;
        image.scale(width, height);
        setImage(image);
        
    }
    
    public void act() 
    {
        if (Greenfoot.mousePressed(this)) {
            if (level == 0) {
                Greenfoot.setWorld(new LevelSelect());
            } else if (level == 1) {
                Greenfoot.setWorld(new LevelOne());
            } 
                
        }
        
    }

}
