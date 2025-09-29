# Main.java
```diff
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
{
	@Override
	public void onEnable()
	{
		System.out.println("Le plugin viens de s'allumer");
		getCommand("test").setExecutor(new CommandLoader());
		getCommand("hello").setExecutor(new CommandLoader());
+		getServer().getPluginManager().registerEvents(new MonPluginListeners(), this);
	}
	
	@Override
	public void onDisable()
	{
		System.out.println("Le plugin viens de d'éteindre");
	}
}
```

# MonPluginListeners.java
```diff
+import java.util.Arrays;

+import org.bukkit.event.EventHandler;
+import org.bukkit.enchantments.Enchantment;
+import org.bukkit.event.Listener;
+import org.bukkit.event.player.PlayerJoinEvent;
+import org.bukkit.entity.Player;
+import org.bukkit.inventory.ItemStack;
+import org.bukkit.inventory.ItemFlag;
+import org.bukkit.inventory.meta.ItemMeta;
+import org.bukkit.Material;

+public class MonPluginListeners implements Listener 
+{
+    @EventHandler
+    public void onJoin(PlayerJoinEvent event)
+    {
+        Player player = event.getPlayer();
+        player.getInventory().clear();
+        player.getInventory().addItem(new ItemStack(Material.DIAMOND_SWORD, 1));
        
+        ItemStack customSword = new ItemStack(Material.DIAMOND_SWORD, 1);
+        ItemMeta customM = customSword.getItemMeta();
+        customM.setDisplayName("§6Titre d'arme perso");
+        customM.setLore(Arrays.asList("§7Ceci est une arme", "§7Très puissante")); // Chaque texte = une ligne dans la description
+        customM.addEnchant(Enchantment.DAMAGE_ALL, 5, true); // Enchantement / puissance / Le fixer
+        customM.addItemFlags(ItemFlag.HIDE_ENCHANTS); // Cacher les enchantements
+        customSword.setItemMeta(customM);

+        player.getInventory().setItemInOffHand(customSword); // setItemInMainHand

+        ItemStack customwool = new ItemStack(Material.WHITE_WOOL, 1, (byte) 14); // 14 = rouge, 5 = jaune, 11 = bleu...

+        player.getInventory().setHelmet(customwool);

+        player.updateInventory();
+    }
+}
```