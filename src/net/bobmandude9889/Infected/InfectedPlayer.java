package net.bobmandude9889.Infected;

import net.bobmandude9889.Arena.Arena;

import org.bukkit.entity.Player;

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
	
}
