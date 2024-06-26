import greenfoot.*;

public class Enemy extends Actor
{
    int animateImage = 0;
    int animateSpeed = 5;
    int count;
    int health = 2;
    
    Player player;
    Counter counter;
    
    public Enemy(Player mainPlayer, Counter counter){
        this.counter = counter;
        player = mainPlayer;
        setImage("skeleton-idle_16.png");
        getImage().scale(80,80);
    }
    
    public void act()
    {
        count++;
        animate();
        moveAround();
        hitByProjectile();
    }
    
    // animate
    public void animate(){
        if(count % animateSpeed == 0){
            setImage("skeleton-move_" + animateImage + ".png");
            animateImage++;
            getImage().scale(80,80);
            
            if(animateImage > 15){
                animateImage = 0;
            }
        }
    }
    
    public void moveAround(){
        move(1);
        turnTowards(player.getX(), player.getX());
    }
    
    public void hitByProjectile(){
        Actor projectile = getOneIntersectingObject(Projectile.class);
        
        if(projectile != null){
            health--;
            getWorld().removeObject(projectile);
        }
        
        if (health == 0){
            counter.score++;
            counter.money+=5;
            getWorld().removeObject(this);
        }
    }
}
