import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dynamite here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dynamite extends PushBlock
{
    public static GreenfootSound soundEffect = new GreenfootSound("sounds/explosion_sound.mp3");
    
    public boolean checkSpot(int dx, int dy) {
        GameWorld world = (GameWorld) getWorld();
        if (x + dx >= world.getGridWidth() || y + dy >= world.getGridHeight() || x+dx < 0 || y+dy < 0) {
            
            explode(0, 0);
            return true;
        }
        
        TileObject floor = world.getFloorAt(x+dx, y+dy);
        TileObject block = world.getBlockAt(x+dx, y+dy);
        
        if (block instanceof StrongWall || block instanceof StrongDoor) {
            explode(0, 0);
            return true;
        }
        
        
        
        if (block instanceof Wall || block instanceof Finish) {

            explode(dx, dy);
            //world.removeBlock(x+dx, y+dy);            
            
            //world.removeObject(block);
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
            
        if (block instanceof PushBlock) {
            if (!((PushBlock)block).push(dx, dy)) {

                explode(dx, dy);
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
        
        tween(newX+dx, newY+dy);
        
    }
    
    private void tween(int endX, int endY) {
        GameWorld world = (GameWorld) getWorld();
        world.removeBlock(x, y);
        setX(endX);
        setY(endY);
        world.replaceBlock(endX, endY, this);
    }
    
    // Destory everything, including the player, in a 3x3 box
    private void explode(int dx, int dy) {
        soundEffect.play();
        world.removeBlock(x, y);
        world.removeObject(this);
        // Uses a for loop to easily change the explosion area
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                world.addObject(new Particles(50, "images/particles/fire.gif", scale, scale),(x+i+dx)*scale+scale/2, (y+j+dy)*scale+scale/2);
                
                if (x+i+dx >= 0 && x+i+dx < world.getGridWidth() && y+j+dy >= 0 && y+j+dy < world.getGridHeight()) {
                    TileObject block = world.getBlockAt(x+i+dx, y+j+dy);
                    
                    if (block instanceof Player) {
                        world.lostLevel();
                    }
                    if (block instanceof Dynamite) {
                        ((Dynamite) block).explode(0, 0);
                    }
                    if (block instanceof StrongWall || block instanceof StrongDoor) {
                        continue;
                    }
                    
                    world.removeBlock(x+i+dx, y+j+dy);
                    world.removeObject(block);
                }
            }
        }
    }
}
