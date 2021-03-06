package ModeratorFunctions;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;

import me.zwoosks.MazikroBot.Ref;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public class MuteFunction {
	
	public void muteMethod(GuildMessageReceivedEvent e) {
		String[] args = e.getMessage().getContentRaw().split(" ");
		
		if(args[0].equalsIgnoreCase(Ref.prefix + "mute")) {
			if(IsStaff.isStaff(e.getMember())) {
				
				if(args.length <= 1) {
					sendError(e.getChannel(), e.getMember());
				} else {
					Member tarjet = e.getMessage().getMentionedMembers().get(0);
					Role muted = e.getGuild().getRolesByName("Silenced", true).get(0);
					
					e.getGuild().getController().addSingleRoleToMember(tarjet, muted).queue();
					
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
		} else if(args[0].equalsIgnoreCase(Ref.prefix + "unmute")) {
			if(IsStaff.isStaff(e.getMember())) {
				
				if(args.length <= 1) {
					sendError(e.getChannel(), e.getMember());
				} else {
					Member tarjet = e.getMessage().getMentionedMembers().get(0);
					Role muted = e.getGuild().getRolesByName("Silenced", true).get(0);
					
					e.getGuild().getController().removeSingleRoleFromMember(tarjet, muted).queue();
					
					if(args.length >= 3) {
						String reason = "";
						
						for(int i = 2; i < args.length; i++) {
							reason += args[i] + " ";
						}
						
						logUnmute(tarjet, e.getMember(), reason, e.getGuild().getTextChannelById("517726920058601492"));
						
					} else {
						logUnmute(tarjet, e.getMember(), "Reason not specified.", e.getGuild().getTextChannelById("517726920058601492"));
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
		eb.addField("Proper usage: !mute {@user} [reason]", "", false);
		
		// Image
		eb.setAuthor(member.getUser().getName(), null, "https://i.imgur.com/9XM231V.png");
		
		channel.sendMessage(eb.build()).queue();
	}
	
	private void log(Member muted, Member muter, String reason, TextChannel channel) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat stf = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		
		EmbedBuilder eb = new EmbedBuilder();
		eb.setAuthor("Mute report by " + muter.getUser().getName(), null, muter.getUser().getAvatarUrl());
		eb.setColor(Color.decode("#0652DD"));
		eb.addField("   Muted user", muted.getAsMention(), false);
		eb.addField("   Muter user", muter.getAsMention(), false);
		eb.addField("   Reason", reason, false);
		eb.addField("   Date", sdf.format(date), false);
		eb.addField("   Time", stf.format(date), false);
		
		channel.sendMessage(eb.build()).queue();
		
	}
	
	private void logUnmute(Member muted, Member muter, String reason, TextChannel channel) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat stf = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		
		EmbedBuilder eb = new EmbedBuilder();
		eb.setAuthor("Unmute by " + muter.getUser().getName(), null, muter.getUser().getAvatarUrl());
		eb.setColor(Color.decode("#0652DD"));
		eb.addField("   Unuted user", muted.getAsMention(), false);
		eb.addField("   Unmuter user", muter.getAsMention(), false);
		eb.addField("   Reason", reason, false);
		eb.addField("   Date", sdf.format(date), false);
		eb.addField("   Time", stf.format(date), false);
		
		channel.sendMessage(eb.build()).queue();
		
	}
	
}
