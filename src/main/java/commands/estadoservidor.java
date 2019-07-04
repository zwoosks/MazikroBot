package commands;

import java.awt.Color;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.User;

public class estadoservidor {

	public void estadoservidorMethod(User user, Message message) {
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
           
           
            
            // If it's online...
            EmbedBuilder eb = new EmbedBuilder();
    		
    		eb.setColor(new Color(102, 153, 255));
    		
    		// A baix del títol - text informatiu
    		eb.setDescription("Hola " + user.getName() + ". Mazikro actualmente está online.");
    		
    		// NO TOCAR
    		eb.addField("Obtén más comandos con **>ayuda**", "", false);
    		
    		// Image
    		eb.setAuthor("Estado del servidor", null, "https://i.imgur.com/9XM231V.png");
    		
    		message.getChannel().sendMessage(eb.build()).queue();
            
		} catch (Exception evt) {
            
			// If it's online...
            EmbedBuilder eb = new EmbedBuilder();
    		
    		eb.setColor(new Color(255, 0, 0));
    		
    		// A baix del títol - text informatiu
    		eb.setDescription("Hola " + user.getName() + ". Mazikro actualmente está offline.");
    		    		
    		// Image
    		eb.setAuthor("Estado del servidor", null, "https://i.imgur.com/9XM231V.png");
    		
    		message.getChannel().sendMessage(eb.build()).queue();
            
		}
		
	}
	
}
