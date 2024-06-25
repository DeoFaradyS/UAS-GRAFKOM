import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Projectile extends Actor
{
    public Projectile(){
        setImage(new GreenfootImage(5,5));
        getImage().setColor(Color.RED);
        getImage().fillRect(0,0,5,5);
    }
    
    public void act()
    {
        move(10);
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
    }
}
