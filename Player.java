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
    boolean tweening = false;
    
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
        if (tweening) {
            return;
        }
        GameWorld world = (GameWorld) getWorld();
        if (controlTimer.millisElapsed() > 200) {
            
            if (Greenfoot.isKeyDown("d")) {
                checkSpot(1, 0);
            } else if (Greenfoot.isKeyDown("a")) {
                checkSpot(-1, 0);
            } else if (Greenfoot.isKeyDown("w")) {
                checkSpot(0, -1);
            } else if (Greenfoot.isKeyDown("s")) {
                checkSpot(0, 1);
            }
        }
        super.act();
        
    }
    
    // Checks the spot of the spot and returns true or false if the play can move to it
    public boolean checkSpot(int dx, int dy) {
        GameWorld world = (GameWorld) getWorld();
        controlTimer.mark();
        if (x + dx >= world.getGridWidth() || y + dy >= world.getGridHeight() || x+dx < 0 || y+dy < 0) {
            return false;
        }
        
        TileObject floor = world.getFloorAt(x+dx, y+dy);
        TileObject block = world.getBlockAt(x+dx, y+dy);
        
        if (block instanceof Wall || floor instanceof Water) {
            return false;
        }
            
        if (block instanceof PushBlock) {
            if (!((PushBlock)block).push(dx, dy)) {
                return false;
            }
        }
        
        if (floor instanceof Ice) {
            world.playerMoved();
            world.removeBlock(x, y);
            setX(x+dx);
            setY(y+dy);
            world.replaceBlock(x, y, this);
            slip(x, y, dx, dy);
            return false;
        }
        
        if (block instanceof Finish) {
            world.finishLevel();
        }
        world.playerMoved();
        world.removeBlock(x, y);
        setX(x+dx);
        setY(y+dy);
        world.replaceBlock(x, y, this);
        return true;
    }
    
    private void slip(int newX, int newY, int dx, int dy) {
        GameWorld world = (GameWorld) getWorld();
        if (newX + dx >= world.getGridWidth() || newY + dy >= world.getGridHeight() || newX+dx < 0 || newY+dy < 0) {
            tween(newX, newY);
            return;
        }
        
        TileObject floor = world.getFloorAt(newX+dx, newY+dy);
        TileObject block = world.getBlockAt(newX+dx, newY+dy);
        
        if (block instanceof PushBlock || block instanceof Wall || block instanceof Finish) {
            tween(newX, newY);
            return;
        }
        
        if (floor instanceof Ice) {
            slip(newX+dx, newY+dy, dx, dy);
            return;
        }
        
        if (floor instanceof Water) {
            // death
            System.out.println("dead");
        }
        
        tween(newX+dx, newY+dy);
        
    }
    
    private void tween(int endX, int endY) {
        // Planned to have an in between animation, but not here yet. 
        GameWorld world = (GameWorld) getWorld();
        world.removeBlock(x, y);
        setX(endX);
        setY(endY);
        world.replaceBlock(endX, endY, this);
    }
}
