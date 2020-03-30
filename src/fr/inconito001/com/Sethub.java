package fr.inconito001.com;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.inconito001.com.commands.HubCmd;
import fr.inconito001.com.commands.SetHubCmd;
import fr.inconito001.com.listeners.PlayerListener;

public class Sethub extends JavaPlugin {
	
	private static Sethub instance;	
	
	@Override
	public void onEnable() {
		saveDefaultConfig();
		instance = this;
		registerCommands();
		registerEvents();
	}
	
	@Override
	public void onDisable() {
		
	}	
	
	private void registerCommands() {
		getCommand("sethub").setExecutor(new SetHubCmd());
		getCommand("hub").setExecutor(new HubCmd());
	}
	
	private void registerEvents() {
		PluginManager pm = getServer().getPluginManager();
		
		pm.registerEvents(new PlayerListener(), this);
	}
	
	public static Sethub getInstance() {
		return instance;
	}
	
}
