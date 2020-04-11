package org.feehgamer.classplugin.utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class Chatcolor {

	public static String chat (String s) {
		return ChatColor.translateAlternateColorCodes('&', s);
	}
	public static ItemStack createItem(Inventory inv, int materialId, int amount, int invSlot, String displayName, String... loreString) {
		
		ItemStack item;
		List<String> lore = new ArrayList();
		item = new ItemStack(Material.getMaterial(materialId), amount);
		
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(Chatcolor.chat(displayName));
		for (String s: loreString) {
			lore.add(Chatcolor.chat(s));
		}
		meta.setLore(lore);
		item.setItemMeta(meta);
		
		inv.setItem(invSlot - 1, item);
		return item;
	}
		public static ItemStack createItemByte(Inventory inv, int materialId, int byteId, int amount, int invSlot, String displayName, String... loreString) {
			
		ItemStack item;
		List<String> lore = new ArrayList();
		
		item = new ItemStack(Material.getMaterial(materialId), amount, (short) byteId);
		
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(Chatcolor.chat(displayName));
		for (String s: loreString) {
			lore.add(Chatcolor.chat(s));
		}
		meta.setLore(lore);
		item.setItemMeta(meta);
		
		inv.setItem(invSlot - 1, item);
		return item;
	}
		@SuppressWarnings("deprecation")
		public static ItemStack createSkull(Inventory inv, String owner, int amount, String displayName, int invSlot, String... loreString) {
			
		List<String> lore = new ArrayList();
		
		
		ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
		
		SkullMeta meta = (SkullMeta) skull.getItemMeta();
		meta.setOwner(owner);
		for (String s: loreString) {
			lore.add(Chatcolor.chat(s));
		}
		meta.setLore(lore);
		meta.setDisplayName(displayName);
		skull.setItemMeta(meta);
		
		inv.setItem(invSlot - 1, skull);
		return skull;
	}
}
