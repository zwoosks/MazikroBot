package channels_management;

import java.awt.Color;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.User;

public class bot_suggestions {

	public void bot_suggestionsMethod(User user, Message message) {
		
		EmbedBuilder eb = new EmbedBuilder();
		
		eb.setColor(new Color(115, 115, 115));
		
		// A baix del títol - text informatiu
		eb.setDescription(message.getContentRaw());
		    		
		// Image
		eb.setAuthor(user.getName() + "'s suggerence:", null, user.getAvatarUrl());
		
		message.delete().queue();
		message.getChannel().sendMessage(eb.build()).queue();
		
	}
	
} 
