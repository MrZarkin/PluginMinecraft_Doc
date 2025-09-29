import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
{
	@Override
	public void onEnable()
	{
		System.out.println("Le plugin viens de s'allumer");
		getCommand("test").setExecutor(new CommandLoader());
		getCommand("hello").setExecutor(new CommandLoader());
		getServer().getPluginManager().registerEvents(new MonPluginListeners(), this);
	}
	
	@Override
	public void onDisable()
	{
		System.out.println("Le plugin viens de d'éteindre");
	}
}