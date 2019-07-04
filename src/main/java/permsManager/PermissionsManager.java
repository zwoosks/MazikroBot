package permsManager;

import java.awt.Color;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;

public class PermissionsManager {
	
	public void changePerms(Message message, Member member) {
		
		if(hasSet(member) <= 2) {
			if(message.getMentionedRoles().get(0).getName().equalsIgnoreCase("dutch")) {
				message.getGuild().getController().addRolesToMember(member, message.getMentionedRoles().get(0)).queue();
				successMSG(message);
				addUserLang(member);
			} else if(message.getMentionedRoles().get(0).getName().equalsIgnoreCase("spanish")) {
				message.getGuild().getController().addRolesToMember(member, message.getMentionedRoles().get(0)).queue();
				successMSG(message);
				addUserLang(member);
			} else if(message.getMentionedRoles().get(0).getName().equalsIgnoreCase("italian")) {
				message.getGuild().getController().addRolesToMember(member, message.getMentionedRoles().get(0)).queue();
				successMSG(message);
				addUserLang(member);
			} else if(message.getMentionedRoles().get(0).getName().equalsIgnoreCase("english")) {
				message.getGuild().getController().addRolesToMember(member, message.getMentionedRoles().get(0)).queue();
				successMSG(message);
				addUserLang(member);
			} else if(message.getMentionedRoles().get(0).getName().equalsIgnoreCase("german")) {
				message.getGuild().getController().addRolesToMember(member, message.getMentionedRoles().get(0)).queue();
				successMSG(message);
				addUserLang(member);
			} else if(message.getMentionedRoles().get(0).getName().equalsIgnoreCase("french")) {
				message.getGuild().getController().addRolesToMember(member, message.getMentionedRoles().get(0)).queue();
				successMSG(message);
				addUserLang(member);
			} else if(message.getMentionedRoles().get(0).getName().equalsIgnoreCase("portuguese")) {
				message.getGuild().getController().addRolesToMember(member, message.getMentionedRoles().get(0)).queue();
				successMSG(message);
				addUserLang(member);
			} else if(message.getMentionedRoles().get(0).getName().equalsIgnoreCase("polish")) {
				message.getGuild().getController().addRolesToMember(member, message.getMentionedRoles().get(0)).queue();
				successMSG(message);
				addUserLang(member);
			} else {
				dontTry(message);
			}
		} else {
			// Already set
			alreadySet(message);
		}
		
		
	}
	
	private void successMSG(Message message) {
		EmbedBuilder eb = new EmbedBuilder();
		
		eb.setColor(new Color(230, 184, 0));
		
		// A baix del títol - text informatiu
		eb.setDescription("You've succefully changed your language role!");
		    		
		// Image
		eb.setAuthor("Language", null, "https://i.imgur.com/9XM231V.png");
		
		message.getChannel().sendMessage(eb.build()).queue();
	}
	
	
	private void dontTry(Message message) {
		EmbedBuilder eb = new EmbedBuilder();
		
		eb.setColor(new Color(230, 184, 0));
		
		// A baix del títol - text informatiu
		eb.setDescription("Don't try to give yourself other roles!");
		    		
		// Image
		eb.setAuthor("Language", null, "https://i.imgur.com/9XM231V.png");
		
		message.getChannel().sendMessage(eb.build()).queue();
	}
	
	private void addUserLang(Member member) {
		PermsDataManager pdm = new PermsDataManager();
		pdm.modificarFila(member, 1);
	}
	
	private int hasSet(Member member) {
		PermsDataManager pdm = new PermsDataManager();
		return pdm.getInt(member);
	}
	
	private void alreadySet(Message message) {
		
		EmbedBuilder eb = new EmbedBuilder();
		
		eb.setColor(new Color(255, 0, 0));
		
		// A baix del títol - text informatiu
		eb.setDescription("You can't change anymore your language!");
		    		
		// Image
		eb.setAuthor("Language", null, "https://i.imgur.com/9XM231V.png");
		
		message.getChannel().sendMessage(eb.build()).queue();
		
	}
	
}
