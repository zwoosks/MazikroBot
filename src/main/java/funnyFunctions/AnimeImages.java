package funnyFunctions;

import java.io.File;
import java.util.Random;

import me.zwoosks.MazikroBot.Ref;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public class AnimeImages {
	
	public void animeMethod(GuildMessageReceivedEvent e) {
		
		String[] args = e.getMessage().getContentRaw().split(" ");
		
		if(e.getChannel().getId().equalsIgnoreCase("517804191939297282")) {
			
			if(args[0].equalsIgnoreCase(Ref.prefix + "anime")) {
				
				try {
					Random r = new Random();
					int rand = r.nextInt(472) + 1;
					String finalPath = "/home/pi/Desktop/Mazikro/anime/" + Integer.toString(rand) + ".png";
					e.getChannel().sendFile(new File(finalPath)).queue();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		}
		
	}
	
}
