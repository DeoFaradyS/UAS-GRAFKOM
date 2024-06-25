import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class World2 extends World
{
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 650;
    private static final int CELL_SIZE = 1;

    private Player player;
    private Counter counter;
    private HealthBar healthBar;
    private Weapon weapon;
    private SuperPower superPower;
    private Title title;

    public World2()
    {
        super(WIDTH, HEIGHT, CELL_SIZE);

        initGameObjects();
    }

    private void initGameObjects()
    {
        player = new Player(new Weapon(new Counter()), new SuperPower());
        counter = new Counter();
        healthBar = new HealthBar();
        weapon = new Weapon(counter);
        superPower = new SuperPower();
        title = new Title("Stage 2: Target 100");

        addObject(player, getWidth() / 2, getHeight() / 2);
        addObject(counter, 130, 100);
        addObject(healthBar, player.getX() - 5, player.getY() - 50);
        addObject(weapon, 850, 100);
        addObject(superPower, player.getX() + 10, player.getY() - 80);
        addObject(title, getWidth() / 2, 50);
    }
}