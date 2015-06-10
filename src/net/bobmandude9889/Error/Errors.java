package net.bobmandude9889.Error;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public enum Errors {

	FILENOTFOUND("Attempted to load the file %a% that doesn't exist"),
	FILEFORMATERROR("The data in the file %a% is not sufficient.");
	
	private String message;
	
	private Errors(String message){
		this.message = message;
	}
	
	public void sendMessage(Player player, String arg){
		player.sendMessage(ChatColor.DARK_RED + "Error: " + ChatColor.RED + message.replace("%a%", arg));
	}
	
	public void broadcastToOps(String arg){
		for(Player player : Bukkit.getOnlinePlayers()){
			sendMessage(player,arg);
		}
	}
	
	public void broadcast(String arg){
		Bukkit.broadcastMessage(getMessage(arg));
	}
	
	public String getRawMessage(){
		return message;
	}
	
	public String getMessage(String arg){
		return ChatColor.DARK_RED + "Error: " + ChatColor.RED + message.replace("%a%", arg);
	}
	
}
