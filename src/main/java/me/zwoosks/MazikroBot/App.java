package me.zwoosks.MazikroBot;

import java.awt.Color;

import ModeratorFunctions.BanFunction;
import ModeratorFunctions.ClearFunction;
import ModeratorFunctions.KickFunction;
import ModeratorFunctions.MessagerFunction;
import ModeratorFunctions.MuteFunction;
import ModeratorFunctions.TempMuteFunction;
import ModeratorFunctions.TempMuteManager;
import ModeratorFunctions.WarnFunction;
import channels_management.bot_suggestions;
import commands.ayuda;
import commands.estadoservidor;
import commands.foro;
import commands.forum;
import commands.help;
import commands.ip;
import commands.jugadoresonline;
import commands.onlineplayers;
import commands.play;
import commands.reglas;
import commands.rules;
import commands.serverstate;
import commands.store;
import commands.tienda;
import commands.version;
import commands.version_spanish;
import expSystemManager.DelayManager;
import expSystemManager.expSystem;
import funnyFunctions.AnimeImages;
import funnyFunctions.MemeImages;
import joinAndLeave.GuildJoinListener;
import logs.joinVoiceChannelListener;
import logs.leftVoiceChannelListener;
import messagers.catalanMessager;
import messagers.deutschMessager;
import messagers.englishMessager;
import messagers.spanishMessager;
import minecraft_linking.LinkFunction;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import permsManager.PermissionsManager;
import profileSystem.UserProfiles;
import rename.Renamer;

public class App extends ListenerAdapter {
    public static void main(String[] args) throws Exception {
    	
        @SuppressWarnings("deprecation")
		JDA jda = new JDABuilder(AccountType.BOT).setToken(Ref.token).buildBlocking();
        jda.getPresence().setGame(Game.playing("play.mazikro.com"));
        jda.setAutoReconnect(true);

        jda.addEventListener(new App());
        
        jda.addEventListener(new joinVoiceChannelListener());
        jda.addEventListener(new leftVoiceChannelListener());
        
        jda.addEventListener(new expSystem());
        
        jda.addEventListener(new GuildJoinListener());
        
        
        englishMessager eng = new englishMessager(jda);
        spanishMessager sp = new spanishMessager(jda);
        deutschMessager ger = new deutschMessager(jda);
        catalanMessager ca = new catalanMessager(jda);
        
        eng.start();
        sp.start();
        ger.start();
        ca.start();
        
        DelayManager.delayThread.start();
        
        TempMuteManager tmm = new TempMuteManager();
        tmm.run();
                
    }
    
    
    
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
    	
    	
    	
    	// Objects
    	User user = e.getAuthor();
    	Message message = e.getMessage();
    	
    	// Prefix
    	String pref = Ref.prefix;
    	
    	// Command
    	if(!e.getMessage().getAuthor().isBot() && e.getMessage().getContentRaw().substring(0, 1).equalsIgnoreCase(pref)) {
    		String args[] = e.getMessage().getContentRaw().split(" ");
        	String arg1 = args[0].toLowerCase();
        	String cmd = arg1.substring(1, arg1.length());
        	System.out.println(cmd);
        	
        	
        	if("a" == "a") {
        		
        		switch (cmd) {
    			case "onlineplayers":
    				onlineplayers meth = new onlineplayers();
    	    		meth.onlineplayersMethod(user, message);
    				break;
    			case "play":
    				play meth2 = new play();
    	    		meth2.playMethod(user, message);
    	    		break;
    			case "jugadoresonline":
    				jugadoresonline meth3 = new jugadoresonline();
    	    		meth3.jugadoresonolineMethod(user, message);
    	    		break;
    			case "ip":
    				ip meth4 = new ip();
    	    		meth4.ipMethod(user, message);
    	    		break;
    			case "forum":
    				forum meth5 = new forum();
    	    		meth5.forumMethod(user, message);
    	    		break;
    			case "foro":
    				foro meth6 = new foro();
    	    		meth6.foroMethod(user, message);
    	    		break;
    			case "help":
    				help meth7 = new help();
    	    		meth7.helpMethod(user, message);
    	    		break;
    			case "ayuda":
    				ayuda meth8 = new ayuda();
    	    		meth8.ayudaMethod(user, message);
    			case "rules":
    				rules meth9 = new rules();
    	    		meth9.rulesMethod(user, message);
    	    		break;
    			case "reglas":
    				reglas meth10 = new reglas();
    	    		meth10.reglasMethod(user, message);
    	    		break;
    			case "version":
    				version meth11 = new version();
    	    		meth11.versionMethod(user, message);
    	    		break;
    			case "versión":
    				version_spanish meth12 = new version_spanish();
    	    		meth12.versionSpanishMethod(user, message);
    	    		break;
    			case "serverstate":
    				serverstate meth13 = new serverstate();
    	    		meth13.serverstateMethod(user, message);
    	    		break;
    			case "estadoservidor":
    				estadoservidor meth14 = new estadoservidor();
    	    		meth14.estadoservidorMethod(user, message);
    	    		break;
    			case "store":
    				store meth15 = new store();
    	    		meth15.storeMethod(user, message);
    	    		break;
    			case "tienda":
    				tienda meth16 = new tienda();
    	    		meth16.tiendaMethod(user, message);
    	    		break;
    			case "language":
    				PermissionsManager meth17 = new PermissionsManager();
    				meth17.changePerms(message, e.getMember());
    			case "kick":
    				KickFunction meth18 = new KickFunction();
    				meth18.kikcMethod(e);
    				break;
    			case "ban":
    				BanFunction meth19 = new BanFunction();
    				meth19.banMethod(e);
    				break;
    			case "clear":
    				ClearFunction meth20 = new ClearFunction();
    				meth20.clearMethod(e);
    				break;
    			case "message":
    				MessagerFunction meth21 = new MessagerFunction();
    				meth21.messagerMethod(e);
    				break;
    			case "mute":
    				MuteFunction meth22 = new MuteFunction();
    				meth22.muteMethod(e);
    				break;
    			case "unmute":
    				MuteFunction meth23 = new MuteFunction();
    				meth23.muteMethod(e);
    				break;
    			case "warn":
    				WarnFunction meth24 = new WarnFunction();
    				meth24.warnMethod(e);
    				break;
    			case "minecraft":
    				LinkFunction meth25 = new LinkFunction();
    				meth25.linkMethod(e);
    				break;
    			case "tempmute":
    				TempMuteFunction meth26 = new TempMuteFunction();
    				meth26.tempMuteMethod(e);
    				break;
    			case "rename":
    				Renamer meth27 = new Renamer();
    				meth27.renameMethod(e);
    				break;
        	}
        		
        	
        		
        		
        		
        		
            	
        	}
        	
        	
        	switch(cmd) {
        	case "anime":
				AnimeImages meth25 = new AnimeImages();
				meth25.animeMethod(e);
				break;
			case "meme":
				MemeImages meth26 = new MemeImages();
				meth26.memeMethod(e);
				break;
			case "discord_name_to_member_object":
				Member usr = e.getGuild().getMembersByEffectiveName("zwoosks#5076", true).get(0);
				e.getChannel().sendMessage("Hi " + usr.getAsMention()).queue();
        	}
        		
        	// Profiles
        	if(cmd.equalsIgnoreCase("profile")) {
        		if(args.length <= 1) {
        			try {
            			UserProfiles up = new UserProfiles();
                		String prof = up.getProfile(e.getMessage().getMentionedMembers().get(0));
                		
                		EmbedBuilder eb = new EmbedBuilder();
                		
                		eb.setColor(new Color(102, 153, 255));
                		
                		// A baix del títol - text informatiu
                		eb.setDescription(prof);
                		    		
                		// Image
                		User profUser = e.getMessage().getMentionedUsers().get(0);
                		eb.setAuthor(profUser.getName() + "'s profile:", null, profUser.getAvatarUrl());
                		
                		message.getChannel().sendMessage(eb.build()).queue();
            		} catch(Exception ex) {
                		
                		EmbedBuilder eb = new EmbedBuilder();
                		
                		eb.setColor(Color.RED);
                		
                		// A baix del títol - text informatiu
                		UserProfiles up = new UserProfiles();
                		eb.setDescription(up.getProfile(e.getMessage().getMember()));
                		    		
                		// Image
                		User selfUser = e.getMessage().getAuthor();
                		eb.setAuthor(selfUser.getName() + "'s profile:", null, selfUser.getAvatarUrl());
                		
                		message.getChannel().sendMessage(eb.build()).queue();
            		}
        		} else {
        			
        			
        			// Own profile
        			
        			try {
            			UserProfiles up = new UserProfiles();
                		String prof = up.getProfile(e.getMessage().getMember());
                		
                		EmbedBuilder eb = new EmbedBuilder();
                		
                		eb.setColor(new Color(102, 153, 255));
                		
                		// A baix del títol - text informatiu
                		eb.setDescription(prof);
                		    		
                		// Image
                		User profUser = e.getMessage().getMentionedUsers().get(0);
                		eb.setAuthor(profUser.getName() + "'s profile:", null, profUser.getAvatarUrl());
                		
                		message.getChannel().sendMessage(eb.build()).queue();
            		} catch(Exception ex) {
                		
                		EmbedBuilder eb = new EmbedBuilder();
                		
                		
                		
                		eb.setColor(new Color(102, 153, 255));
                		
                		// A baix del títol - text informatiu
                		UserProfiles up = new UserProfiles();
                		eb.setDescription(up.getProfile(e.getMessage().getMember()));
                		    		
                		// Image
                		User selfUser = e.getMessage().getAuthor();
                		eb.setAuthor(selfUser.getName() + "'s profile:", null, selfUser.getAvatarUrl());
                		
                		message.getChannel().sendMessage(eb.build()).queue();
            		}
        			
        			// -----------------------------------------------------------------------------------------
        			
        			
        			
        		}
        	}
        	
        	if(cmd.equalsIgnoreCase("setprofile")) {
        		if(args.length == 1) {
        			EmbedBuilder eb = new EmbedBuilder();
            		
            		eb.setColor(Color.RED);
            		
            		// A baix del títol - text informatiu
            		eb.setDescription("Please, enter **>setprofile (your description)** to modify your profile! If you see this, probably you didn't give me arguments!");
            		    		
            		// Image
            		eb.setAuthor("Incorrect arguments", null, "https://i.imgur.com/9XM231V.png");
            		
            		message.getChannel().sendMessage(eb.build()).queue();
        		} else {
        			// Changing description
        			UserProfiles up = new UserProfiles();
        			up.enterProfile(e.getMember(), e.getMessage().getContentRaw().substring(11, e.getMessage().getContentRaw().length()));
        			
        			// Success
            		EmbedBuilder eb = new EmbedBuilder();
            		
            		eb.setColor(new Color(102, 153, 255));
            		
            		// A baix del títol - text informatiu
            		eb.setDescription("Profile saved successfully");
            		    		
            		// Image
            		eb.setAuthor("Your profile has been saved", null, e.getAuthor().getAvatarUrl());
            		
            		eb.addField("Your profile preview:", e.getMessage().getContentRaw().substring(11, e.getMessage().getContentRaw().length()), false);
            		
            		message.getChannel().sendMessage(eb.build()).queue();
        			
        		}
        	}
        		
        	}
    	
    	
    	
        	
        	
        	
    	
    	// Managing message channels
    	if(message.getChannel().getName().equalsIgnoreCase("bot-suggestions") && (!message.getAuthor().isBot())) {
    		bot_suggestions meth = new bot_suggestions();
    		meth.bot_suggestionsMethod(user, message);
    	}
    	
    	
    }
    
    
}
