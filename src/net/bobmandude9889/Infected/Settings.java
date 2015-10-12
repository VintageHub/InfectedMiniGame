package net.bobmandude9889.Infected;

import org.bukkit.configuration.file.FileConfiguration;

public class Settings {

	public static int minPlayers;
	public static String messagePrefix;
	public static String gameRunning;
	public static String joinedGame;
	public static String otherJoinedGame;
	
	public void reload(Infected plugin){
		FileConfiguration config = plugin.getConfig();
		minPlayers = config.getInt("min_players");
		messagePrefix = config.getString("messages.message_prefix");
		gameRunning = config.getString("messages.game_running");
		joinedGame = config.getString("messages.joined_game");
		otherJoinedGame = config.getString("messages.other_joined_game");
	}
	
}
