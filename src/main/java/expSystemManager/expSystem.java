package expSystemManager;

import java.awt.Color;
import java.util.Random;

import me.zwoosks.MazikroBot.Ref;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class expSystem extends ListenerAdapter {
	
	public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
		String pref = Ref.prefix;
		String[] args = e.getMessage().getContentRaw().split(" ");
		
		if(!e.getMessage().getAuthor().isBot()) {
			if(e.getMessage().getContentRaw().substring(0, 1).equalsIgnoreCase(pref)) {
				if(args[0].equalsIgnoreCase(pref + "xp")) {
					
					DataManager dm = new DataManager();
					
					EmbedBuilder eb = new EmbedBuilder();
					
					eb.setColor(new Color(255, 153, 0));
					
					eb.setDescription("You currently have " + dm.getXP(e.getMember()) + " of experience!");
					
					eb.addField("Experience booster:", "1.0x", false);
					
					// Image
					eb.setAuthor(e.getAuthor().getName() + "'s Experience:", null, e.getAuthor().getAvatarUrl());
					
					e.getChannel().sendMessage(eb.build()).queue();
					
				}
			} else if(!e.getMessage().getChannel().getName().equalsIgnoreCase("bot-suggestions")) {
				// EXP system
				
				if(HashDelayManager.isAviable(e.getMember().getUser())) {
					
					Random random = new Random();
					int randXP = random.nextInt(10) + 1;
					
					DataManager dm = new DataManager();
					dm.modificarXP(e.getMember(), randXP);
					
				}
				
			}
			
			DelayManager.playerTimer.put(e.getAuthor().getName(), 10);
		}
		
	}
	
}
