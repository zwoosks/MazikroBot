package commands;

import java.awt.Color;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.User;

public class jugadoresonline {

	public void jugadoresonolineMethod(User user, Message message) {
		
		message.delete().queue();
		try {
            @SuppressWarnings("resource")
			Socket socket = new Socket();
            socket.connect(new InetSocketAddress("142.44.157.248", 25632), 1 * 1000);
           
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());
           
            out.write(0xFE);
           
            StringBuilder str = new StringBuilder();
           
            int b;
            while ((b = in.read()) != -1) {
                    if (b != 0 && b > 16 && b != 255 && b != 23 && b != 24) {
                            str.append((char) b);
                    }
            }
           
            String[] data = str.toString().split("§");
            int onlinePlayers = Integer.valueOf(data[1]);
            int maxPlayers = Integer.valueOf(data[2]);
           
            
            //Send online players to the channel
            
            EmbedBuilder eb = new EmbedBuilder();
    		
    		eb.setColor(new Color(102, 153, 255));
    		
    		// A baix del títol - text informatiu
    		eb.setDescription("Hay " + onlinePlayers + "/" + maxPlayers + " jugadores conectados!\n_¡Entra a nuestro servidor!_\nIP: **play.mazikro.com**");
    		    		
    		// Image
    		eb.setAuthor("Jugadores online", null, "https://i.imgur.com/9XM231V.png");
    		
    		message.getChannel().sendMessage(eb.build()).queue();
            
            
		} catch (Exception evt) {
            
            EmbedBuilder eb = new EmbedBuilder();
    		
    		eb.setColor(new Color(255, 0, 0));
    		
    		// A baix del títol - text informatiu
    		eb.setDescription("El servidor se encuentra offline.");
    		    		
    		// Image
    		eb.setAuthor("Jugadores online", null, "https://i.imgur.com/9XM231V.png");	
            
		}
		
	}
	
}
