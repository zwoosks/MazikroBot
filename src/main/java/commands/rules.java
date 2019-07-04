package commands;

import java.awt.Color;

import me.zwoosks.MazikroBot.Ref;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.User;

public class rules {

	public void rulesMethod(User user, Message message) {
		
		if(message.getContentRaw().equalsIgnoreCase(Ref.prefix + "rules")) {
			
			EmbedBuilder eb = new EmbedBuilder();
			
			eb.setColor(new Color(102, 153, 255));
			
			// A baix del títol - text informatiu
			eb.setDescription("\n**MAZIKRO NETWORK DISCORD RULES**\n1. No spamming a channel by voice or text.\n2. Do not insult any member of this server including members and staff.\n3. Don't post content NSFW or any other unsuitable for minors content.\n4. If you need help use **@mentions**, but do not abuse from them our you’ll be silenced.\n5. Follow the TOS of Discord (https://discordapp.com/terms).\n6. Use commands in #bot-commands channel. If you use them in another channel it will be considered spam.\n7. Don't advertise other Discord / Minecraft servers.\n8. **Have fun!**");
			    		
			// Image
			eb.setAuthor("Rules", null, "https://i.imgur.com/9XM231V.png");
			
			message.getChannel().sendMessage(eb.build()).queue();
			
		}
		
	}
	
}
