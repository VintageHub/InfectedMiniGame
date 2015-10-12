package net.bobmandude9889.Arena;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.bobmandude9889.Error.Errors;
import net.bobmandude9889.Infected.Infected;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class ArenaHandler {

	private HashMap<String, Arena> arenas = new HashMap<String, Arena>();

	private File configFolder;

	private Plugin plugin;

	public ArenaHandler() {
		plugin = Infected.getPlugin();
		configFolder = new File(plugin.getDataFolder().getAbsolutePath()
				+ "/infected");
		if (!configFolder.exists()) {
			configFolder.mkdir();
		}
	}

	public void loadArenaFromFile(File file){
		if(file.exists()){
			FileConfiguration config = YamlConfiguration.loadConfiguration(file);
			String name = file.getName().replace(".yml", "");
			
			List<String> spawnData = config.getStringList("spawn");
			List<Double> spawnCoords = new ArrayList<Double>();
			for(int i = 1; i < spawnData.size(); i++){
				String string = spawnData.get(i);
				spawnCoords.add(Double.parseDouble(string));
			}
			Location spawn = new Location(Bukkit.getWorld(spawnData.get(0)),spawnCoords.get(0),spawnCoords.get(1),spawnCoords.get(2));

			List<String> waitData = config.getStringList("wait");
			List<Double> waitCoords = new ArrayList<Double>();
			for(int i = 1; i < waitData.size(); i++){
				String string = waitData.get(i);
				waitCoords.add(Double.parseDouble(string));
			}
			Location wait = new Location(Bukkit.getWorld(waitData.get(0)),waitCoords.get(0),waitCoords.get(1),waitCoords.get(2));
			
			arenas.put(name, new Arena(spawn,wait,""));
		} else {
			Errors.FILENOTFOUND.broadcastToOps(file.getName());
		}
	}

	public void loadArenas() {
		for (File file : configFolder.listFiles()) {
			loadArenaFromFile(file);
		}
	}

	public void saveArenas() {

	}

	public Arena getArena(String name) {
		return arenas.get(name);
	}

}
