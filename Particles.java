import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Particles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Particles extends Actor
{
    private List<GreenfootImage> images;
    private int animationNumber;
    private int duration; // Total amount of ticks
    private int time;
    
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
    
    public void act() {
        if (time >= duration) {
            // destory this object
        }
        
        if (time % 20 == 0) {
            setImage(images.get(animationNumber));
            animationNumber = (animationNumber + 1) % images.size();
        }
        time ++;
    }
}
