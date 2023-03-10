import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Listens to the user's input and moves accordingly
 * Can die in some situtations
 * 
 * @author Felix Zhao
 * @version 1/18/2023
 */
public class Player extends TileObject
{

    SimpleTimer controlTimer = new SimpleTimer();
    boolean canMove = true;
    
    public static GreenfootSound splashSound = new GreenfootSound("sounds/splash_sound.mp3");
    
    public void act()
    {
        GameWorld world = (GameWorld) getWorld();
        if (!canMove) {
            return;
        }
        
        if (controlTimer.millisElapsed() > 200) {
            
            if (Greenfoot.isKeyDown("d")) {
                
                checkSpot(1, 0);
                
            } else if (Greenfoot.isKeyDown("a")) {
                
                checkSpot(-1, 0);
                
            } else if (Greenfoot.isKeyDown("w")) {
                
                checkSpot(0, -1);
                
            } else if (Greenfoot.isKeyDown("s")) {
                
                checkSpot(0, 1);
                
            } else if (Greenfoot.isKeyDown("z")) {
                controlTimer.mark();
                world.undoMove();
                
            } else if (Greenfoot.isKeyDown("escape")) {
                world.pauseLevel();
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
        
        world.playerMoved();
        
        if (block instanceof Finish) {
            world.finishLevel();
        }
        
        if (block instanceof PushBlock) {
            if (!((PushBlock)block).push(dx, dy)) {
                world.removeUndo();
                return false;
            }
        }
        
        if (floor instanceof Ice) {
            world.removeBlock(x, y);
            setX(x+dx);
            setY(y+dy);
            world.replaceBlock(x, y, this);
            slip(x, y, dx, dy);
            return false;
        }
        
        world.removeBlock(x, y);
        setX(x+dx);
        setY(y+dy);
        world.replaceBlock(x, y, this);
        return true;
    }
    
    private void slip(int newX, int newY, int dx, int dy) {
        GameWorld world = (GameWorld) getWorld();
        if (newX + dx >= world.getGridWidth() || newY + dy >= world.getGridHeight() || newX+dx < 0 || newY+dy < 0) {
            iceMove(newX, newY);
            return;
        }
        
        TileObject floor = world.getFloorAt(newX+dx, newY+dy);
        TileObject block = world.getBlockAt(newX+dx, newY+dy);
        
        if (block instanceof PushBlock || block instanceof Wall || block instanceof Finish) {
            iceMove(newX, newY);
            return;
        }
        
        if (floor instanceof Ice) {
            slip(newX+dx, newY+dy, dx, dy);
            return;
        }
        
        if (floor instanceof Water) {
            splashSound.play();
            world.lostLevel();
        }
        
        iceMove(newX+dx, newY+dy);
        
    }
    
    private void iceMove(int endX, int endY) {
        // Planned to have an in beiceMove animation, but not here yet. 
        GameWorld world = (GameWorld) getWorld();
        world.removeBlock(x, y);
        setX(endX);
        setY(endY);
        world.replaceBlock(endX, endY, this);
    }
    
    public void movementOff() {
        canMove = false;
    }
    
    public void movementOn() {
        canMove = true;
    }
}
