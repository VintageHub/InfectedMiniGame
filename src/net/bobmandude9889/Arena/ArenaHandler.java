package net.bobmandude9889.Arena;

import java.io.File;
import java.util.HashMap;

import net.bobmandude9889.Error.Errors;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class ArenaHandler {

	private HashMap<String,Arena> arenas = new HashMap<String,Arena>();
	
	public void loadArenaFromFile(File file){
		if(file.exists()){
			FileConfiguration config = YamlConfiguration.loadConfiguration(file);
			
		} else {
			Errors.FILENOTFOUND.broadcastToOps(file.getName());
		}
	}
	
	public void loadArenas(){
		
	}
	
	public void saveArenas(){
		
	}
	
	public Arena getArena(String name){
		return arenas.get(name);
	}
	
}
