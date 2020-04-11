package org.feehgamer.classplugin.ui;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;
import org.feehgamer.classplugin.Main;
import org.feehgamer.classplugin.utils.Chatcolor;

public class ClassResetUI implements Listener {
	public static Main plugin;

	public ClassResetUI(Main plugin) {
		ClassResetUI.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}

	public static Inventory inv;
	public static String inventory_name;
	public static int inv_rows = 3 * 9;

	public static void initialize() {
		inventory_name = Chatcolor.chat("&6Vyber si classu");

		inv = Bukkit.createInventory(null, inv_rows);
	}

	public static Inventory GUI(Player p) {
		Inventory toReturn = Bukkit.createInventory(null, inv_rows, inventory_name);

		Chatcolor.createItemByte(inv, 160, 15, 1, 1, "&f ", "");
		Chatcolor.createItemByte(inv, 160, 15, 1, 2, "&f ", "");
		Chatcolor.createItemByte(inv, 160, 15, 1, 3, "&f ", "");
		Chatcolor.createItemByte(inv, 160, 15, 1, 4, "&f ", "");
		Chatcolor.createItemByte(inv, 160, 15, 1, 5, "&f ", "");
		Chatcolor.createItemByte(inv, 160, 15, 1, 6, "&f ", "");
		Chatcolor.createItemByte(inv, 160, 15, 1, 7, "&f ", "");
		Chatcolor.createItemByte(inv, 160, 15, 1, 8, "&f ", "");
		Chatcolor.createItemByte(inv, 160, 15, 1, 9, "&f ", "");
		Chatcolor.createItemByte(inv, 160, 15, 1, 10, "&f ", "");
		Chatcolor.createItemByte(inv, 160, 15, 1, 16, "&f ", "");
		Chatcolor.createItemByte(inv, 160, 15, 1, 12, "&f ", "");
		Chatcolor.createItemByte(inv, 160, 15, 1, 13, "&f ", "");
		Chatcolor.createItemByte(inv, 160, 15, 1, 15, "&f ", "");
		Chatcolor.createItemByte(inv, 160, 15, 1, 18, "&f ", "");
		Chatcolor.createItemByte(inv, 160, 15, 1, 19, "&f ", "");
		Chatcolor.createItemByte(inv, 160, 15, 1, 20, "&f ", "");
		Chatcolor.createItemByte(inv, 160, 15, 1, 21, "&f ", "");
		Chatcolor.createItemByte(inv, 160, 15, 1, 22, "&f ", "");
		Chatcolor.createItemByte(inv, 160, 15, 1, 24, "&f ", "");
		Chatcolor.createItemByte(inv, 160, 15, 1, 25, "&f ", "");
		Chatcolor.createItemByte(inv, 160, 15, 1, 26, "&f ", "");
		Chatcolor.createItemByte(inv, 160, 15, 1, 27, "&f ", "");
		Chatcolor.createItemByte(inv, 160, 15, 1, 11, "&f ", "");
		Chatcolor.createItemByte(inv, 152, 0, 1, 17, "§c§lRESET", "");
		Chatcolor.createItemByte(inv, 160, 15, 1, 17, "&f ", "");

		toReturn.setContents(inv.getContents());
		return toReturn;
	}

	public static void clicked(Player p, int slot, ItemStack clicked, Inventory inv) {
		if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase(Chatcolor.chat("§c§lRESET"))) {
			plugin.getConfig().set("Class." + p.getName(), null);
			plugin.saveConfig();
			p.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
			p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
			p.setFlySpeed(0.1F);
			p.setWalkSpeed(0.2F);
			p.sendMessage(Chatcolor.chat("&a# &fClass successfully reset!"));
			p.closeInventory();
		}
		
	}
}
