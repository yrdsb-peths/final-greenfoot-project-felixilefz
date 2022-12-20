import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    private int scale;
    private SimpleTimer controlTimer = new SimpleTimer();
    private int x;
    private int y;
    
    public Player(int scale, int x, int y) {
        this.scale = scale;
        this.x = x;
        this.y = y;
        GreenfootImage image = getImage();
        image.scale(scale, scale);
        setImage(image);
    }
    
    public void act()
    {
        // Add your action code here.
        
        GameWorld world = (GameWorld) getWorld();
        if (controlTimer.millisElapsed() > 200) {
            if (Greenfoot.isKeyDown("d") && !Greenfoot.isKeyDown("a") && validSpot(x+1, y)) {
                x ++;
                controlTimer.mark();
            }
            
            if (Greenfoot.isKeyDown("a") && !Greenfoot.isKeyDown("d")) {
                x --;
                controlTimer.mark();
            }
            
            if (Greenfoot.isKeyDown("w")) {
                y --;
                controlTimer.mark();
            }
            
            if (Greenfoot.isKeyDown("s")) {
                y ++;
                controlTimer.mark();
            }
        }
        setLocation(x*scale+scale/2, y*scale+scale/2);
        
    }
    
    public boolean validSpot(int newX, int newY) {
        GameWorld world = (GameWorld) getWorld();
        if (x <= 0 || x >= world.getWidth() || y <= 0 || y >= world.getHeight()) {
            return false;
        }
        
        
        return true;
    }
}
