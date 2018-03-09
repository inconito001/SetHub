package fr.inconito001.com.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import fr.inconito001.com.Sethub;
import fr.inconito001.com.commands.SetHubCmd;

public class PlayerListener implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if (Sethub.getInstance().getConfig().getConfigurationSection("spawn") == null) {
			return;
		} else {
			p.teleport(SetHubCmd.getSpawnLocation());
		}
	}

}
