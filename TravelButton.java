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
        if (level == -3) {
            Greenfoot.setWorld(new LevelSelectTwo());
        } if (level == -2) {
            Greenfoot.setWorld(new LevelSelectOne());
        } else if (level == -1) {
            Greenfoot.setWorld(new InfoWorld());
        } else if (level == 0) {
            Greenfoot.setWorld(new TitleScreen());
        } else if (level == 1) {
            Greenfoot.setWorld(new LevelOne());
        } else if (level == 2) {
            Greenfoot.setWorld(new LevelTwo());
        } else if (level == 3) {
            Greenfoot.setWorld(new LevelThree());
        } else if (level == 4) {
            Greenfoot.setWorld(new LevelFour());
        } else if (level == 5) {
            Greenfoot.setWorld(new LevelFive());
        } else if (level == 6) {
            Greenfoot.setWorld(new LevelSix());
        } else if (level == 7) {
            Greenfoot.setWorld(new LevelSeven());
        } else if (level == 8) {
            Greenfoot.setWorld(new LevelEight());
        } else if (level == 9) {
            Greenfoot.setWorld(new LevelNine());
        } else if (level == 10) {
            Greenfoot.setWorld(new LevelTen());
        } else if (level == 11) {
            Greenfoot.setWorld(new LevelEleven());
        } else if (level == 12) {
            Greenfoot.setWorld(new LevelTwelve());
        } else if (level == 13) {
            Greenfoot.setWorld(new LevelThirteen());
        } else if (level == 14) {
            Greenfoot.setWorld(new LevelFourteen());
        } else if (level == 15) {
            Greenfoot.setWorld(new LevelFifthteen());
        } 
        
        
    }

}
