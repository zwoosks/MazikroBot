package messagers;

import java.util.concurrent.TimeUnit;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;

public class catalanMessager extends Thread {

	private JDA jda;
	
	public catalanMessager(JDA jda) {
		
		this.jda = jda;
		
	}
	
	@Override
	public void run() {
		
		boolean asd = true;
		
		while(asd == true) {
			
			TextChannel channel = jda.getTextChannelById("519655132707684373");
			
			Message msg = channel.getMessageById(channel.getLatestMessageIdLong()).complete();
			
			if(msg.getAuthor().isBot() == false) {
				
				channel.sendMessage("Recorda que aquest canal només està fet per parlar del servidor i del joc, però no per a fer spam. Si ho fas, el teu missatge serà eliminat i tu sancionat.").queue();
				
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