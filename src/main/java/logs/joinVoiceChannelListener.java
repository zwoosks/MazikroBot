package logs;

import java.awt.Color;
import java.util.Date;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.entities.VoiceChannel;
import net.dv8tion.jda.core.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class joinVoiceChannelListener extends ListenerAdapter {

	@SuppressWarnings({ "deprecation" })
	public void onGuildVoiceJoin(GuildVoiceJoinEvent e) {

		
		TextChannel txtChannel = e.getJDA().getTextChannelById("509791291568160768");
		VoiceChannel voiceChannel = e.getChannelJoined();
		User user = e.getMember().getUser();
		
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
		eb.setDescription(user.getAsMention() + " has connected to " + voiceChannel.getName() + " voice channel.\n"
				+ "Date: " + year + "/" + month + "/" + dayMonth + " at " + hour + ":" + minute + ":" + seconds);
		    		
		// Image
		eb.setAuthor("Logs", null, "https://i.imgur.com/9XM231V.png");
		
		txtChannel.sendMessage(eb.build()).queue();
		
		
		
	}

}