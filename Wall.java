import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wall extends TileObject
{
    
    public Wall(GreenfootImage image, int scale, int x, int y) {
        super(image, scale, x , y);
    }
    
    public Wall(String image) {
        setImage(new GreenfootImage(image));
    }
    
    public Wall() {
        super();
    }
    
    
}
