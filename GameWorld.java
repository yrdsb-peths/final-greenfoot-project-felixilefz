import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math.*;
/**
 * Write a description of class GameWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld extends World
{
    int scale;
    int width;
    int height;
    
    public GameWorld(int width, int height, int spawnX, int spawnY)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        this.width = width;
        this.height = height;
        scale = Math.min(600 / (width+2), 400 / (height + 2)); // The plus 2 because of the outer walls
        
        createBase();
        
        addObject(new Player(scale, spawnX, spawnY), 0, 0);
    }
    
    public void createBase() {
        // Creates the outer walls and places basic floor tiles
        String path = "images/tiles";
        int x = 0;
        int y = 0;
        
        addObject(new Wall(new GreenfootImage(path + "/walls/wall_top_left_corner.png"), scale, x, y), 0, 0);
        x ++;
        
        for (int i = 0; i < width; i++) {
            addObject(new Wall(new GreenfootImage(path + "/walls/wall_horizontal.png"), scale, x, y), 0, y);
            x ++;
        }
        
        addObject(new Wall(new GreenfootImage(path + "/walls/wall_top_right_corner.png"), scale, x, y), 0, 0);
        y ++;
        x = 0;
        for (int i = 0; i < height; i++) {
            
            addObject(new Wall(new GreenfootImage(path + "/walls/wall_vertical.png"), scale, x ,y), 0, 0);
            x ++;
            for (int j = 0; j < width; j++) {
                addObject(new Floor(new GreenfootImage(path + "/floors/tile_basic.png"), scale, x ,y), 0, 0);
                x ++;
            }
            addObject(new Wall(new GreenfootImage(path + "/walls/wall_vertical.png"), scale, x ,y), 0, 0);
            x = 0;
            y ++;
        }
        
        
        addObject(new Wall(new GreenfootImage(path + "/walls/wall_bottom_left_corner.png"), scale, x ,y), 0, 0);
        x ++;
        
        for (int i = 0; i < width; i++) {
            addObject(new Wall(new GreenfootImage(path + "/walls/wall_horizontal.png"), scale, x ,y), 0, 0);
            x ++;
        }
        
        addObject(new Wall(new GreenfootImage(path + "/walls/wall_bottom_right_corner.png"), scale, x ,y), 0, 0);
        
    }
        
    
    public int getBlocksWidth() {
        return width;
    }
    
    public int getBlocksHeight() {
        return height;
    }
    
    public int getScale() {
        return scale;
    }
    
}
