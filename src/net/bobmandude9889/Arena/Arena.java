package net.bobmandude9889.Arena;

import java.util.ArrayList;
import java.util.List;

import net.bobmandude9889.Infected.InfectedPlayer;
import net.minecraft.server.v1_8_R1.World;

import org.bukkit.Location;

public class Arena {
	
	private List<InfectedPlayer> players;
	
	Location spawn;
	
	ArenaState state = ArenaState.WAITING;
	
	public Arena(Location spawn){
		this.spawn = spawn;
		players = new ArrayList<InfectedPlayer>();
	}
	
	public void addPlayer(InfectedPlayer player){
		
	}
	
}
