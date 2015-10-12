package net.bobmandude9889.Arena;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;

import net.bobmandude9889.Infected.InfectedPlayer;
import net.bobmandude9889.Infected.Settings;
import net.bobmandude9889.Infected.Tag;
import net.bobmandude9889.Infected.Util;

public class Arena {
	
	private List<InfectedPlayer> players;
	
	Location spawn;
	Location wait;
	
	ArenaState state = ArenaState.WAITING;
	
	public String id;
	
	public Arena(Location spawn, Location wait, String id){
		this.spawn = spawn;
		this.wait = wait;
		players = new ArrayList<InfectedPlayer>();
		this.id = id;
	}
	
	public void addPlayer(InfectedPlayer player){
		if(state.equals(ArenaState.RUNNING)){
			player.sendMessage(Settings.gameRunning);
			//TODO Queue players for next game
		} else {
			player.sendMessage(Util.format(Settings.joinedGame, new Tag("game_id",id)));
			player.teleport(wait);
			broadcastToPlayers(Util.format(Settings.otherJoinedGame,new Tag("player",player.getPlayer().getName())));
			players.add(player);
		}
	}

	public void broadcastToPlayers(String message){
		for(InfectedPlayer player : players){
			player.sendMessage(message);
		}
	}
	
}
