package permsManager;

import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import net.dv8tion.jda.core.entities.Member;

public class PermsDataManager {
	
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
	
	
	
	public int getInt(Member member) {
		Connection con = null;
		String discord_id = member.getUser().getId();
        
        try {
            
            con = getConnection();
            ps = (PreparedStatement) con.prepareStatement("SELECT * FROM language_roles WHERE discord_id = ?");
            ps.setString(1, discord_id);
            
            rs = ps.executeQuery();
            
            if(rs.next()) {
            	return rs.getInt("setlang");
            } else {
                System.out.println("No existe una persona con un boolean asignado");
                crearFila(member);
                return 0;
            }
            
        } catch(Exception e) {
            e.printStackTrace();
            return 0;
        }
	}
	
	
	
	public void crearFila(Member member) {
		Connection con = null;
        try {
            
            con = getConnection();
            ps = (PreparedStatement) con.prepareStatement("INSERT INTO language_roles (discord_id, setlang) VALUES (?,?)");
            ps.setString(1, member.getUser().getId());
            ps.setInt(2, 1);
            
            int res = ps.executeUpdate();
            
            if(res > 0) {
            	System.out.println("Persona guardada exitosamente - languages");
            } else {
            	System.out.println("Error al guardar persona - languages");
            }
            
            con.close();
            
        } catch(Exception e) {
            e.printStackTrace();
        }
	}
	
	
	public void modificarFila(Member member, int toAdd) {
		int antes = getInt(member);
		Connection con = null;
		
	    try {
	        
	        con = getConnection();
	        ps = (PreparedStatement) con.prepareStatement("UPDATE language_roles SET setlang = ? WHERE discord_id = ?");
	        ps.setInt(1, antes + toAdd);
	        ps.setString(2, member.getUser().getId());
	        
	        int res = ps.executeUpdate();
	        
	        if(res > 0) {
	        	System.out.println("Lenguajes modificados exitosamente");
	        } else {
	        	// Crear
//	        	crearFilaPerfil(member, newDescription);
	        }
	        
	        con.close();
	        
	    } catch(Exception e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "debug");
	    }
	}
	
}
