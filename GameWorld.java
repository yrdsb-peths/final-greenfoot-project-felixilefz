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
    TileObject[][] floorGrid; 
    TileObject[][] blockGrid;
    
    public GameWorld(TileObject[][] floorPlan, TileObject[][] blockPlan)
    {    
        super(600, 400, 1); 
        width = floorPlan[0].length;
        height = floorPlan.length;
        floorGrid = new TileObject[height][width];
        blockGrid = new TileObject[height][width];
        // Clone entire array
        for (int i = 0; i < floorPlan.length; i++) {
            for (int j= 0; j < floorPlan[0].length; j++) {
                floorGrid[i][j] = floorPlan[i][j];
                blockGrid[i][j] = blockPlan[i][j];
            }
        }
        
        
        scale = Math.min(600 / (width), 400 / (height)); 
        
        createBase();
        setPaintOrder(PushBlock.class, Wall.class, Player.class, Finish.class, Water.class, Floor.class);
        
    }
    
    public void createBase() {
        // Creates the outer walls and places basic floor tiles
        String path = "images/tiles";
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (floorGrid[i][j] != null) {
                    addObject(floorGrid[i][j], 0, 0);
                    floorGrid[i][j].setX(j);
                    floorGrid[i][j].setY(i);
                    floorGrid[i][j].setScale(scale);
                } else {
                    TileObject floor = new Floor(new GreenfootImage(path + "/floors/tile_basic.png"), scale, j ,i);
                    addObject(floor, j*scale+scale/2, i*scale+scale/2);
                    replaceFloor(j, i, floor);
                }
                
                if (blockGrid[i][j] != null) {
                    addObject(blockGrid[i][j], 0, 0);
                    blockGrid[i][j].setX(j);
                    blockGrid[i][j].setY(i);
                    blockGrid[i][j].setScale(scale);
                } 
                
            }
        }
       
    }
    
    public void finishLevel() {
        Greenfoot.setWorld(new LevelSelect());
    }
    
    public void lostLevel() {
        
    }
    
    //Getters and Setters
    
    public int getGridWidth() {
        return width;
    }
    
    public int getGridHeight() {
        return height;
    }
    
    public TileObject getFloorAt(int x, int y) {
        return floorGrid[y][x];
    }
    
    public TileObject getBlockAt(int x, int y) {
        return blockGrid[y][x];
    }
    
    public void removeBlock(int x, int y) {
        blockGrid[y][x] = null;
    }
    
    public void replaceBlock(int x, int y, TileObject block) {
        blockGrid[y][x] = block;
    }
    
    public void removeFloor(int x, int y) {
        floorGrid[y][x] = null;
    }
    
    public void replaceFloor(int x, int y, TileObject floor) {
        floorGrid[y][x] = floor;
    }
    
}
