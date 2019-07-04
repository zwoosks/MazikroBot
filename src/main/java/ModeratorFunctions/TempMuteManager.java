package ModeratorFunctions;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import net.dv8tion.jda.core.entities.Member;

public class TempMuteManager implements Runnable {
	
	public static HashMap<String, Member> member = new HashMap<String, Member>();
	public static HashMap<String, Long> time = new HashMap<String, Long>();
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while(true) {
			
			for(String nameMember : time.keySet()) {
				
				time.put(nameMember, time.get(nameMember) - 1);
				
				// Check if finished
				
				if(time.get(nameMember) <= 0) {
					
					time.remove(nameMember);
					
					Member tarjet = member.get(nameMember);
					
					tarjet.getGuild().getController().removeSingleRoleFromMember(tarjet, tarjet.getJDA().getRolesByName("Silenced", true).get(0)).queue();
					
					member.remove(nameMember);
					
				}
				
			}
			
			
			try {
				TimeUnit.MINUTES.sleep(1L);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	
	
}
