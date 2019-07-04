package ModeratorFunctions;

import net.dv8tion.jda.core.entities.Member;

public class IsStaff {
	
	public static boolean isStaff(Member e) {
		
		if(e.getRoles().contains(e.getGuild().getRolesByName("Administrator", true).get(0))) {
			return true;
		} else {
			return false;
		}
		
	}
	
}
