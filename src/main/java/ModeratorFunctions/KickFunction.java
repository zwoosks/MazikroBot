package ModeratorFunctions;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;

import me.zwoosks.MazikroBot.Ref;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public class KickFunction {
	
	public void kikcMethod(GuildMessageReceivedEvent e) {
		
		String[] args = e.getMessage().getContentRaw().split(" ");
		
		if(args[0].equalsIgnoreCase(Ref.prefix + "kick")) {
		
		if(IsStaff.isStaff(e.getMember())) {
			
			
			if(args.length <= 1) {
				sendError(e.getChannel(), e.getMember());
			} else {
				
				Member tarjet = e.getMessage().getMentionedMembers().get(0);
				
				e.getMember().getGuild().getController().kick(tarjet).queue();
				
				if(args.length >= 3) {
					String reason = "";
					
					for(int i = 2; i < args.length; i++) {
						reason += args[i] + " ";
					}
					
					log(tarjet, e.getMember(), reason, e.getGuild().getTextChannelById("517726920058601492"));
					
				} else {
					log(tarjet, e.getMember(), "Reason not specified.", e.getGuild().getTextChannelById("517726920058601492"));
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
		eb.addField("Proper usage: !kick {@user} [reason]", "", false);
		
		// Image
		eb.setAuthor(member.getUser().getName(), null, "https://i.imgur.com/9XM231V.png");
		
		channel.sendMessage(eb.build()).queue();
	}
	
	
	private void log(Member muted, Member muter, String reason, TextChannel channel) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat stf = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		
		EmbedBuilder eb = new EmbedBuilder();
		eb.setAuthor("Kick by " + muter.getUser().getName(), null, muter.getUser().getAvatarUrl());
		eb.setColor(Color.decode("#0652DD"));
		eb.addField("   Kicked user", muted.getAsMention(), false);
		eb.addField("   Kicker user", muter.getAsMention(), false);
		eb.addField("   Reason", reason, false);
		eb.addField("   Date", sdf.format(date), false);
		eb.addField("   Time", stf.format(date), false);
		
		channel.sendMessage(eb.build()).queue();
		
	}
	
}
