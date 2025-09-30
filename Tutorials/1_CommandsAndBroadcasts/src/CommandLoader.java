import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandLoader implements CommandExecutor 
{
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args)
	{
		if(sender instanceof Player)
		{
			Player player = (Player)sender;
			
			if(cmd.getName().equalsIgnoreCase("test"))
			{
				player.sendMessage("§4Checked");
				return true;
			}
			
			if(cmd.getName().equalsIgnoreCase("hello"))
			{
				// hello --> aucun arguments
				if(args.length == 0)
				{
					player.sendMessage("/hello <message>");
				}
				
				if(args.length >= 1)
				{
					StringBuilder bc = new StringBuilder();
					for(String part : args)
					{
						bc.append(part + " ");
					}
					
					Bukkit.broadcastMessage("[" + player.getName() + "] " + bc.toString());
				}
				return true;
			}
		}
		return false;
	}
}