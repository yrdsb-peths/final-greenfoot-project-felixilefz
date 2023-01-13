import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class TravelButton extends Button
{

    private int level;
    
    public TravelButton(int level, int width, int height, String image, int numStates) {
        super(image, numStates);
        this.level = level;  
        for (int i = 0; i < imageStates.length; i++) {
            imageStates[i].scale(width, height);
        }
    }
    
    public TravelButton(int level, String image, int numStates) {
        super(image, numStates);
        this.level = level;         
    }
    
    public void action() 
    {
        // should switch to switch cases
        if (level == 0) {
            Greenfoot.setWorld(new LevelSelect());
        } else if (level == 1) {
            Greenfoot.setWorld(new LevelOne());
        } else if (level == 2 && GameWorld.getHighestLevel() >= 1) {
            Greenfoot.setWorld(new LevelTwo());
        } else if (level == 3) {
            Greenfoot.setWorld(new LevelThree());
        } else if (level == 4) {
            Greenfoot.setWorld(new LevelFour());
        }      
        
        
    }

}
