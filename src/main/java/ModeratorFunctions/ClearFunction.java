package ModeratorFunctions;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.List;

import me.zwoosks.MazikroBot.Ref;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageHistory;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public class ClearFunction {
	public void clearMethod(GuildMessageReceivedEvent e) {
		
		String[] args = e.getMessage().getContentRaw().split(" ");
		
		if(args[0].equalsIgnoreCase(Ref.prefix + "clear")) {
			
			if(IsStaff.isStaff(e.getMember())) {
				
				if(args.length <= 2) {
					sendError(e.getChannel(), e.getMember());
				} else {
					TextChannel tarjet = e.getMessage().getMentionedChannels().get(0);
					purgeMessages(tarjet, Integer.parseInt(args[2]));
					if(args.length > 3) {
						String reason = " ";
						for(int i = 3; i < args.length; i++) {
							reason += args[i] + " ";
						}
						log(e.getMember(), args[2], reason, e.getGuild().getTextChannelById("517726920058601492"), tarjet);
					} else {
						log(e.getMember(), args[2], "Reason not specified.", e.getGuild().getTextChannelById("517726920058601492"), tarjet);
					}
				}
				
			}
			
		}
	}
	
	private void sendError(TextChannel channel, Member member) {
		EmbedBuilder eb = new EmbedBuilder();
		
		eb.setColor(Color.red);
		
		// A baix del títol - text informatiu
		eb.setDescription("");
		
		eb.setTitle("Invalid usage");
		eb.setDescription("{} = required, [] = optional.");
		eb.addField("Proper usage: !clear {#channel} {amount of messages} [reason]", "", false);
		eb.addField("Reember to:", "Remember that you can remove a max amount of 99 messages per command!", false);
		
		// Image
		eb.setAuthor(member.getUser().getName(), null, "https://i.imgur.com/9XM231V.png");
		
		channel.sendMessage(eb.build()).queue();
	}
	
	
	private void log(Member clearer, String num, String reason, TextChannel incident, TextChannel cleared) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat stf = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		
		EmbedBuilder eb = new EmbedBuilder();
		eb.setAuthor("Channel cleared by " + clearer.getUser().getName(), null, clearer.getUser().getAvatarUrl());
		eb.setColor(Color.decode("#0652DD"));
		eb.addField("Cleared channel", cleared.getAsMention(), false);
		eb.addField("Number of messages cleared", num + " times.", false);
		eb.addField("Clearer user", clearer.getAsMention(), false);
		eb.addField("Reason", reason, false);
		eb.addField("Date", sdf.format(date), false);
		eb.addField("Time", stf.format(date), false);
		
		incident.sendMessage(eb.build()).queue();
		
	}
	
	private void purgeMessages(TextChannel channel, int num) {
		
		MessageHistory history = new MessageHistory(channel);
		List<Message> msgs;
		
		msgs = history.retrievePast(num).complete();
		channel.deleteMessages(msgs).queue();
	}
	
}
