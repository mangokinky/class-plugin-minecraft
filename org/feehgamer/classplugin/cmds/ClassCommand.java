package org.feehgamer.classplugin.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.feehgamer.classplugin.Main;
import org.feehgamer.classplugin.ui.ClassUI;
import org.feehgamer.classplugin.utils.Chatcolor;

public class ClassCommand implements CommandExecutor {

	private Main plugin;

	public ClassCommand(Main plugin) {
		this.plugin = plugin;

		plugin.getCommand("class").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage("Console can't execute this command!");
			return true;
		}

		Player p = (Player) sender;
		if (!(p.hasPermission("class.use"))) {
			p.sendMessage(Chatcolor.chat("§c# §fYou don't have permission to execute this command!"));
		}
			p.openInventory(ClassUI.GUI(p));
		return false;

	}

}
