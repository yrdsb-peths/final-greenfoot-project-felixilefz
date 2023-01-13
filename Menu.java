import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Menu extends Actor
{
    private int itemOffSet;
    public Menu(int width, int height) {
        GreenfootImage image = new GreenfootImage("images/ui/menu/menu_background.png");
        image.scale(width, height);
        setImage(image);
        itemOffSet = 30;
    }
    
    public void addItem(Actor actor, double scale) {
        World world = getWorld();
        
        GreenfootImage actorImage = actor.getImage();
        
        int newWidth = (int) (getImage().getWidth()*scale);
        int newHeight = (int) (getImage().getWidth()*scale / actorImage.getWidth() * actorImage.getHeight()); 
        actorImage.scale(newWidth, newHeight);
        actorImage.scale(newWidth, newHeight);
        
        if (actor instanceof Button) {
            ((Button) actor).setScale(newWidth, newHeight);
        }
        
        world.addObject(actor, getX(), getY() - getImage().getHeight()/2 + itemOffSet);
        itemOffSet += actor.getImage().getHeight() + 5;
    }
}
