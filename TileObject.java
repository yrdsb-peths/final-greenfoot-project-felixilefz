import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class TileObject extends Actor
{
    
    int scale;
    int x;
    int y;
    
    public TileObject(GreenfootImage image, int scale, int x, int y) {
        this.scale = scale;
        this.x = x;
        this.y = y;
        image.scale(scale, scale);
        setImage(image);
    }
    
    public void act() 
    {
       setLocation(x*scale+scale/2, y*scale+scale/2);
    }    
}
