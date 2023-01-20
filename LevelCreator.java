import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The place where you can edit your custom level
 * 
 * @author Felix Zhao 
 * @version 1/19/2023
 */
public class LevelCreator extends World
{

    String itemSelected;
    /**
     * Sets the place to be able to work on the custom level
     */
    public LevelCreator()
    {    
        super(600, 400, 1); 
        
        addObject(new TravelButton("createmenu", 96, 32, "images/ui/buttons/back_to_level", 3), 50, 25);
        addObject(new SelectItemButton("images/ui/buttons/delete_tiles", "delete", 50), 25, 75);
        addObject(new SelectItemButton("images/player", "player", 50), 25, 125);
        addObject(new SelectItemButton("images/push_block", "pushblock", 50), 75, 125);
        addObject(new SelectItemButton("images/key", "key", 50), 25, 175);
        addObject(new SelectItemButton("images/bomb", "bomb", 50), 75, 175);
        addObject(new SelectItemButton("images/dynamite", "dynamite", 50), 25, 225);
        addObject(new SelectItemButton("images/door", "door", 50), 75, 225);
        addObject(new SelectItemButton("images/default_wall", "wall", 50), 25, 275);
        addObject(new SelectItemButton("images/strong_door", "strongdoor", 50), 75, 275);
        addObject(new SelectItemButton("images/strong_wall", "strongwall", 50), 25, 325);
        addObject(new SelectItemButton("images/finish_tile", "finish", 50), 75, 325);
        addObject(new SelectItemButton("images/water", "water", 50), 25, 375);
        addObject(new SelectItemButton("images/ice_tile", "ice", 50), 75, 375);
        
        int x = 120;
        int y = 20;
        TileObject[][] blockPlan = CustomLevel.getBlockPlan();
        TileObject[][] floorPlan = CustomLevel.getFloorPlan();
        for (int i = 0; i < blockPlan.length; i++) {
            x = 120;
            for (int j = 0; j < blockPlan[0].length; j++) {
                if (blockPlan[i][j] == null && floorPlan[i][j] == null) {
                    addObject(new TileButton("images/tile_basic", 40, i, j), x, y);
                }
                
                if (blockPlan[i][j] instanceof Player) {
                    addObject(new TileButton("images/player", 40, i, j), x, y);
                } else if (blockPlan[i][j] instanceof Key) {
                    addObject(new TileButton("images/key", 40, i, j), x, y);
                } else if (blockPlan[i][j] instanceof Bomb) {
                    addObject(new TileButton("images/bomb", 40, i, j), x, y);
                } else if (blockPlan[i][j] instanceof Dynamite) {
                    addObject(new TileButton("images/dynamite", 40, i, j), x, y);
                } else if (blockPlan[i][j] instanceof StrongDoor) {
                    addObject(new TileButton("images/strong_door", 40, i, j), x, y);
                } else if (blockPlan[i][j] instanceof Door) {
                    addObject(new TileButton("images/door", 40, i, j), x, y);
                } else if (blockPlan[i][j] instanceof StrongWall) {
                    addObject(new TileButton("images/strong_wall", 40, i, j), x, y);
                } else if (blockPlan[i][j] instanceof Finish) {
                    addObject(new TileButton("images/finish_tile", 40, i, j), x, y);
                } else if (floorPlan[i][j] instanceof Water) {
                    addObject(new TileButton("images/water", 40, i, j), x, y);
                } else if (floorPlan[i][j] instanceof Ice) {
                    addObject(new TileButton("images/ice_tile", 40, i, j), x, y);
                } else if (blockPlan[i][j] instanceof Wall) {
                    addObject(new TileButton("images/default_wall", 40, i, j), x, y);
                } else if (blockPlan[i][j] instanceof PushBlock) {
                    addObject(new TileButton("images/push_block", 40, i, j), x, y);
                }
                x += 40;
            }
            y += 40;
        }
    }
    
    /**
     * Sets the selected item to be placed
     */
    public void setItem(String item) {
        itemSelected = item;
    }
    
    /**
     * @return the selected item to be placed
     */
    public String getItem() {
        return itemSelected;
    }
}
