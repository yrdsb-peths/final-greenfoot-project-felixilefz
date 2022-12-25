import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class TileObject extends Actor
{
    
    int scale;
    int x;
    int y;
    
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
    
    public void act() 
    {
       
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
