package commands;

import java.awt.Color;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.User;

public class foro {

	public void foroMethod(User user, Message message) {
				
		EmbedBuilder eb = new EmbedBuilder();
		
		eb.setColor(new Color(102, 153, 255));
		
		// A baix del títol - text informatiu
		eb.setDescription("Nuestro foro de habla hispana es **https://foros.mazikro.com/**. ¡Héchale un vistazo!");
		    		
		// Image
		eb.setAuthor("Foro", null, "https://i.imgur.com/9XM231V.png");
		
		message.getChannel().sendMessage(eb.build()).queue();
		
	}
	
}
