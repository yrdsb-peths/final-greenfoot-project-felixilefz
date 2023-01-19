import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math.*;
import java.util.*;
/**
 * The main world where most of the gameplay is
 * The subclass's set the level layout
 * While this class displays the layout
 * 
 * @author Felix Zhao
 * @version 1/18/2023
 */
public class GameWorld extends World
{
    private static GreenfootSound winEffect = new GreenfootSound("sounds/win_sound.mp3");
    private static int highestCompletedLevel = 0;
    private int scale;
    private int width;
    private int height;
    private TileObject[][] floorGrid; 
    private TileObject[][] blockGrid;
    private Stack<TileObject[][]> previousMoves = new Stack<>();
    private ArrayList<Actor> menuAssets = new ArrayList<>();
    private Player plr;
    private int level;
    private SimpleTimer gameTimer;
    private int totalMoves;
    private int totalTime;
    
    /**
     * Creates a world that the user plays in. Takes the layout from its subclasses
     * @param floorPlan what  and where the floor will be
     * @param blockPlan what and where the blocks will be
     * @param level the current level the layout is
     */
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
        
        gameTimer = new SimpleTimer();
        totalMoves = 0;
        totalTime = 0;
        
        scale = Math.min(getWidth() / (width), getHeight() / (height)); 
        
        createBase();
        setPaintOrder(ActorImage.class, Button.class, Label.class, Menu.class, Player.class, Particles.class, PushBlock.class, Wall.class, Finish.class, Water.class, Floor.class);
        
    }
    
    /**
     * Takes the layout given and adds the tiles to the world
     */
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
                        plr.movementOn();
                    }
                } 
                
            }
        }
       
    }
    
    /**
     * Is activated when the player moves.Stores the world before the movement
     * Only stores up to the last 10 moves
     */
    public void playerMoved() {
        int prevMovesSize = previousMoves.size();
        totalMoves ++;
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
    }
    
    /**
     * Removes the most recently added moves
     */
    public void removeUndo() {
        // Is needed because of how pushing is calcuated
        totalMoves --;
        previousMoves.pop();
        previousMoves.pop();
    }
    
    /**
     * Undos the most recent move if there is one
     */
    public void undoMove() {
        if (previousMoves.empty()) {
            return;
        }
        TileObject[][] oldBlockGrid = previousMoves.pop();
        TileObject[][] oldFloorGrid = previousMoves.pop();
        totalMoves --;
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
    
    // Menu related methods
    
    /**
     * Creates a victory menu when the player reaches the goal
     * The menu has a victory title and 3 buttons, level select, restart and next level
     * It also displays the player's grade which is determined by the moves and amount of time they took
     * Also Stops the player's movement
     */
    public void finishLevel() {
        winEffect.play();
        
        TravelButton levelSelect = new TravelButton(-2, "images/ui/buttons/level_select", 3);
        TravelButton nextLevel = new TravelButton(level+1, "images/ui/buttons/next_level", 3);
        TravelButton restart = new TravelButton(level, "images/ui/buttons/restart_level", 3);
        ActorImage victory = new ActorImage(new GreenfootImage("images/ui/menu/victory.png"));
        
        Menu menu = new Menu(400, 350);
        addObject(menu, getWidth()/2, getHeight()/2);
        plr.movementOff();
        menu.addItem(victory, 0.7);
        menu.addItem(nextLevel, 0.5);
        menu.addItem(levelSelect, 0.5);
        menu.addItem(restart, 0.5);
        menuAssets.add(levelSelect);
        menuAssets.add(nextLevel);
        menuAssets.add(restart);
        menuAssets.add(victory);
        menuAssets.add(menu);
        
        if (highestCompletedLevel < level) {
            highestCompletedLevel = level;
        }
        
        totalTime += gameTimer.millisElapsed();
        
        int timeGrade = totalTime - getOwnerTime();
        int moveGrade = totalMoves - getOwnerMoves(); 
        int overallGrade = 100;
        
        if (moveGrade >= 2) {
            overallGrade /= moveGrade;
        } else if (moveGrade <= -2) {
            overallGrade *= Math.abs(moveGrade);
        }
        overallGrade -= timeGrade / 1000;
        Label grade = new Label("Grade: " + overallGrade, 40);
        menu.addItem(grade, 0);
        menuAssets.add(grade);
    }
    
    /**
     * Creates a death menu when the player dies
     * The menu has a dead title and 3 buttons, level select, restart and undo move
     * Also Stops the player's movement
     */
    public void lostLevel() {
        TravelButton levelSelect = new TravelButton(-2, "images/ui/buttons/level_select", 3);
        TravelButton restart = new TravelButton(level, "images/ui/buttons/restart_level", 3);
        UndoButton undo = new UndoButton("images/ui/buttons/undo_move", 3);
        ActorImage dead = new ActorImage(new GreenfootImage("images/ui/menu/dead.png"));
        
        Menu menu = new Menu(400, 350);
        addObject(menu, getWidth()/2, getHeight()/2);
        plr.movementOff();
        menu.addItem(dead, 0.7);
        menu.addItem(undo, 0.5);
        menu.addItem(levelSelect, 0.5);
        menu.addItem(restart, 0.5);
        menuAssets.add(levelSelect);
        menuAssets.add(undo);
        menuAssets.add(restart);
        menuAssets.add(dead);
        menuAssets.add(menu);
        totalTime += gameTimer.millisElapsed();
    }
    
    /**
     * Creates a pause menu when the player presses escape
     * The menu has a pause title and 3 buttons, level select, restart and back (brings user back to the level)
     * Also Stops the player's movement
     */
    public void pauseLevel() {
        TravelButton levelSelect = new TravelButton(-2, "images/ui/buttons/level_select", 3);
        TravelButton restart = new TravelButton(level, "images/ui/buttons/restart_level", 3);
        BackButton backToLevel = new BackButton("images/ui/buttons/back_to_level", 3);
        ActorImage pause = new ActorImage(new GreenfootImage("images/ui/menu/paused.png"));
        
        Menu menu = new Menu(400, 350);
        addObject(menu, getWidth()/2, getHeight()/2);
        plr.movementOff();
        menu.addItem(pause, 0.7);
        menu.addItem(levelSelect, 0.5);
        menu.addItem(restart, 0.5);
        menu.addItem(backToLevel, 0.5);
        menuAssets.add(levelSelect);
        menuAssets.add(restart);
        menuAssets.add(pause);
        menuAssets.add(menu);
        menuAssets.add(backToLevel);
        
        totalTime += gameTimer.millisElapsed();
    }
    
    /**
     * Removes all menu assets
     * Allows the player to move again
     */
    public void removeMenuAssets() {
        for (int i = 0; i < menuAssets.size(); i++) {
            removeObject(menuAssets.get(i));
        }
        plr.movementOn();
        gameTimer.mark();
    }
    
    //Getters and Setters
    /**
     * @return the highest level the player has completed
     */
    public static int getHighestLevel() {
        return highestCompletedLevel;
    }
    
    /**
     * @return how many tiles long the world is
     */
    public int getGridWidth() {
        return width;
    }
    
    /**
     * @return how many tiles tall the world is
     */
    public int getGridHeight() {
        return height;
    }
    
    /**
     * @return the floor at the given x and y value
     */
    public TileObject getFloorAt(int x, int y) {
        return floorGrid[y][x];
    }
    
    /**
     * @return the block at the given x and y value
     */
    public TileObject getBlockAt(int x, int y) {
        return blockGrid[y][x];
    }
    
    /**
     * removes the block at the given x and y value
     */
    public void removeBlock(int x, int y) {
        blockGrid[y][x] = null;
    }
    
    /**
     * replaces the block at the given x and y value
     */
    public void replaceBlock(int x, int y, TileObject block) {
        blockGrid[y][x] = block;
    }
    
    /**
     * removes the floor at the given x and y value
     */
    public void removeFloor(int x, int y) {
        floorGrid[y][x] = null;
    }
    
    /**
     * replaces the floor at the given x and y value
     */
    public void replaceFloor(int x, int y, TileObject floor) {
        floorGrid[y][x] = floor;
    }
    
    // These are base times if for some reason there is none in any on the child class
    
    /**
     * Should be in the subclasses, 1000000 is the default time
     * @return The owner's time for a level to calculate score
     */
    public int getOwnerTime() {
        return 1000000;
    }
    
    /**
     * Should be in the subclasses, 100 is the default moves
     * @return The owner's moves for a level to calculate score
     */    
    public int getOwnerMoves() {
        return 100;
    }
}
