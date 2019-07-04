package funnyFunctions;

import java.io.File;
import java.util.Random;

import me.zwoosks.MazikroBot.Ref;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public class MemeImages {
	
	public void memeMethod(GuildMessageReceivedEvent e) {
		
		String[] args = e.getMessage().getContentRaw().split(" ");
		
		e.getMessage().getChannel().sendMessage("debug").queue();
		
		if(e.getChannel().getId().equalsIgnoreCase("517753946547290122")) {
			
			e.getMessage().getChannel().sendMessage("debug n2").queue();
			
			if(args[0].equalsIgnoreCase(Ref.prefix + "meme")) {
				
				e.getMessage().getChannel().sendMessage("debug n3 - taco").queue();
				
				try {
					Random r = new Random();
					int rand = r.nextInt(695) + 1;
					String finalPath = "/home/pi/Desktop/Mazikro/memes/" + Integer.toString(rand) + ".jpg";
					e.getChannel().sendFile(new File(finalPath)).queue();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
					e.getMessage().getChannel().sendMessage("debug n4 - couln't load the image").queue();
					
				}
				
			}
			
		}
		
	}
	
}
