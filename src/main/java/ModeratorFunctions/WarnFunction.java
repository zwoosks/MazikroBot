package ModeratorFunctions;

import java.awt.Color;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

import me.zwoosks.MazikroBot.Ref;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public class WarnFunction {
	
	public void warnMethod(GuildMessageReceivedEvent e) {
		
		String[] args = e.getMessage().getContentRaw().split(" ");
		
		if(args[0].equalsIgnoreCase(Ref.prefix + "warn")) {
			if(IsStaff.isStaff(e.getMember())) {
				
				if(args.length <= 1) {
					sendError(e.getChannel(), e.getMember());
				} else {
					WarnDataManager wdm = new WarnDataManager();
					int actualWarns = wdm.getWarns(e.getMember());
					
					Member tarjet = e.getMessage().getMentionedMembers().get(0);
					
					if(args.length >= 3) {
						
						String reason = "";
						
						for(int i = 2; i < args.length; i++) {
							reason += args[i] + " ";
						}
						
						wdm.modificarWarns(e.getMember(), 1);
						log(tarjet, e.getMember(), reason, e.getGuild().getTextChannelById("517726920058601492"));
						
					} else {
						wdm.modificarWarns(e.getMember(), 1);
						log(tarjet, e.getMember(), "Reason not specified.", e.getGuild().getTextChannelById("517726920058601492"));
					}
					
					
					if(actualWarns == 2) {
						
						wdm.modificarWarns(e.getMember(), 1);
						e.getMessage().getMentionedMembers().get(0).getGuild().getController().ban(e.getMessage().getMentionedMembers().get(0), 10, "").queue();
						logBan(e.getMessage().getMentionedMembers().get(0), e.getMember(), e.getJDA().getTextChannelById(517726920058601492L));
						
					}
					
					
				}
				
			}
		}
		
		
		
		
		
		
		
		
		
		
		Pattern p = Pattern.compile("[^.]+[.][^.]+");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(e.getMessage().getContentRaw());
		while (scanner.hasNext()) {
		    if (scanner.hasNext(p)) {
		        String possibleUrl = scanner.next(p);
		        if (!possibleUrl.contains("://")) {
		            possibleUrl = "http://" + possibleUrl;
		        }

		        try {
		            @SuppressWarnings("unused")
					URL url = new URL(possibleUrl);
		            // Do something with the url
		            WarnDataManager wdm = new WarnDataManager();
		            wdm.modificarWarns(e.getMember(), 1);
		            log(e.getMember(), e.getGuild().getMemberById("487596390336299009"), "Posted a link.", e.getJDA().getTextChannelById("517726920058601492"));
		            int actualwarns = wdm.getWarns(e.getMember());
		            if(actualwarns == 3) {
		            	
						e.getMember().getGuild().getController().ban(e.getMember(), 10, "").queue();
						logBan(e.getMessage().getMentionedMembers().get(0), e.getMember(), e.getJDA().getTextChannelById(517726920058601492L));
						
					}
		            e.getMessage().delete().queue();
		        } catch (MalformedURLException e2) {
		            continue;
		        }
		    } else {
		        scanner.next();
		    }
		}
		
		
		
	}
	
	
	private void sendError(TextChannel channel, Member member) {
		EmbedBuilder eb = new EmbedBuilder();
		
		eb.setColor(Color.red);
		
		// A baix del títol - text informatiu
		eb.setDescription("");
		
		eb.setTitle("Invalid usage");
		eb.setDescription("{} = required, [] = optional.");
		eb.addField("Proper usage: !warn {@user} [reason]", "", false);
		
		// Image
		eb.setAuthor(member.getUser().getName(), null, "https://i.imgur.com/9XM231V.png");
		
		channel.sendMessage(eb.build()).queue();
	}
	
	private void log(Member muted, Member muter, String reason, TextChannel channel) {
		WarnDataManager wdm = new WarnDataManager();
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat stf = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		
		EmbedBuilder eb = new EmbedBuilder();
		eb.setAuthor("Warn by " + muter.getUser().getName(), null, muter.getUser().getAvatarUrl());
		eb.setColor(Color.decode("#0652DD"));
		eb.addField("Warned user", muted.getAsMention(), false);
		eb.addField("Warner user", muter.getAsMention(), false);
		eb.addField("Reason", reason, false);
		eb.addField("Actual warns", Integer.toString(wdm.getWarns(muted)), false);
		eb.addField("Date", sdf.format(date), false);
		eb.addField("Time", stf.format(date), false);
		
		channel.sendMessage(eb.build()).queue();
		
	}
	
	private void logBan(Member muted, Member muter, TextChannel channel) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat stf = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		
		EmbedBuilder eb = new EmbedBuilder();
		eb.setAuthor("Ban by " + muter.getGuild().getMemberById(487596390336299009L), null, muter.getGuild().getMemberById(487596390336299009L).getUser().getAvatarUrl());
		eb.setColor(Color.decode("#0652DD"));
		eb.addField("   Banned user", muted.getAsMention(), false);
		eb.addField("   Last warner user", muter.getAsMention(), false);
		eb.addField("   Date", sdf.format(date), false);
		eb.addField("   Time", stf.format(date), false);
		
		channel.sendMessage(eb.build()).queue();
		
	}
	
}
