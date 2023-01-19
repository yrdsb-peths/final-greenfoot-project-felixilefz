import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * An pushable item that is used within gameplay
 * Explodes in a 1x1 box when crushed breaking various blocks
 * Can fill water
 * 
 * @author Felix Zhao
 * @version 1/18/2023
 */
public class Bomb extends PushBlock
{
    
    public static GreenfootSound soundEffect = new GreenfootSound("sounds/explosion_sound.mp3");

    
    public boolean checkSpot(int dx, int dy) {
        GameWorld world = (GameWorld) getWorld();
        if (x + dx >= world.getGridWidth() || y + dy >= world.getGridHeight() || x+dx < 0 || y+dy < 0) {
            world.addObject(new Particles(50, "images/particles/fire.gif", scale, scale),x*scale+scale/2, y*scale+scale/2);
            soundEffect.play();
            world.removeBlock(x, y);
            world.removeObject(this);
            return true;
        }
        
        TileObject floor = world.getFloorAt(x+dx, y+dy);
        TileObject block = world.getBlockAt(x+dx, y+dy);
        
        if (block instanceof StrongWall || block instanceof StrongDoor) {
            soundEffect.play();
            world.addObject(new Particles(50, "images/particles/fire.gif", scale, scale),x*scale+scale/2, y*scale+scale/2);
            world.removeBlock(x, y);
            world.removeObject(this);
            return true;
        }
        
        
        if (block instanceof Wall || block instanceof Finish) {
            soundEffect.play();
            world.removeBlock(x, y);
            world.removeBlock(x+dx, y+dy);            
            world.addObject(new Particles(50, "images/particles/fire.gif", scale, scale),(x+dx)*scale+scale/2, (y+dy)*scale+scale/2);
            world.removeObject(block);
            world.removeObject(this);
            return true;
        }
        
        if (floor instanceof Water) {
            splashSound.play();
            world.removeBlock(x, y);
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
                soundEffect.play();
                world.removeBlock(x, y);
                world.removeBlock(x+dx, y+dy);            
                world.addObject(new Particles(50, "images/particles/fire.gif", scale, scale),(x+dx)*scale+scale/2, (y+dy)*scale+scale/2);
                world.removeObject(block);
                world.removeObject(this);
                return true;
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
