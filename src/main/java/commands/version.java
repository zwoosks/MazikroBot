package commands;

import java.awt.Color;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.User;

public class version {

	public void versionMethod(User user, Message message) {
		
        EmbedBuilder eb = new EmbedBuilder();
		
		eb.setColor(new Color(102, 153, 255));
		
		// A baix del títol - text informatiu
		eb.setDescription("Bot version: v4.0");
		    		
		// Image
		eb.setAuthor("Bot version", null, "https://i.imgur.com/9XM231V.png");
		
		message.getChannel().sendMessage(eb.build()).queue();
		
	}
	
}
