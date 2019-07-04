package profileSystem;

import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import net.dv8tion.jda.core.entities.Member;

public class ProfileDataManager {
	
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
	
	
	public String getProfile(Member member) {
		Connection con = null;
		String discord_id = member.getUser().getId();
        
        try {
            
            con = getConnection();
            ps = (PreparedStatement) con.prepareStatement("SELECT * FROM user_profiles WHERE discord_id = ?");
            ps.setString(1, discord_id);
            
            rs = ps.executeQuery();
            
            if(rs.next()) {
            	return rs.getString("description");
            } else {
                return "I'm sorry, but this person doesn't have a profile!";
            }
            
        } catch(Exception e) {
            e.printStackTrace();
            return "I'm sorry, but this person doesn't have a profile!";
        }
	}
	
	
	
	// MySQL
	public void modificarPerfil(Member member, String newDescription) {
		Connection con = null;
		
	    try {
	        
	        con = getConnection();
	        ps = (PreparedStatement) con.prepareStatement("UPDATE user_profiles SET description = ? WHERE discord_id = ?");
	        ps.setString(1, newDescription);
	        ps.setString(2, member.getUser().getId());
	        
	        int res = ps.executeUpdate();
	        
	        if(res > 0) {
	        	System.out.println("Perfil modificada exitosamente");
	        } else {
	        	// Crear
	        	crearFilaPerfil(member, newDescription);
	        }
	        
	        con.close();
	        
	    } catch(Exception e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "debug");
	    }
	}
	
	
	
	public void crearFilaPerfil(Member member, String newDesc) {
		Connection con = null;
        try {
            
            con = getConnection();
            ps = (PreparedStatement) con.prepareStatement("INSERT INTO user_profiles (discord_id, description) VALUES (?,?)");
            ps.setString(1, member.getUser().getId());
            ps.setString(2, newDesc);
            
            int res = ps.executeUpdate();
            
            if(res > 0) {
            	System.out.println("Perfil guardado exitosamente");
            } else {
            	System.out.println("Error al guardar perfil");
            }
            
            con.close();
            
        } catch(Exception e) {
            e.printStackTrace();
        }
	}
    
	
}
