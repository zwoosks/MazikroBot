package commands;

import java.awt.Color;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.User;

public class ayuda {

	public void ayudaMethod(User user, Message message) {
		
		EmbedBuilder eb = new EmbedBuilder();
		
		eb.setColor(new Color(102, 153, 255));
		
		// A baix del títol
		
		eb.addField("**Reglas**", "Usa _!reglas_ para informarte de nuestras reglas del servidor de Discord.", false);
		eb.addField("**Servidor de Minecraft**", "Usa _!ip_ o _!play_ para obtener nuestra IP del servidor.", false);
		eb.addField("**Estado del servidor**", "Usa _!estadoservidor_ para enterarte de si nuestro servidor está cerrado o abierto.", false);
		eb.addField("**Jugadores online**", "Usa _!jugadoresonline_ para saber cuantos usuarios están conectados a la Network.", false);
		eb.addField("**Foro**", "Usa _!foro_ para obtener la dirección web de nuestro foro de habla hispana.", false);
		eb.addField("**Sugerencias del bot**", "Envía una sugerencia para nuestro bot en el canal _#bot-suggerences_.", false);
		eb.addField("**Experiencia**", "Obtén tu nivel actual de experiencia con _!xp_. ¡Ten en cuenta que cuanto más participativo seas más experiencia tendrás!", false);
		eb.addField("**Idioma**", "Especifica tu idioma con _!language_. @menciona a tu respectivo rol de tu idioma, en tu caso _!language @spanish_.", false);
		eb.addField("**Crea tu perfil**", "Usa _!setprofile (Una pequeña descriptión de ti)_ para crear tu perfil de Discord.", false);
		eb.addField("**Ver otros perfiles**", "Usa _!profile (@mención del perfil que quieres ver)_ para obtener el perfil de un usuario.", false);
		eb.addField("**Versión**", "Usa _!versión_ para obtener la versión de nuestro bot de Discord.", false);
		
		// Image
		eb.setAuthor("Ayuda", null, "https://i.imgur.com/9XM231V.png");
		
		message.getChannel().sendMessage(eb.build()).queue();
		
		// --------------------------------------------------------------------
		
		EmbedBuilder eb2 = new EmbedBuilder();
				
		eb.setAuthor("Comandos divertidos", null, "https://i.imgur.com/9XM231V.png");
				
		eb2.addField("**8ball***", "La mágica 8-Ball. Usa esta función con **!8ball {texte}**", false);
		eb2.addField("**Anime***", "Ve imágenes anime con **!anime**. Solamente está disponible en el canal **#anime**.", false);
		eb2.addField("**Memes***", "Ve memes con **!meme**. Solamente está disponible en el canal **#memes**.", false);
				
		message.getChannel().sendMessage(eb2.build()).queue();
		
	}
	
}
