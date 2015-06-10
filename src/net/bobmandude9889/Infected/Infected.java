package net.bobmandude9889.Infected;

import net.bobmandude9889.Arena.ArenaHandler;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Infected extends JavaPlugin{
	
	private static Plugin plugin;
	private static ArenaHandler arenaHandler;
	
	public void onEnable(){
		plugin = this;
	}
	
	public void onDisable(){
		
	}
	
	public static Plugin getPlugin(){
		return plugin;
	}
	
	public static ArenaHandler getArenaHandler(){
		return arenaHandler;
	}
	
}
