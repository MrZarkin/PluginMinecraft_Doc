import java.util.Arrays;

import org.bukkit.event.EventHandler;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.Material;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.event.block.Action;

public class MonPluginListeners implements Listener 
{
    @EventHandler
    public void onJoin(PlayerJoinEvent event)
    {
        Player player = event.getPlayer();
        player.getInventory().clear();
        player.getInventory().addItem(new ItemStack(Material.DIAMOND_SWORD, 1));
        
        ItemStack customSword = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemMeta customM = customSword.getItemMeta();
        customM.setDisplayName("§6Titre d'arme perso");
        customM.setLore(Arrays.asList("§7Ceci est une arme", "§7Très puissante")); // Chaque texte = une ligne dans la description
        customM.addEnchant(Enchantment.DAMAGE_ALL, 5, true); // Enchantement / puissance / Le fixer
        customM.addItemFlags(ItemFlag.HIDE_ENCHANTS); // Cacher les enchantements
        customSword.setItemMeta(customM);

        player.getInventory().setItemInOffHand(customSword); // setItemInMainHand

        ItemStack customwool = new ItemStack(Material.WHITE_WOOL, 1, (byte) 14); // 14 = rouge, 5 = jaune, 11 = bleu...

        player.getInventory().setHelmet(customwool);

        player.updateInventory();
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event)
    {
        Player player = event.getPlayer();
        Action action = event.getAction();
        ItemStack item = event.getItem();

        if(item == null)
            return;

        if(item.getType() == Material.DIAMOND_HOE)
        {
            if(action == Action.RIGHT_CLICK_AIR)
            {
                player.sendMessage("Interaction completed!");
            }
        }

        if(item.getType() == Material.DIAMOND_SWORD && item.hasItemMeta() && item.getItemMeta().hasDisplayName() && item.getItemMeta().getDisplayName().equals("§6Titre d'arme perso"))
        {
            player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 1)); // Durée en ticks (20 = 1 seconde) / puissance
        }
    }
}
