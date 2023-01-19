
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Used in GameWorld
 * Used as a tile
 * 
 * @author Felix Zhao
 * @version 1/18/2023
 */

public class TileObject extends Actor
{
    
    int scale;
    int x;
    int y;
    GameWorld world;
    
    // Not used Currently, may be used later
    public TileObject(GreenfootImage image, int scale, int x, int y) {
        this.scale = scale;
        this.x = x;
        this.y = y;
        image.scale(scale, scale);
        setImage(image);
    }
    
    public TileObject() {
        
    }
    
    public void addedToWorld(World world) {
        this.world = (GameWorld) world;
    }
    
    public void setX(int newX) {
        x = newX;
        setLocation(x*scale+scale/2, y*scale+scale/2);
    }
    
    public void setY(int newY) {
        y = newY;
        setLocation(x*scale+scale/2, y*scale+scale/2);
    }
    
    public void setScale(int newScale) {
        scale = newScale;
        setLocation(x*scale+scale/2, y*scale+scale/2);
        GreenfootImage image = getImage();
        image.scale(scale, scale);
        setImage(image);
    }
}
