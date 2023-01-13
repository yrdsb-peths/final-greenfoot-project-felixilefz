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
    protected GreenfootImage[] imageStates;
    // This entire class is a work in progess
    
    public Button(String imagePath, int numStates) {
        GreenfootImage image = new GreenfootImage(imagePath + "_1.png");
        setImage(image);
        imageStates = new GreenfootImage[numStates];
        imageStates[0] = image;
        
        for (int i = 1; i < numStates; i++) {
            imageStates[i] = new GreenfootImage(imagePath + "_" + (i+1) + ".png");
        }
    }
    
    
    public void act()
    {
        // Work in Progess
        // Should check if button is pressed and let go, if so call action
        // Addtionally should change when hovered and when pressed
        
        if (Greenfoot.mouseMoved(this)) {
            hover = true;
            if (imageStates.length > 1) {
                setImage(imageStates[1]);
            }
        } else if (Greenfoot.mouseMoved(null)) {
            hover = false;
            mouseDown = false;
            setImage(imageStates[0]);
        }
        
        if (Greenfoot.mousePressed(this) && !mouseDown) {
            mouseDown = true;
            if (imageStates.length > 2) {
                setImage(imageStates[2]);
            }
        }
                                                                                                                                                                                                                                                                       
        if (Greenfoot.mouseClicked(this) && mouseDown) {
            action();
            mouseDown = false;
            setImage(imageStates[0]);
        } else if (Greenfoot.mouseClicked(null)) {
            mouseDown = false;
            setImage(imageStates[0]);
        }
    }
    
    public void setScale(int width, int height) {
        for (int i = 0; i < imageStates.length; i++) {
            imageStates[i].scale(width, height);
        }
    }
    
    public void action() {
        /*
         * Does nothing in the main class
         * Functionaltiy should be implemented in subclasses 
         */
    }
}
