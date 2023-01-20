import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Spawns particles that last for any set duration
 * 
 * @author Felix Zhao
 * @version 1/18/2023
 */
public class Particles extends Actor
{
    private List<GreenfootImage> images;
    private int animationNumber;
    private int duration; // Total amount of ticks
    private int time;
    
    /**
     * Creates a particle by width by height with an animation
     * @param duration how long the particle will last in # of game loops
     * @param gifPath the path where the animation is
     * @param width the width of the particle
     * @param height the height of the particle
     */
    public Particles(int duration, String gifPath, int width, int height) {
        GifImage animation = new GifImage(gifPath);
        images = animation.getImages();
        this.duration = duration;
        time = 0;
        animationNumber = 0;
        for (int i = 0; i < images.size(); i++) {
            images.get(i).scale(width, height);
        }
        setImage(images.get(0));
    }
    /**
     * Creates a particle with no animation. Used for pop-up text
     * @param duration the duration the particle will last in # of game loops
     */
    public Particles(int duration, GreenfootImage image) {
        setImage(image);
        this.duration = duration;
        time = 0;
    }
    
    /**
     * Runs every game loop and changes animation if needed
     * Also deletes the particle if the time has surpassed the duration
     */
    public void act() {
        World world = getWorld();
        if (time >= duration) {
            world.removeObject(this);
        }
        
        if (time % 20 == 0) {
            if (images != null) {
                setImage(images.get(animationNumber));
                animationNumber = (animationNumber + 1) % images.size();
            }
        }
        time ++;
    }
}
