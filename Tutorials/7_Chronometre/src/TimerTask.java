import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class TimerTask extends BukkitRunnable {
    
    private int timer = 10;

    @Override
    public void run()
    {
        Bukkit.broadcastMessage("Temps restant : " + timer + " secondes");
        
        if(timer == 0)
        {
            Bukkit.broadcastMessage("Le temps est écoulé !");
            cancel();
        }
        
        timer--;
    }

}
