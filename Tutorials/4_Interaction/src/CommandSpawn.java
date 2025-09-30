import java.util.Random;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSpawn implements CommandExecutor 
{
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if(sender instanceof Player)
        {
            Random random = new Random();
            Player player = (Player)sender;
            Location ploc = player.getLocation();

            Location spawn = new Location(player.getWorld(), ploc.getX(), ploc.getY() + random.nextInt(50), ploc.getZ(), 1.8f, 70f); // Coordonnées du spawn (x, y, z, yaw, pitch). Peut être remplacer par des entiers pour une téléportation précise.
            player.sendMessage("§aTéléportation au spawn...");
            player.teleport(spawn);
        }
        return false;
    }
}
