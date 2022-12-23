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
    Actor[][] floorGrid; 
    Actor[][] blockGrid;
    
    public GameWorld(int spawnX, int spawnY, String[][] floorPlan, String[][] blockPlan)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        this.width = floorGrid[0].length;
        this.height = floorGrid.length;
        floorGrid = new Actor[floorPlan.length][floorPlan[0].length];
        blockGrid = new Actor[blockPlan.length][blockPlan[0].length];
        scale = Math.min(600 / (width+2), 400 / (height + 2)); // The plus 2 because of the outer walls
        
        createBase(floorPlan, blockPlan);
        setPaintOrder(Player.class, PushBlock.class, Wall.class, Floor.class);
        addObject(new Player(scale, spawnX, spawnY), 0, 0);
    }
    
    public void createBase(String[][] floorPlan, String[][] blockPlan) {
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
                createTile(x, y);
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
    
    public void createTile(int x, int y) {
        
        
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
