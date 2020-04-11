package org.feehgamer.classplugin;

import org.bukkit.plugin.java.JavaPlugin;
import org.feehgamer.classplugin.ui.ClassUI;
import org.feehgamer.classplugin.listeners.InventoryClickListener;
import org.feehgamer.classplugin.cmds.ClassCommand;

public class Main extends JavaPlugin {


    @Override
    public void onEnable() {
    	new ClassCommand(this);
        ClassUI.initialize();
        loadConfig();
        getServer().getConsoleSender().sendMessage("§8--------------------------\n\n§fClass plugin §aenabled§f!\n\n§8--------------------------");

        // listeners
        new InventoryClickListener(this);
    }
    public void onDisable() {
        getServer().getConsoleSender().sendMessage("§8--------------------------\n\n§fClass plugin §cdisabled§f!\n\n§8--------------------------");
    }
	public void loadConfig(){
		getConfig().options().copyDefaults(true);
		saveConfig();
	}

}
