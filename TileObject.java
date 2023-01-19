
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The super class of all tiles used in gameplay
 * Has a position and a scale factor
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
    
    /**
     * Creates a tile with a image with a scale at a certain position
     * @param image the image that is used for the tile
     * @param scale the scale of that image
     * @param x the x position of the tile
     * @param y the y position of the tile
     */
    public TileObject(GreenfootImage image, int scale, int x, int y) {
        this.scale = scale;
        this.x = x;
        this.y = y;
        image.scale(scale, scale);
        setImage(image);
    }
    
    public TileObject() {
        
    }
    
    /**
     * Gets called when added a world. Stores the world for later use
     * @param world the world that the tile is in
     */
    public void addedToWorld(World world) {
        this.world = (GameWorld) world;
    }
    
    /**
     * Sets the x coordinate. Not the actual x but relative to the other tiles
     * @param newX sets x to newX
     */
    public void setX(int newX) {
        x = newX;
        setLocation(x*scale+scale/2, y*scale+scale/2);
    }
    
    /**
     * Sets the y coordinate. Not the actual y but relative to the other tiles
     * @param newY sets y to newY
     */
    public void setY(int newY) {
        y = newY;
        setLocation(x*scale+scale/2, y*scale+scale/2);
    }
    
    /**
     * Sets the scale of the image
     * @param newScale what the new scale of image will
     */
    public void setScale(int newScale) {
        scale = newScale;
        setLocation(x*scale+scale/2, y*scale+scale/2);
        GreenfootImage image = getImage();
        image.scale(scale, scale);
        setImage(image);
    }
}
