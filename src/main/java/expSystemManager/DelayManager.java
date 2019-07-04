package expSystemManager;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class DelayManager {
	
	public static HashMap<String, Integer> playerTimer = new HashMap<String, Integer>();
	
	public static Thread delayThread = new Thread() {
	      public void run(){
	        while(true) {
	        	
	        	for(String str : playerTimer.keySet()) {
	        		if(!(playerTimer.get(str) == 0)) {
	        			HashDelayManager.modifyHash(str, false);
	        			playerTimer.put(str, playerTimer.get(str) - 1);
	        		} else {
	        			HashDelayManager.users.put(str, true);
	        		}
	        	}
	        	
	        	
	        	// Sleep 1 seconds
	        	try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	      }
	   };

}
