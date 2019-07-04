package messagers;

import java.util.concurrent.TimeUnit;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;

public class everythingelseMessager extends Thread {

	private JDA jda;
	
	public everythingelseMessager(JDA jda) {
		
		this.jda = jda;
		
	}
	
	@Override
	public void run() {
		
		boolean asd = true;
		
		while(asd == true) {
			
			TextChannel channel = jda.getTextChannelById("517754014725701647");
			
			Message msg = channel.getMessageById(channel.getLatestMessageIdLong()).complete();
			
			if(msg.getAuthor().isBot() == false) {
				
				channel.sendMessage("This is an off topic channel, but it's not a spam channel. If you do it, your message will be deleted and you banned.").queue();
				
			}
			
			try {
				TimeUnit.HOURS.sleep(12);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
		
	}
	
}