import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class UndoButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UndoButton extends Button
{
    /**
     * Act - do whatever the UndoButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void action()
    {
        GameWorld world = (GameWorld) getWorld();
        world.undoMove();
    }
}
