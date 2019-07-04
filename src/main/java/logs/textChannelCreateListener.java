package logs;

import java.awt.Color;
import java.util.Date;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.channel.text.TextChannelCreateEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class textChannelCreateListener extends ListenerAdapter {

	@SuppressWarnings({ "deprecation" })
	public void onTextChannelCreate(TextChannelCreateEvent e) {

		
		TextChannel txtChannel = e.getJDA().getTextChannelById("509791291568160768");
		TextChannel createdChannel = e.getChannel();
		
		System.currentTimeMillis();
		
		Date date = new Date();
		int year = date.getMonth();
		int month = date.getMonth();
		int dayMonth = date.getDay();
		int hour = date.getHours();
		int minute = date.getMinutes();
		int seconds = date.getSeconds();
		
        EmbedBuilder eb = new EmbedBuilder();
		
		eb.setColor(new Color(153, 153, 102));
		
		// A baix del títol - text informatiu
		eb.setDescription(createdChannel.getAsMention() + " text channel has been created.\n"
				+ "Date: " + year + "/" + month + "/" + dayMonth + " at " + hour + ":" + minute + ":" + seconds);
		    		
		// Image
		eb.setAuthor("Logs", null, "https://i.imgur.com/9XM231V.png");
		
		txtChannel.sendMessage(eb.build()).queue();
		
		
		
	}

}