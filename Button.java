import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    private boolean hover = false;
    private boolean mouseDown = false;
    // This entire class is a work in progess
    
    public Button() {
        
    }
    
    
    public void act()
    {
        // Work in Progess
        // Should check if button is pressed and let go, if so call action
        // Addtionally should change when hovered and when pressed
        
        if (Greenfoot.mouseMoved(this)) {
            hover = true;
        } else if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this)) {
            hover = false;
            mouseDown = false;
        }
        
        
        if (Greenfoot.mousePressed(this)) {
            mouseDown = true;
        }
                                                                                                                                                                                                                                                                       
        if (Greenfoot.mouseClicked(this) && mouseDown) {
            System.out.println("b");
            mouseDown = false;
        }
    }
    
    public void action() {
        /*
         * Does nothing in the main class
         * Functionaltiy should be implemented in subclasses 
         */
    }
}
