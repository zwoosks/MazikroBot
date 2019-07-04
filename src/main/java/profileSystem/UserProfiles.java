package profileSystem;

import net.dv8tion.jda.core.entities.Member;

public class UserProfiles {
	
	public void enterProfile(Member member, String description) {
		ProfileDataManager pdm = new ProfileDataManager();
		pdm.modificarPerfil(member, description);
	}
	
	public String getProfile(Member member) {
		ProfileDataManager pdm = new ProfileDataManager();
		String perfil = pdm.getProfile(member);
		return perfil;
	}
	
}
