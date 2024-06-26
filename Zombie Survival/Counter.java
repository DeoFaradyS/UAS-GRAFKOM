import greenfoot.*;  

public class Counter extends Actor
{
    int score;
    int money;
    int time;
    int worldLevel;
    World world;
    static Counter instance; // Menambahkan instance statis untuk memastikan Counter tidak dibuat ulang
    boolean isTransitioning = false; // Menambahkan flag untuk menandai transisi dunia

    public Counter(){
        if (instance == null) { // Hanya inisialisasi jika instance belum ada
            instance = this;
            worldLevel = 0; // Menginisialisasi worldLevel
            world = getWorld(); // Menginisialisasi field dunia
            setImage(new GreenfootImage("Score: " + score + "\n Cash: " + money + "\n Time: " + time/60, 40, Color.BLACK, new Color(0,0,0,0)));  
            // System.out.println("Initial World Level: " + worldLevel);
        } else {
            worldLevel = instance.worldLevel; // Gunakan nilai worldLevel dari instance yang ada
        }
    }

    public void act()
    {
        if (isTransitioning) return; // Menghentikan act sementara transisi dunia

        time++;
        
        winScore();
        
        setImage(new GreenfootImage("Score: " + score + "\n Cash: " + money + "\n Time: " + time/60, 40, Color.BLACK, new Color(0,0,0,0)));  
        
        // System.out.println("World Level in act: " + worldLevel);
    }

    public void winScore(){
        // System.out.println("Checking winScore: Score = " + score + ", World Level = " + worldLevel);
        if(score >= 30 && worldLevel == 0){
            showWinMessage();
            worldLevel = 1;
            instance.worldLevel = 1; // Simpan perubahan di instance statis
            Greenfoot.delay(100); // Memberikan jeda untuk melihat pesan
            world = new World2(); // Memperbarui field dunia
            Greenfoot.setWorld(world);
            resetStats();
            
            // System.out.println("World Level after changing to World2: " + worldLevel);
            return; // Menghentikan eksekusi setelah kondisi terpenuhi
            
        } else if(score >= 60 && worldLevel == 1){
            showWinMessage();
            worldLevel = 2;
            instance.worldLevel = 2; // Simpan perubahan di instance statis
            Greenfoot.delay(100); // Memberikan jeda untuk melihat pesan
            world = new World3(); // Memperbarui field dunia
            Greenfoot.setWorld(world);
            resetStats();
            
            // System.out.println("World Level after changing to World3: " + worldLevel);
            return; // Menghentikan eksekusi setelah kondisi terpenuhi
        }
    }   

    private void showWinMessage() {
        isTransitioning = true;
        getWorld().showText("You Win! Moving to the next world...", getWorld().getWidth() / 2, getWorld().getHeight() / 2);
    }

    private void resetStats() {
        score = 0;
        money = 0;
        time = 0;
        isTransitioning = false;
        // System.out.println("Stats reset: Score = " + score + ", Money = " + money + ", Time = " + time);
    }
}
