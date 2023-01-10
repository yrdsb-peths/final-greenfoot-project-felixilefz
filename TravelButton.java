import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class TravelButton extends Button
{

    private int level;
    
    public TravelButton(int level, int width, int height, GreenfootImage image) {
        this.level = level;
        image.scale(width, height);
        setImage(image);
        
    }
    
    public void action() 
    {
        // should switch to switch cases
        if (level == 0) {
            Greenfoot.setWorld(new LevelSelect());
        } else if (level == 1) {
            Greenfoot.setWorld(new LevelOne());
        } else if (level == 2) {
            Greenfoot.setWorld(new LevelTwo());
        } else if (level == 3) {
            Greenfoot.setWorld(new LevelThree());
        } else if (level == 4) {
            Greenfoot.setWorld(new LevelFour());
        }      
        
        
    }

}
