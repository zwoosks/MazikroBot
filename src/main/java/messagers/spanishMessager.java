package messagers;

import java.util.concurrent.TimeUnit;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;

public class spanishMessager extends Thread {

	private JDA jda;
	
	public spanishMessager(JDA jda) {
		
		this.jda = jda;
		
	}
	
	@Override
	public void run() {
		
		boolean asd = true;
		
		while(asd == true) {
			
			TextChannel channel = jda.getTextChannelById("518819414657728554");
			
			Message msg = channel.getMessageById(channel.getLatestMessageIdLong()).complete();
			
			if(msg.getAuthor().isBot() == false) {
				
				channel.sendMessage("Recuerda que este canal solamente está hecho para hablar del servidor y otros, pero no para spamear. Si lo haces, tu mensaje será eliminado y tú baneado.").queue();
				
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