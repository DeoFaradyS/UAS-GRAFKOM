import greenfoot.*;  

public class Counter extends Actor
{
    int score;
    int money;
    int time;
    int worldLevel;
    
    public Counter(){
        worldLevel = 1;
        setImage(new GreenfootImage("Score :" + score + "\n Cash :" + money + "\n Time : " + time/60, 40, Color.BLACK, new Color(0,0,0,0)));  
    }
    
    public void act()
    {
        time++;
        
        winScore();
        
        setImage(new GreenfootImage("Score :" + score + "\n Cash :" + money + "\n Time : " + time/60, 40, Color.BLACK, new Color(0,0,0,0)));  
    }
    
    public void winScore(){
        World world = getWorld();
        MyWorld myWorld = (MyWorld)world;
        if(worldLevel == 1 && score >= 1){
            Greenfoot.setWorld(new World2());
            worldLevel = 2;
            score = 0;
            money = 0;
            time = 0;
        } else if(worldLevel == 2 && score >= 3){
            Greenfoot.setWorld(new World3());
            worldLevel = 3;
            score = 0;
            money = 0;
            time = 0;
        }
    }
}