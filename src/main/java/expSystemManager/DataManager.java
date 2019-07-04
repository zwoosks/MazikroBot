package expSystemManager;

import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import net.dv8tion.jda.core.entities.Member;

public class DataManager {
	
	public static final String url = "jdbc:mysql://198.245.51.96:3306/db_43385";
    public static final String username = "db_43385";
    public static final String password = "f5d3f63a4e";
    
    PreparedStatement ps;
    ResultSet rs;
	
	public static Connection getConnection() {
	    Connection con = null;
	    
	    try {
	        Class.forName("com.mysql.jdbc.Driver");
	        con = (Connection) DriverManager.getConnection(url, username, password);
	    } catch(Exception e) {
	    	JOptionPane.showMessageDialog(null, "Error al intentar conectarse a la base de datos");
	        e.printStackTrace();
	    }
	    
	    return con;
	    
	}
	
	
	
	public int getXP(Member member) {
		Connection con = null;
		String discord_id = member.getUser().getId();
        
        try {
            
            con = getConnection();
            ps = (PreparedStatement) con.prepareStatement("SELECT * FROM xp_table WHERE discord_id = ?");
            ps.setString(1, discord_id);
            
            rs = ps.executeQuery();
            
            if(rs.next()) {
            	return rs.getInt("experience");
            } else {
                System.out.println("No existe una persona con esta clave");
                return 0;
            }
            
        } catch(Exception e) {
            e.printStackTrace();
            return 0;
        }
	}
	
	
	
	// MySQL
	public void modificarXP(Member member, int toAdd) {
		Connection con = null;
		
		int newXP = getXP(member) + toAdd;
		
	    try {
	        
	        con = getConnection();
	        ps = (PreparedStatement) con.prepareStatement("UPDATE xp_table SET experience = ? WHERE discord_id = ?");
	        ps.setInt(1, newXP);
	        ps.setString(2, member.getUser().getId());
	        
	        int res = ps.executeUpdate();
	        
	        if(res > 0) {
	        	System.out.println("Persona modificada exitosamente");
	        } else {
	        	System.out.println("Error al modificar persona");
	        	// Crear
	        	crearFila(member, toAdd);
	        }
	        
	        con.close();
	        
	    } catch(Exception e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "debug");
	    }
	}
	
	
	
	public void crearFila(Member member, int initialEXP) {
		Connection con = null;
        try {
            
            con = getConnection();
            ps = (PreparedStatement) con.prepareStatement("INSERT INTO xp_table (discord_id, experience) VALUES (?,?)");
            ps.setString(1, member.getUser().getId());
            ps.setInt(2, initialEXP);
            
            int res = ps.executeUpdate();
            
            if(res > 0) {
            	System.out.println("Persona guardada exitosamente");
            } else {
            	System.out.println("Error al guardar persona");
            }
            
            con.close();
            
        } catch(Exception e) {
            e.printStackTrace();
        }
	}
	
	
	
	
	
	
}
