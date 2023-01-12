import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Menu extends Actor
{
    private int totalItems;
    public Menu(int width, int height) {
        GreenfootImage image = new GreenfootImage("images/ui/menu/menu_background.png");
        image.scale(width, height);
        setImage(image);
        totalItems = 0;
    }
    
    public void addItem(Actor actor) {
        totalItems += 1;
        
    }
}
