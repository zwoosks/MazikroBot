package others;

import java.awt.Color;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.message.MessageDeleteEvent;

public class DeleteMessageLogger {
	
	public void onMessageDelete(MessageDeleteEvent e) {
		
		String message = e.getJDA().getTextChannelById(e.getTextChannel().getId()).getMessageById(e.getMessageId()).toString();
		TextChannel channel = e.getJDA().getTextChannelById("CHANNEL ID");
		
		EmbedBuilder builder = new EmbedBuilder();
		builder.setColor(new Color(255, 108, 0));
		
	}
	
}
