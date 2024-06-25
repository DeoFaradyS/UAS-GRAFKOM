import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Player extends Actor
{
    int speed = 3;
    int time = 0;
    int superTimer;
    
    Weapon weapon;
    SuperPower superPower;
    
    public Player(){
        setImage(new GreenfootImage(70,50));
        getImage().setColor(Color.YELLOW);
        getImage().fillOval(0,0,50,50);
        getImage().setColor(Color.BLACK);
        getImage().fillRect(50, 20, 70, 10);
    }
    
    public Player(Weapon weapon, SuperPower superPower){
        this.superPower = superPower;
        this.weapon = weapon;
        setImage(new GreenfootImage(70,50));
        getImage().setColor(Color.YELLOW);
        getImage().fillOval(0,0,50,50);
        getImage().setColor(Color.BLACK);
        getImage().fillRect(50, 20, 70, 10);
    }
    
    public void act()
    {
        time++;
        turnAround();
        moveAround();
        fireProjectile();
        superPowerUsed();
        hitByEnemy();
    }
    
    public void turnAround(){
        if (Greenfoot.getMouseInfo() != null){
            turnTowards(Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());
        }
    }
    
    public void moveAround(){
        if (Greenfoot.isKeyDown("w")){
            setLocation(getX(), getY()-speed);
        }
        
        if (Greenfoot.isKeyDown("a")){
            setLocation(getX() - speed, getY());
        }
        
        if (Greenfoot.isKeyDown("s")){
            setLocation(getX(), getY() + speed);
        }
        
        if (Greenfoot.isKeyDown("d")){
            setLocation(getX() + speed, getY());
        }
    }
    
    public void fireProjectile(){
        if (Greenfoot.mousePressed(null) && weapon.weaponUpgrade == 1){
            Projectile projectile = new Projectile();
            getWorld().addObject(projectile, getX(), getY());
            projectile.setRotation(getRotation());
            projectile.move(25);
        }
        
        if (Greenfoot.mousePressed(null) && weapon.weaponUpgrade == 2){
            Projectile projectile = new Projectile();
            getWorld().addObject(projectile, getX(), getY());
            projectile.setRotation(getRotation() - 5);
            projectile.move(25);
            
            Projectile projectile2 = new Projectile();
            getWorld().addObject(projectile2, getX(), getY());
            projectile2.setRotation(getRotation() + 5);
            projectile2.move(25);
        }
        
        if (Greenfoot.mousePressed(null) && weapon.weaponUpgrade == 3){
            Projectile projectile = new Projectile();
            getWorld().addObject(projectile, getX(), getY());
            projectile.setRotation(getRotation() - 10);
            projectile.move(25);
            
            Projectile projectile2 = new Projectile();
            getWorld().addObject(projectile2, getX(), getY());
            projectile2.setRotation(getRotation() + 10);
            projectile2.move(25);
            
            Projectile projectile3 = new Projectile();
            getWorld().addObject(projectile3, getX(), getY());
            projectile3.setRotation(getRotation());
            projectile3.move(25);
        }
    }
    
    public void superPowerUsed(){
        if(superPower.superCount > 49 && superTimer < 20){
            superTimer++;
            
            Projectile projectile = new Projectile();
            getWorld().addObject(projectile, getX(), getY());
            projectile.setRotation(getRotation() - 60);
            projectile.move(25);
            
            Projectile projectile2 = new Projectile();
            getWorld().addObject(projectile2, getX(), getY());
            projectile2.setRotation(getRotation() + 60);
            projectile2.move(25);
            
            Projectile projectile3 = new Projectile();
            getWorld().addObject(projectile3, getX(), getY());
            projectile3.setRotation(getRotation());
            projectile3.move(25);
            
            Projectile projectile4 = new Projectile();
            getWorld().addObject(projectile4, getX(), getY());
            projectile4.setRotation(getRotation() - 180);
            projectile4.move(25);
            
            Projectile projectile5 = new Projectile();
            getWorld().addObject(projectile5, getX(), getY());
            projectile5.setRotation(getRotation() + 120);
            projectile5.move(25);
            
            Projectile projectile6 = new Projectile();
            getWorld().addObject(projectile6, getX(), getY());
            projectile6.setRotation(getRotation() - 120);
            projectile6.move(25);
        }
        
        if(superTimer > 19){
            superPower.superCount = 0;
            superTimer = 0;
        }
    }
    
    public boolean hitByEnemy(){
        Actor enemy = getOneObjectAtOffset(0, 0, Enemy.class);
        
        if(enemy != null){
            return true;
        } else{
            return false;
        }
    }
}
