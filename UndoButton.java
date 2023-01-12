import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class UndoButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UndoButton extends Button
{
    public UndoButton(String image, int numStates) {
        super(image, numStates);
    }
    
    public void action()
    {
        GameWorld world = (GameWorld) getWorld();
        world.undoMove();
    }
}
