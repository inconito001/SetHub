package fr.inconito001.com.commands;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import fr.inconito001.com.Sethub;

public class HubCmd implements CommandExecutor {

	FileConfiguration file = Sethub.getInstance().getConfig();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;

		if (!(sender instanceof Player)) {
			sender.sendMessage("You must be a player");
			return true;
		} else {
			if (cmd.getName().equalsIgnoreCase("hub")) {
				p.teleport(SetHubCmd.getSpawnLocation());
				p.sendMessage(file.getString("Config.Messages.TpToHub").replace("&", "§"));
				p.playSound(p.getLocation(), Sound.WITHER_SHOOT, 10.0f, -10.0f);
				return true;
			} else {
				if (file.getConfigurationSection("spawn") == null) {
					p.sendMessage(file.getString("Config.Messages.NoSetHub").replace("&", "§"));
					return true;
				}
			}
		}
		return true;
	}
}
