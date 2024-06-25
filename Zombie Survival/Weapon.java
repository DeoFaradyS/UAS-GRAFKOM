import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Weapon extends Actor
{
    Counter counter;
    
    int weaponUpgrade = 1;
    int upgradeCost = 50;
    GreenfootImage upgradeButton;
    GreenfootImage normalImage;
    GreenfootImage maxLevelImage;
    
    public Weapon(Counter counter){
        this.counter = counter;
        normalImage = new GreenfootImage("Weapon (" + weaponUpgrade + ")", 25, Color.BLACK, new Color(0,0,0,0));
        upgradeButton = new GreenfootImage("Upgrade Weapon!", 25, Color.RED, new Color(0,0,0,0));
        maxLevelImage = new GreenfootImage("Weapon Maks", 25, Color.BLUE, new Color(0,0,0,0));
        setImage(normalImage);
    }
    
    public void act()
    {
        if(counter.money >= upgradeCost && weaponUpgrade < 3){
            setImage(upgradeButton);
        } else if(weaponUpgrade == 3){
            setImage(maxLevelImage);
        } else {
            setImage(normalImage);
        }
        
        if(Greenfoot.mousePressed(this) && counter.money >= upgradeCost && weaponUpgrade < 3){
            counter.money -= upgradeCost;
            weaponUpgrade++;
            upgradeCost += 25; // increase the upgrade cost by 25 each time
            setImage(normalImage);
        }
    }
}