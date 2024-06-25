import greenfoot.*;  

public class Counter extends Actor
{
    int score;
    int money;
    int time;
    int worldLevel;

    public Counter(){
        worldLevel = 1;
        setImage(new GreenfootImage("Score: " + score + "\n Cash: " + money + "\n Time: " + time/60, 40, Color.BLACK, new Color(0,0,0,0)));  
    }

    public void act()
    {
        time++;
        
        winScore();
        
        setImage(new GreenfootImage("Score: " + score + "\n Cash: " + money + "\n Time: " + time/60, 40, Color.BLACK, new Color(0,0,0,0)));  
    }

    public void winScore(){
        World world = getWorld();
        
        if(worldLevel == 1 && score >= 5){
            if(world instanceof MyWorld){
                worldLevel = 2;
                Greenfoot.setWorld(new World2());
                resetStats(); // Reset stats after setting the world
            }
        } else if(worldLevel == 2 && score >= 10){
            if(world instanceof World2){
                worldLevel = 3;
                Greenfoot.setWorld(new World3());
                resetStats(); // Reset stats after setting the world
            }
        }
    }

    private void resetStats() {
        score = 0;
        money = 0;
        time = 0;
    }
}
