import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
{
	@Override
	public void onEnable()
	{
		saveDefaultConfig();

		System.out.println("Le plugin viens de s'allumer");
		getCommand("test").setExecutor(new CommandLoader(this));
		getCommand("hello").setExecutor(new CommandLoader(this));
		getCommand("spawn").setExecutor(new CommandSpawn());
		getServer().getPluginManager().registerEvents(new MonPluginListeners(), this);

		for(String string : getConfig().getConfigurationSection("kits").getKeys(false))
		{
			System.out.println(getConfig().getConfigurationSection("kits").getInt(string + ".id")); // Permet d'afficher l'id de chaque kit
		}

		for(String string : getConfig().getStringList("badwords"))
		{
			System.out.println(string); // Permet d'afficher chaque mot de la liste
		}

		TimerTask task = new TimerTask();
		task.runTaskTimer(this, 0, 20); // 20 ticks = 1 seconde
	}
	
	@Override
	public void onDisable()
	{
		System.out.println("Le plugin viens de d'éteindre");
	}
}