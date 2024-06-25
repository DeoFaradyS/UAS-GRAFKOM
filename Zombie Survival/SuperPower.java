import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class SuperPower extends Actor
{
    final int superPowerLimit = 50;
    int superCount;
    int count;
    
    public SuperPower(){
        setImage(new GreenfootImage(superPowerLimit + 2, 12));
        getImage().drawRect(0, 0, superPowerLimit, 11);
        getImage().setColor(Color.BLUE);
        getImage().fillRect(1, 1, superCount, 10);
    }
    
    public void act()
    {
        setImage(new GreenfootImage(superPowerLimit + 2, 12));
        getImage().drawRect(0, 0, 51, 11);
        getImage().setColor(Color.BLUE);
        getImage().fillRect(1, 1, superCount, 10);
        
        updateLocation();
        useSuper();
    }
    
    private void updateLocation() {
        World world = getWorld();
        
        if (world instanceof MyWorld) {
            MyWorld myWorld = (MyWorld) world;
            setLocation(myWorld.getPlayer().getX() + 10, myWorld.getPlayer().getY() - 80);
        } else if (world instanceof World2) {
            World2 world2 = (World2) world;
            setLocation(world2.getPlayer().getX() + 10, world2.getPlayer().getY() - 80);
        } else if (world instanceof World3) {
            World3 world3 = (World3) world;
            setLocation(world3.getPlayer().getX() + 10, world3.getPlayer().getY() - 80);
        }
    }

    public void useSuper(){
        count++;
        
        if(count % 30 == 0){
            superCount++;
        }
    }
}
