import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class HealthBar extends Actor
{
    int health = 50;

    public HealthBar(){
        setImage(new GreenfootImage(52, 12));
        getImage().drawRect(0, 0, 51, 11);
        getImage().setColor(Color.RED);
        getImage().fillRect(1, 1, health, 10);
    }

    public void act()
    {
        setImage(new GreenfootImage(52, 12));
        getImage().drawRect(0, 0, 51, 11);
        getImage().setColor(Color.RED);
        getImage().fillRect(1, 1, health, 10);
        
        updateLocation();
        loseHealth();
    }

    private void updateLocation() {
        World world = getWorld();
        
        if (world instanceof MyWorld) {
            MyWorld myWorld = (MyWorld) world;
            setLocation(myWorld.getPlayer().getX() - 5, myWorld.getPlayer().getY() - 50);
        } else if (world instanceof World2) {
            World2 world2 = (World2) world;
            setLocation(world2.getPlayer().getX() - 5, world2.getPlayer().getY() - 50);
        } else if (world instanceof World3) {
            World3 world3 = (World3) world;
            setLocation(world3.getPlayer().getX() - 5, world3.getPlayer().getY() - 50);
        }
    }

    public void loseHealth(){
        World world = getWorld();
        Player player = null;
        Counter counter = null;
        
        if (world instanceof MyWorld) {
            player = ((MyWorld) world).getPlayer();
            counter = ((MyWorld) world).getCounter();
        } else if (world instanceof World2) {
            player = ((World2) world).getPlayer();
            counter = ((World2) world).getCounter();
        } else if (world instanceof World3) {
            player = ((World3) world).getPlayer();
            counter = ((World3) world).getCounter();
        }

        if (player != null && player.hitByEnemy()) {
            health--;
        }

        if (health <= 0 && counter != null){
            getWorld().showText("You Lose\n You survived for " + (counter.time/60) + " seconds", getWorld().getWidth()/2, getWorld().getHeight()/2);
            Greenfoot.stop();
        }
    }
}
