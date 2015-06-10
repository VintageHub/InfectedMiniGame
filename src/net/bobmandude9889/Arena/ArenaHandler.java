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
			List<String> data = config.getStringList("spawn");
			List<Double> coords = new ArrayList<Double>();
			for(int i = 1; i < data.size(); i++){
				String string = data.get(i);
				coords.add(Double.parseDouble(string));
			}
			Location spawn = new Location(Bukkit.getWorld(data.get(0)),coords.get(0),coords.get(1),coords.get(2));
			arenas.put(name, new Arena(spawn));
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
