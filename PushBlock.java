import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Interactables here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PushBlock extends TileObject
{
    public static GreenfootSound splashSound = new GreenfootSound("sounds/splash_sound.mp3");
    
    public PushBlock() {
        
    }
    
    
    
    public void act() 
    {
        // Add your action code here.
        super.act();
    }
    
    public boolean push(int dx, int dy) {
        if (!checkSpot(dx, dy)) {
            return false;
        }
        
        return true;
    }
    
    public boolean checkSpot(int dx, int dy) {
        if (x + dx >= world.getGridWidth() || y + dy >= world.getGridHeight() || x+dx < 0 || y+dy < 0) {
            return false;
        }
        
        TileObject floor = world.getFloorAt(x+dx, y+dy);
        TileObject block = world.getBlockAt(x+dx, y+dy);
        
        
        if (block instanceof Wall || block instanceof Finish) {
            return false;
        }
        
        if (floor instanceof Water) {
            world.removeBlock(x, y);
            splashSound.play();
            Floor newFloor = new Floor();
            world.addObject(newFloor, 0, 0);
            newFloor.setX(x + dx);
            newFloor.setY(y + dy);
            newFloor.setScale(scale);
            world.replaceFloor(x+dx, y+dy, newFloor);
            
            
            world.removeObject(floor);
            world.removeObject(this);
            return true;
        }
            
        if (block instanceof PushBlock) {
            if (!((PushBlock)block).push(dx, dy)) {
                return false;
            }
        }
        
        if (getWorld() == null) {
            return true;
        }
        
        world.removeBlock(x, y);
        setX(x+dx);
        setY(y+dy);
        world.replaceBlock(x, y, this);
        return true;
    }
}
