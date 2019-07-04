package ModeratorFunctions;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import me.zwoosks.MazikroBot.Ref;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public class TempMuteFunction {
	
	public static HashMap<String, Integer> counter = new HashMap<String, Integer>();
	
	public void tempMuteMethod(GuildMessageReceivedEvent e) {
		
		String[] args = e.getMessage().getContentRaw().split(" ");
		
		if(args[0].equalsIgnoreCase(Ref.prefix + "tempmute")) {
			
			if(IsStaff.isStaff(e.getMember())) {
				
				if(args.length <= 3) {
					
					sendError(e.getChannel(), e.getMember());
					
				} else {
					
					// TempMute function
					
					Member tarjet = e.getMessage().getMentionedMembers().get(0);
					
					tarjet.getGuild().getController().addSingleRoleToMember(tarjet, e.getJDA().getRolesByName("Silenced", true).get(0)).queue();
					
					if(args.length >= 3) {
						
						// Temp mute with reason
						
						String reason = "";
						
						for(int i = 5; i < args.length; i++) {
							
							reason += args[i] + " ";
							
						}
						
						try {
							
							int days = Integer.parseInt(args[2]);
							int hours = Integer.parseInt(args[2]);
							int minutes = Integer.parseInt(args[2]);
							
							long totalMinutes = (minutes) + (hours * 60) + ((days * 24) * 60);
							
//							tempMute(e.getMember(), totalMinutes);
							TempMuteManager.member.put(tarjet.getUser().getName(), tarjet);
							TempMuteManager.time.put(tarjet.getUser().getName(), totalMinutes);
							
							
							log(tarjet, e.getMember(), reason, e.getJDA().getTextChannelById("517726920058601492"), args[2], args[3], args[4]);
							
						} catch(Exception ex) {
							
							sendError(e.getChannel(), e.getMember());
							
						}
						
					} else {
						
						// Temp mute with no reason specified
						
						try {
							
							int days = Integer.parseInt(args[2]);
							int hours = Integer.parseInt(args[2]);
							int minutes = Integer.parseInt(args[2]);
							
							long totalMinutes = (minutes) + (hours * 60) + ((days * 24) * 60);
							
							TempMuteManager.member.put(tarjet.getUser().getName(), tarjet);
							TempMuteManager.time.put(tarjet.getUser().getName(), totalMinutes);
							
							log(tarjet, e.getMember(), "No reason specified.", e.getJDA().getTextChannelById("517726920058601492"), args[2], args[3], args[4]);
							
						} catch(Exception ex) {
							
							sendError(e.getChannel(), e.getMember());
							
						}
						
					}
					
				}
				
			} else {
				
				noPerms(e.getChannel(), e.getMember());
				
			}
			
		}
		
	}
	
	
	private void noPerms(TextChannel channel, Member member) {
		
		EmbedBuilder eb = new EmbedBuilder();
		
		eb.setColor(Color.red);
		
		// A baix del títol - text informatiu
		eb.setDescription("");
		
		eb.setTitle("You don't have permissions!");
		eb.setDescription("Sorry, but you aren't an administrator!");
		
		// Image
		eb.setAuthor(member.getUser().getName(), null, member.getUser().getAvatarUrl());
		
		channel.sendMessage(eb.build()).queue();
		
	}
	
	private void sendError(TextChannel channel, Member member) {
		
		EmbedBuilder eb = new EmbedBuilder();
		
		eb.setColor(Color.red);
		
		// A baix del títol - text informatiu
		eb.setDescription("");
		
		eb.setTitle("Invalid usage");
		eb.setDescription("{} = required, [] = optional.");
		eb.addField("Proper usage: !TempMute {@user} {days} {hours} {minutes} [reason]", "", false);
		
		// Image
		eb.setAuthor(member.getUser().getName(), null, member.getUser().getAvatarUrl());
		
		channel.sendMessage(eb.build()).queue();
		
	}
	
	private void log(Member muted, Member muter, String reason, TextChannel channel, String days, String hours, String minutes) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat stf = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		
		EmbedBuilder eb = new EmbedBuilder();
		eb.setAuthor("Temporal mute by " + muter.getUser().getName(), null, muter.getUser().getAvatarUrl());
		eb.setColor(Color.decode("#0652DD"));
		eb.addField("Muted user", muted.getAsMention(), false);
		eb.addField("Muter user", muter.getAsMention(), false);
		eb.addField("Reason", reason, false);
		eb.addField("Duration", days + " days, " + hours + " hours and " + minutes + " minutes.", false);
		eb.addField("Date", sdf.format(date), false);
		eb.addField("Time", stf.format(date), false);
		
		channel.sendMessage(eb.build()).queue();
		
	}
	
	
}
