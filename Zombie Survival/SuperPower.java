import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class SuperPower extends Actor
{
    final int superPowerLimit = 50;
    int superCount;
    int count;
    
    public SuperPower(){
        setImage(new GreenfootImage(superPowerLimit + 2,12));
        getImage().drawRect(0,0,superPowerLimit,11);
        getImage().setColor(Color.BLUE);
        getImage().fillRect(1,1,superCount,10);
    }
    
    public void act()
    {
        setImage(new GreenfootImage(superPowerLimit + 2,12));
        getImage().drawRect(0,0,51,11);
        getImage().setColor(Color.BLUE);
        getImage().fillRect(1,1,superCount,10);
        
        World world = getWorld();
        MyWorld myWorld = (MyWorld)world;
        
        setLocation(myWorld.getPlayer().getX() + 10, myWorld.getPlayer().getY() - 80);
        useSuper();
    }
    
    public void useSuper(){
        count++;
        
        if(count % 30 == 0){
            superCount++;
        }

    }
}
