import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Directs the user to a new world depending on the button
 * 
 * @author Felix Zhao
 * @version 1/18/2023
 */

public class TravelButton extends Button
{

    private String level;
    
    /**
     * Sets the button with a level. Sets the image(s) and the scale of the image
     */
    public TravelButton(String level, int width, int height, String image, int numStates) {
        super(image, numStates);
        this.level = level;  
        for (int i = 0; i < imageStates.length; i++) {
            imageStates[i].scale(width, height);
        }
    }
    
    /**
     * Sets the button with a level. Sets the image(s)
     */
    public TravelButton(String level, String image, int numStates) {
        super(image, numStates);
        this.level = level;         
    }
    
    /**
     * action in this button checks the level it is assgined to and goes the corrosponding world
     */
    public void action() 
    {
        
        
        if (level.equals("title")) {
            Greenfoot.setWorld(new TitleScreen());
        } else if (level.equals("info")) {
            Greenfoot.setWorld(new InfoWorld());
        } else if (level.equals("create")) {
            Greenfoot.setWorld(new LevelCreator());
        } else if (level.equals("createmenu")) {
            Greenfoot.setWorld(new CreateMenu());
        } else if (level.equals("select1")) {
            Greenfoot.setWorld(new LevelSelectOne());
        } else if (level.equals("select2")) {
            Greenfoot.setWorld(new LevelSelectTwo());
        } else if (level.equals("-1") && checkCustomLevel()) {
            Greenfoot.setWorld(new CustomLevel());
        } else if (level.equals("1")) {
            Greenfoot.setWorld(new LevelOne());
        } else if (level.equals("2")) {
            Greenfoot.setWorld(new LevelTwo());
        } else if (level.equals("3")) {
            Greenfoot.setWorld(new LevelThree());
        } else if (level.equals("4")) {
            Greenfoot.setWorld(new LevelFour());
        } else if (level.equals("5")) {
            Greenfoot.setWorld(new LevelFive());
        } else if (level.equals("6")) {
            Greenfoot.setWorld(new LevelSix());
        } else if (level.equals("7")) {
            Greenfoot.setWorld(new LevelSeven());
        } else if (level.equals("8")) {
            Greenfoot.setWorld(new LevelEight());
        } else if (level.equals("9")) {
            Greenfoot.setWorld(new LevelNine());
        } else if (level.equals("10")) {
            Greenfoot.setWorld(new LevelTen());
        } else if (level.equals("11")) {
            Greenfoot.setWorld(new LevelEleven());
        } else if (level.equals("12")) {
            Greenfoot.setWorld(new LevelTwelve());
        } else if (level.equals("13")) {
            Greenfoot.setWorld(new LevelThirteen());
        } else if (level.equals("14")) {
            Greenfoot.setWorld(new LevelFourteen());
        } else if (level.equals("15")) {
            Greenfoot.setWorld(new LevelFifthteen());
        } else if (level.equals("16")) {
            Greenfoot.setWorld(new LevelSixteen());
        } 
    }
    
    public boolean checkCustomLevel() {
        World world = getWorld();
        TileObject[][] blockPlan = CustomLevel.getBlockPlan();
        int playerCount = 0;
        int finishCount = 0;
        
        for (int i = 0; i < blockPlan.length; i++) {
            for (int j = 0; j < blockPlan[0].length; j++) {
                if (blockPlan[i][j] instanceof Player) {
                    playerCount ++;
                    if (playerCount > 1) {
                        world.addObject(new Particles(100, new GreenfootImage("There is more than one character", 40, Color.WHITE, null)), world.getWidth()/2, world.getHeight()/2);
                        return false;
                    }
                }
                
                if (blockPlan[i][j] instanceof Finish) {
                    finishCount ++;
                }
            }
        }
        
        if (finishCount == 0 || playerCount == 0) {
            world.addObject(new Particles(100, new GreenfootImage("There's no finish or player", 40, Color.WHITE, null)), world.getWidth()/2, world.getHeight()/2);
            return false;
        }
        return true;
    }

}
