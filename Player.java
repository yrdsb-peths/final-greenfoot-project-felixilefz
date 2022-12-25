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
    
    // Not used yet
    public Player(int scale, int x, int y) {
        super(new GreenfootImage("images/player.png"), scale, x , y);
        this.scale = scale;
        this.x = x;
        this.y = y;
        GreenfootImage image = getImage();
        image.scale(scale, scale);
        setImage(image);
    }
    
    public Player() {
        
    }
    
    public void act()
    {
        // Add your action code here.
        
        GameWorld world = (GameWorld) getWorld();
        if (controlTimer.millisElapsed() > 250) {
            if (Greenfoot.isKeyDown("d") && checkSpot(1, 0)) {
                setX(x+1);
                controlTimer.mark();
            }
            
            if (Greenfoot.isKeyDown("a") && checkSpot(-1, 0)) {
                setX(x-1);
                controlTimer.mark();
            }
            
            if (Greenfoot.isKeyDown("w") && checkSpot(0, -1)) {
                setY(y-1);
                controlTimer.mark();
            }
            
            if (Greenfoot.isKeyDown("s") && checkSpot(0, 1)) {
                setY(y+1);
                controlTimer.mark();
            }
        }
        super.act();
        
    }
    
    // Checks the spot of the spot and returns true or false if the play can move to it
    public boolean checkSpot(int dx, int dy) {
        GameWorld world = (GameWorld) getWorld();
        
        if (x + dx >= world.getGridWidth() || y + dy >= world.getGridHeight() || x+dx < 0 || y+dy < 0) {
            return false;
        }
        
        TileObject floor = world.getFloorAt(x+dx, y+dy);
        TileObject block = world.getBlockAt(x+dx, y+dy);
        
        
        if (block instanceof Wall) {
            return false;
        }
            
        if (block instanceof PushBlock) {
            if (!((PushBlock)block).push(dx, dy)) {
                return false;
            }
        }
        
        if (block instanceof Finish) {
            world.finishLevel();
        }
         
        return true;
    }
}
