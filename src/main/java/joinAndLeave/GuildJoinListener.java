package joinAndLeave;

import java.time.OffsetDateTime;
import java.util.List;

import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.events.guild.GuildJoinEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class GuildJoinListener extends ListenerAdapter {
	
	public void onGuildJoin(GuildJoinEvent e) {
		
		if(e.getGuild().getId().equalsIgnoreCase("483162429292019725")) {
			
			// If it's Mazikro Guild
			List<Member> members = e.getGuild().getMembers();
			
			Member lastest = e.getGuild().getMembers().get(0);
			
			for(Member member : members) {
				
				OffsetDateTime dateFor = member.getJoinDate();
				OffsetDateTime dateLastest = lastest.getJoinDate();
				
				if(dateFor.isAfter(dateLastest)) {
					
					lastest = member;
					
				}
				
			}
			
			lastest.getUser().openPrivateChannel().queue((channel) ->
	        {
	            channel.sendMessage("Hello! This is a test").queue();
	        });
			
		}
		
	}
	
}
