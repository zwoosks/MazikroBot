package expSystemManager;

import java.util.HashMap;

import net.dv8tion.jda.core.entities.User;

public class HashDelayManager {

	public static HashMap<String, Boolean> users = new HashMap<String, Boolean>();
	
	public static boolean isAviable(User user) {
		if(users.containsKey(user.getName())) {
			return users.get(user.getName());
		}
		return true;
	}
	
	public static void modifyHash(String userName, boolean bol) {
		users.put(userName, bol);
	}
	
}
