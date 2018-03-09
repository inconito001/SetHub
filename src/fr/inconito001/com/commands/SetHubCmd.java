package fr.inconito001.com.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import fr.inconito001.com.Sethub;

public class SetHubCmd implements CommandExecutor {
	
	static FileConfiguration file = Sethub.getInstance().getConfig();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		
		if (!(sender instanceof Player)) {
			sender.sendMessage("You must be a player");
		} else {

			if (cmd.getName().equalsIgnoreCase("sethub")) {
				if (!p.hasPermission("hub.Sethub")) {
					p.sendMessage(file.getString("Config.Messages.NoPermission").replace("&", "§"));
					return true;

				} else {

					file.set("Hub_Location.world", p.getLocation().getWorld().getName());
					file.set("Hub_Location.x", p.getLocation().getX());
					file.set("Hub_Location.y", p.getLocation().getY());
					file.set("Hub_Location.z", p.getLocation().getZ());
					file.set("Hub_Location.Yaw", p.getLocation().getYaw());
					file.set("Hub_Location.Pitch", p.getLocation().getPitch());

					Sethub.getInstance().saveConfig();

					p.sendMessage(file.getString("Config.Messages.SetSucess").replace("&", "§"));
					p.playSound(p.getLocation(), Sound.BLAZE_DEATH, 10.0f, -10.0f);

					return true;
				}
			}
		}

		return false;
	}
	
	public static Location getSpawnLocation() {
		final World w = Bukkit.getServer().getWorld(file.getString("Hub_Location.world"));
		double x = file.getDouble("Hub_Location.x");
		double y = file.getDouble("Hub_Location.y");
		double z = file.getDouble("Hub_Location.z");
		float pitch = file.getInt("Hub_Location.Pitch");
		float Yaw = file.getInt("Hub_Location.Yaw");
		
		return new Location(w, x, y, z, Yaw, pitch);
	}

}
