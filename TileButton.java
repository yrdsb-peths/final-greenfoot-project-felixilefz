import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TileButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TileButton extends Button
{
    private int i;
    private int j;
    private int scale;
    
    public TileButton(String image, int scale, int i, int j) {
        super(image, 1);
        getImage().scale(scale, scale);
        this.i = i;
        this.j = j;
        this.scale = scale;
    }
    
    /**
     * Deletes the menu on screen if there is one
     */
    public void action()
    {
        LevelCreator world = (LevelCreator) getWorld();
        
        String item = world.getItem();
        if (item == null) {
            return;
        }
        if (item.equals("delete")) {
            setImage("images/tile_basic_1.png");
            getImage().scale(scale, scale);
            CustomLevel.setBlock(i, j, null);
            CustomLevel.setFloor(i, j, null);
        } else if (item.equals("pushblock")) {
            setImage("images/push_block_1.png");
            getImage().scale(scale, scale);
            CustomLevel.setBlock(i, j, new PushBlock());
            CustomLevel.setFloor(i, j, null);
        } else if (item.equals("player")) {
            setImage("images/player_1.png");
            getImage().scale(scale, scale);
            CustomLevel.setBlock(i, j, new Player());
            CustomLevel.setFloor(i, j, null);
        } else if (item.equals("key")) {
            setImage("images/key_1.png");
            getImage().scale(scale, scale);
            CustomLevel.setBlock(i, j, new Key());
            CustomLevel.setFloor(i, j, null);
        } else if (item.equals("bomb")) {
            setImage("images/bomb_1.png");
            getImage().scale(scale, scale);
            CustomLevel.setBlock(i, j, new Bomb());
            CustomLevel.setFloor(i, j, null);
        } else if (item.equals("dynamite")) {
            setImage("images/dynamite_1.png");
            getImage().scale(scale, scale);
            CustomLevel.setBlock(i, j, new Dynamite());
            CustomLevel.setFloor(i, j, null);
        } else if (item.equals("door")) {
            setImage("images/door_1.png");
            getImage().scale(scale, scale);
            CustomLevel.setBlock(i, j, new Door());
            CustomLevel.setFloor(i, j, null);
        } else if (item.equals("wall")) {
            setImage("images/default_wall_1.png");
            getImage().scale(scale, scale);
            CustomLevel.setBlock(i, j, new Wall());
            CustomLevel.setFloor(i, j, null);
        } else if (item.equals("strongdoor")) {
            setImage("images/strong_door_1.png");
            getImage().scale(scale, scale);
            CustomLevel.setBlock(i, j, new StrongDoor());
            CustomLevel.setFloor(i, j, null);
        } else if (item.equals("strongwall")) {
            setImage("images/strong_wall_1.png");
            getImage().scale(scale, scale);
            CustomLevel.setBlock(i, j, new StrongWall());
            CustomLevel.setFloor(i, j, null);
        } else if (item.equals("water")) {
            setImage("images/water_1.png");
            getImage().scale(scale, scale);
            CustomLevel.setBlock(i, j, null);
            CustomLevel.setFloor(i, j, new Water());
        } else if (item.equals("ice")) {
            setImage("images/ice_tile_1.png");
            getImage().scale(scale, scale);
            CustomLevel.setBlock(i, j, null);
            CustomLevel.setFloor(i, j, new Ice());
        } else if (item.equals("finish")) {
            setImage("images/finish_tile_1.png");
            getImage().scale(scale, scale);
            CustomLevel.setBlock(i, j, new Finish());
            CustomLevel.setFloor(i, j, null);
        } 
    }
}
