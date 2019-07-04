package messagers;

import java.util.concurrent.TimeUnit;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;

public class englishMessager extends Thread {

	private JDA jda;
	
	public englishMessager(JDA jda) {
		
		this.jda = jda;
		
	}
	
	@Override
	public void run() {
		
		boolean asd = true;
		
		while(asd == true) {
			
			TextChannel channel = jda.getTextChannelById("518819205143855104");
			
			Message msg = channel.getMessageById(channel.getLatestMessageIdLong()).complete();
			
			if(msg.getAuthor().isBot() == false) {
				
				channel.sendMessage("Remember that this channel is only made for talking about the server and other, but not spamming. If you do that, your message will be deleted and you banned.").queue();
				
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
