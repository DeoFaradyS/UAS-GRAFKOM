import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class World3 extends World
{
    int count = 0;
    int spawnSpeed = 20; // faster spawn rate than World2
    int randomSpawn;

    public Player mainPlayer;
    Counter counter;
    HealthBar healthbar;
    Weapon weapon;
    SuperPower superPower;
    Title title;
    
    public World3()
    {    
        // Create a new world with 1000x650 cells with a cell size of 1x1 pixels.
        super(1000, 650, 1);
        
        mainPlayer = new Player();
        counter = new Counter();
        healthbar = new HealthBar();
        weapon = new Weapon(counter);
        superPower = new SuperPower();
        title = new Title("Stage 3: Unlimited Mode");
        
        mainPlayer = new Player(weapon, superPower);
        
        addObject(mainPlayer, getWidth()/2, getHeight()/2);
        addObject(counter, 130, 100);
        addObject(healthbar, mainPlayer.getX()-5, mainPlayer.getY()-50);
        addObject(weapon, 850, 100);
        addObject(superPower, mainPlayer.getX() + 10, mainPlayer.getY() - 80);
        addObject(title, getWidth()/2, 50); // add the title to the top center of the screen
    }

    public Counter getCounter() {
        return counter;
    }
    
    public Player getPlayer(){
        return mainPlayer;
    }
    
    public void act(){
        count++;
        spawnEnemy();
        
        // Update the positions of healthbar and superPower according to the player's position
        healthbar.setLocation(mainPlayer.getX()-5, mainPlayer.getY()-50);
        superPower.setLocation(mainPlayer.getX() + 10, mainPlayer.getY() - 80);

        while(Greenfoot.isKeyDown("p")){
            Greenfoot.delay(1);
        }
    }
    
    public void spawnEnemy(){
        if(count % spawnSpeed == 0){
            randomSpawn  = Greenfoot.getRandomNumber(8);
            
            switch(randomSpawn){
                case 0: 
                    addObject(new Enemy(mainPlayer, counter), 0, 0);
                    break;
                case 1: 
                    addObject(new Enemy(mainPlayer, counter), getWidth()/2, 0);
                    break;
                case 2: 
                    addObject(new Enemy(mainPlayer, counter), getWidth(), 0);
                    break;
                case 3: 
                    addObject(new Enemy(mainPlayer, counter), 0, getHeight()/2);
                    break;
                case 4: 
                    addObject(new Enemy(mainPlayer, counter), getWidth(), getHeight()/2);
                    break;
                case 5: 
                    addObject(new Enemy(mainPlayer, counter), 0, getHeight());
                    break;
                case 6: 
                    addObject(new Enemy(mainPlayer, counter), getWidth()/2, getHeight());
                    break;
                case 7: 
                    addObject(new Enemy(mainPlayer, counter), getWidth(), getHeight());
                    break;
            }
        }
    }
}
