package ModeratorFunctions;

import java.awt.Color;

import me.zwoosks.MazikroBot.Ref;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public class MessagerFunction {
	
	public void messagerMethod(GuildMessageReceivedEvent e) {
		
		String[] args = e.getMessage().getContentRaw().split(" ");
		
		if(args[0].equalsIgnoreCase(Ref.prefix + "message")) {
			
			
			if(IsStaff.isStaff(e.getMember())) {
				
				
				if(args.length <= 1) {
					
					sendError(e.getChannel(), e.getMember());
					
				} else {
					
					if(args.length >= 3) {
						
						String message = "";
						TextChannel tarjet = e.getMessage().getMentionedChannels().get(0);
						
						for(int i = 2; i < args.length; i++) {
							message += args[i] + " ";
						}
						
						tarjet.sendMessage(message).queue();
						
					} else {
						sendError(e.getChannel(), e.getMember());
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
		eb.addField("Proper usage: !message {#channel} {message}", "", false);
		
		// Image
		eb.setAuthor(member.getUser().getName(), null, "https://i.imgur.com/9XM231V.png");
		
		channel.sendMessage(eb.build()).queue();
	}
	
}
