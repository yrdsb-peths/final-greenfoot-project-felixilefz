import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * An item that is used in GameWorld
 * Can open doors and can fill water
 * 
 * @author Felix Zhao
 * @version 1/18/2023
 */
public class Key extends PushBlock
{
    
    public static GreenfootSound soundEffect = new GreenfootSound("sounds/open_door_sound.mp3");
    
    public boolean checkSpot(int dx, int dy) {
        if (x + dx >= world.getGridWidth() || y + dy >= world.getGridHeight() || x+dx < 0 || y+dy < 0) {
            return false;
        }
        
        TileObject floor = world.getFloorAt(x+dx, y+dy);
        TileObject block = world.getBlockAt(x+dx, y+dy);
        
        
        if (block instanceof Door) {
            soundEffect.play();
            world.removeBlock(x, y);
            world.removeBlock(x+dx, y+dy);
            
            world.removeObject(block);
            world.removeObject(this);
            return true;
        }
        
        if (block instanceof Wall || block instanceof Finish) {
            return false;
        }
        
        if (block instanceof PushBlock) {
            if (!((PushBlock)block).push(dx, dy)) {
                return false;
            }
        }
        
        if (floor instanceof Ice) {
            world.removeBlock(x, y);
            setX(x+dx);
            setY(y+dy);
            world.replaceBlock(x, y, this);
            slip(x, y, dx, dy);
            return true;
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
            
        if (getWorld() == null) {
            return true;
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
            Floor newFloor = new Floor();
            world.addObject(newFloor, 0, 0);
            newFloor.setX(newX + dx);
            newFloor.setY(newY + dy);
            newFloor.setScale(scale);
            world.replaceFloor(newX+dx, newY+dy, newFloor);
            world.removeObject(floor);
            world.removeBlock(x, y);
            world.removeObject(this);
            
            return;
        }
        
        iceMove(newX+dx, newY+dy);
        
    }
    
    private void iceMove(int endX, int endY) {
        GameWorld world = (GameWorld) getWorld();
        world.removeBlock(x, y);
        setX(endX);
        setY(endY);
        world.replaceBlock(endX, endY, this);
    }
    
}
