import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math.*;
import java.util.*;
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
    Stack<TileObject[][]> previousMoves = new Stack<>();
    Player plr;
    int level;
    
    public GameWorld(TileObject[][] floorPlan, TileObject[][] blockPlan, int level)
    {    
        super(600, 400, 1); 
        this.level = level;
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
        setPaintOrder(Button.class, Menu.class, PushBlock.class, Wall.class, Player.class, Finish.class, Water.class, Floor.class);
        
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
                    if (blockGrid[i][j] instanceof Player) {
                        plr = (Player) blockGrid[i][j];
                    }
                } 
                
            }
        }
       
    }
    
    public void playerMoved() {
        int prevMovesSize = previousMoves.size();
        
        // if stack size is above 20 (or 10 moves) remove the least recent one
        if (prevMovesSize >= 20) {
            previousMoves.remove(0);
            previousMoves.remove(0);
        }
        
        TileObject[][] oldFloorGrid = new TileObject[floorGrid.length][floorGrid[0].length];
        TileObject[][] oldBlockGrid = new TileObject[floorGrid.length][floorGrid[0].length];
        
        for (int i = 0; i < floorGrid.length; i++) {
            for (int j= 0; j < floorGrid[0].length; j++) {
                oldFloorGrid[i][j] = floorGrid[i][j];
                oldBlockGrid[i][j] = blockGrid[i][j];
            }
        }
        
        previousMoves.push(oldFloorGrid);
        previousMoves.push(oldBlockGrid);
        
        // testing purposes
        for (int i = 0; i < previousMoves.size(); i++) {
            System.out.println(i+1 + ": " + previousMoves.get(i));
        }
        System.out.println();
    }
    
    public void removeUndo() {
        previousMoves.pop();
        previousMoves.pop();
    }
    
    public void undoMove() {
        if (previousMoves.empty()) {
            return;
        }
        TileObject[][] oldBlockGrid = previousMoves.pop();
        TileObject[][] oldFloorGrid = previousMoves.pop();
        
        
        
        for (int i = 0; i < floorGrid.length; i++) {
            for (int j= 0; j < floorGrid[0].length; j++) {
                
                floorGrid[i][j] = oldFloorGrid[i][j];
                blockGrid[i][j] = oldBlockGrid[i][j];
                if (floorGrid[i][j].getWorld() == null) {
                    addObject(floorGrid[i][j], 0, 0);
                }
                floorGrid[i][j].setX(j);
                floorGrid[i][j].setY(i);
                if (blockGrid[i][j] != null) {
                    if (blockGrid[i][j].getWorld() == null) {
                        addObject(blockGrid[i][j], 0, 0);
                    }
                    blockGrid[i][j].setX(j);
                    blockGrid[i][j].setY(i);
                }
                
            }
        }
    }
    
    public void finishLevel() {
        TravelButton levelSelect = new TravelButton(0, 300, 50, new GreenfootImage("images/ui/buttons/level_select1.png"));
        ActorImage victory = new ActorImage(new GreenfootImage("images/ui/menu/victory.png"));
        
        addObject(new Menu(400, 350), getWidth()/2, getHeight()/2);
        plr.toggleMovement();
        
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
