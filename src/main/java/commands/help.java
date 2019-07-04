package commands;

import java.awt.Color;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.User;

public class help {

	public void helpMethod(User user, Message message) {
		
		EmbedBuilder eb = new EmbedBuilder();
		
		eb.setColor(new Color(102, 153, 255));
		
		// Image
		eb.setAuthor("Help", null, "https://i.imgur.com/9XM231V.png");
		
		eb.setDescription("");
		
		
		eb.addField("**Rules**", "Use _!rules_ to read our Discord server rules.", false);
		eb.addField("**Minecraft server**", "Use _!ip_ or _!play_ to get Mazikro Minecraft server IP.", false);
		eb.addField("**Server state**", "Use _!serverstate_ to know if Mazikro is currently online or offline.", false);
		eb.addField("**Online players**", "Use _!onlineplayers_ to get how many much players are connected to Mazikro Network.", false);
		eb.addField("**Forum**", "Use _!forum_ to get the web address of Mazikro english forums.", false);
		eb.addField("**Bot suggerences**", "Send your bot suggerences to help us in  _#bot-suggerences_ channel.", false);
		eb.addField("**Experience**", "Obtain you actual level of XP with _!xp_. You'll receive an amout of XP everytime that you send a message!", false);
		eb.addField("**Language**", "Specify your language with _!language_. @mention your language, in your case probably @english_.", false);
		eb.addField("**Create your profile**", "Use _!setprofile (A little description about you)_ to create a Discord profile.", false);
		eb.addField("**View other profiles**", "Use _!profile (@mention the profile that do you want to view)_ to see the profile of an user.", false);
		eb.addField("**Version**", "Use _!version_ to get our Discord bot version.", false);
		
		message.getChannel().sendMessage(eb.build()).queue();
		
		// --------------------------------------------------------------------
		
		EmbedBuilder eb2 = new EmbedBuilder();
		
		eb.setColor(Color.cyan);
		
		eb.setAuthor("Funny commands", null, "https://i.imgur.com/9XM231V.png");
		
		eb2.addField("**8ball***", "Magic 8-Ball. Use this with **!8ball {text}**", false);
		eb2.addField("**Anime***", "Watch anime images with **!anime**. Only disponible in **#anime** channel.", false);
		eb2.addField("**Memes***", "Watch memes with **!meme**. Only disponible in **#memes** channel.", false);
		
		message.getChannel().sendMessage(eb2.build()).queue();
		
		
		
	}
	
}
