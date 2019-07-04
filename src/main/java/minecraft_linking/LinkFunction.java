package minecraft_linking;

import java.awt.Color;

import me.zwoosks.MazikroBot.Ref;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public class LinkFunction {
	
	public void linkMethod(GuildMessageReceivedEvent e) {
		
		String[] args = e.getMessage().getContentRaw().split(" ");
		
		if(args[0].equalsIgnoreCase(Ref.prefix + "minecraft")) {
			
			String minecraftName = args[1];
			
			LinkDataManager db_method = new LinkDataManager();
			
			try {
				
				db_method.modificarTabla(e.getMember(), minecraftName);
				
				success(e.getChannel(), e.getAuthor());
				
			} catch(Exception ex) {
				
				ex.printStackTrace();
				
			}
			
		}
		
	}
	
	private void success(TextChannel channel, User user) {
		
		EmbedBuilder eb = new EmbedBuilder();
		
		eb.setColor(new Color(102, 153, 255));
		
		// A baix del títol
		
		eb.setDescription("Hi " + user.getAsMention() + " ! Thanks for registering you Minecraft username!");
		eb.addField("Complete the steps", "Now, to complete all the process, you'll have to join our minecraft server and type /discord {discord id}. But don't worry about the Discord id! We've sent your id in your private message.", false);
		
		// Image
		eb.setAuthor("Ayuda", null, "https://i.imgur.com/9XM231V.png");
		
		channel.sendMessage(eb.build()).queue();
		
		privateMessage(user, user.getId());
		
	}
	
	private void privateMessage(User user, String id) {
		
		EmbedBuilder eb = new EmbedBuilder();
		
		eb.setColor(new Color(102, 153, 255));
		
		// A baix del títol
		
		eb.setDescription("Hi " + user.getAsMention() + " ! Thanks for registering you Minecraft username!");
		eb.addField("Your Discord id", "To finalize all the process, now you'll have to put the following command on our Minecraft server, exactly in the Lobby.", false);
		eb.addField("You command", "Your command is **/discord " + id + "**.", false);
		
		// Image
		eb.setAuthor("Minecraft and Discord", null, "https://i.imgur.com/9XM231V.png");
		
		user.openPrivateChannel().queue((channel) ->
        {
            channel.sendMessage(eb.build()).queue();
        });
		
	}
	
}
