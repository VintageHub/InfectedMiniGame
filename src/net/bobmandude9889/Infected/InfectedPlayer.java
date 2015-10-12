package net.bobmandude9889.Infected;


import org.bukkit.Location;
import org.bukkit.entity.Player;

import net.bobmandude9889.Arena.Arena;

public class InfectedPlayer{
	
	private Player player;
	
	public InfectedPlayer(Player player){
		this.player = player;
	}
	
	public void joinGame(Arena arena){
		arena.addPlayer(this);
	}
	
	public Player getPlayer(){
		return player;
	}
	
	public void sendMessage(String message){
		player.sendMessage(Settings.messagePrefix + " " + Util.format(message));
	}
	
	public void teleport(Location location){
		player.teleport(location);
	}
	
}
