import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends TileObject
{
    int scale;
    SimpleTimer controlTimer = new SimpleTimer();
    
    public Player(int scale, int x, int y) {
        super(new GreenfootImage("images/player.png"), scale, x , y);
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
        if (controlTimer.millisElapsed() > 250) {
            if (Greenfoot.isKeyDown("d") && checkSpot(scale, 0)) {
                x ++;
                controlTimer.mark();
            }
            
            if (Greenfoot.isKeyDown("a") && checkSpot(-scale, 0)) {
                x --;
                controlTimer.mark();
            }
            
            if (Greenfoot.isKeyDown("w") && checkSpot(0, -scale)) {
                y --;
                controlTimer.mark();
            }
            
            if (Greenfoot.isKeyDown("s") && checkSpot(0, scale)) {
                y ++;
                controlTimer.mark();
            }
        }
        super.act();
        
    }
    
    // Checks the spot of the spot and returns true or false if the play can move to it
    public boolean checkSpot(int dx, int dy) {
        GameWorld world = (GameWorld) getWorld();
        
        List<Actor> touchingObjects = getObjectsAtOffset(dx, dy, null);
        
        for (int i = 0; i < touchingObjects.size(); i++) {
            if (touchingObjects.get(i) instanceof Wall) {
                return false;
            }
            
            if (touchingObjects.get(i) instanceof PushBlock) {
                PushBlock block = (PushBlock) touchingObjects.get(i);
                block.push(dx, dy);
            }
        }
            
        return true;
    }
}
