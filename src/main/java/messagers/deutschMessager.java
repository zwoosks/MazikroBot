package messagers;

import java.util.concurrent.TimeUnit;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;

public class deutschMessager extends Thread {

	private JDA jda;
	
	public deutschMessager(JDA jda) {
		
		this.jda = jda;
		
	}
	
	@Override
	public void run() {
		
		boolean asd = true;
		
		while(asd == true) {
			
			TextChannel channel = jda.getTextChannelsByName("allgemein", true).get(0);
			
			Message msg = channel.getMessageById(channel.getLatestMessageIdLong()).complete();
			
			if(msg.getAuthor().isBot() == false) {
				
				channel.sendMessage("to be translated").queue();
				
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