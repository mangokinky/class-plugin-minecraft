package org.feehgamer.classplugin.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.feehgamer.classplugin.Main;
import org.feehgamer.classplugin.ui.ClassUI;

public class InventoryClickListener implements Listener{
	
	@SuppressWarnings("unused")
	private Main plugin;
	
	public InventoryClickListener(Main plugin) {
		this.plugin = plugin;
		
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		String title = e.getInventory().getTitle();
		if(title.equals(ClassUI.inventory_name)) {
			e.setCancelled(true);
			 if(e.getCurrentItem() == null) {
				 return;
			 }
			 if(title.contentEquals(ClassUI.inventory_name)) {
				 ClassUI.clicked((Player) e.getWhoClicked(), e.getSlot(), e.getCurrentItem(), e.getInventory());
			 }
		}
	}

}
