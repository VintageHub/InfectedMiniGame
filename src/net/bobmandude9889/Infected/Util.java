package net.bobmandude9889.Infected;

import net.md_5.bungee.api.ChatColor;

public class Util {

	public static String format(String message, Tag... tag){
		String chars = "1234567890abceflknmor";
		for(Character character : chars.toCharArray()){
			message.replace("&" + character,ChatColor.getByChar(character) + "");
		}
		
		for(Tag iTag : tag){
			message.replace("%" + iTag.tagName + "%",iTag.replacement);
		}
		return message;
	}
	
}
