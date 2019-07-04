package commands;

import java.awt.Color;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.User;

public class reglas {

	public void reglasMethod(User user, Message message) {
		
		EmbedBuilder eb = new EmbedBuilder();
		
		eb.setColor(new Color(102, 153, 255));
		
		// A baix del títol - text informatiu
		eb.setDescription("**\nREGLAS DE NUESTRO SERVIDOR DE DISCORD**\n1. NO hagas spam ya sea por voz o texto.\n2. NO insultes a nadie, ya sea staff o no.\n3. NO publiques contenido NSFW o cualquier contenido +18.\n4. Si necesitas ayuda, usa **@menciones** pero no abuses de ellas o serás silenciado.\n5. Sigue las términos oficiales de Discord (https://discordapp.com/terms).\n6. Es preferible usar los comandos en el canal #bot-commands. Si se usan repetidamente o varias veces en otro canal, se tomarán las medidas apropiadas ya que se considerará flood.\n7. NO promociones otros servidores de Discord / Minecraft.\n8. **¡Diviértete!**");
		    		
		// Image
		eb.setAuthor("Reglas", null, "https://i.imgur.com/9XM231V.png");
		
		message.getChannel().sendMessage(eb.build()).queue();
		
	}
	
}
