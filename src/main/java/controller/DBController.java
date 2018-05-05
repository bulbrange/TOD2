package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;




public class DBController {

	private static DBController instance = null;
	private static final String URL = "jdbc:mysql://esberfes.icons.es/icontinua?user=icontinua&password=icontinua";
	public static final String ALLUSERS = "SELECT * FROM Persona";

	public DBController() {
		try {
            // The newInstance() call is a work around for some
            // broken Java implementations

			Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            // handle the error
        }
	}

	public static DBController getInstance() {
		if (instance == null) {
			
			instance = new DBController();

		}
		return instance;
	}

	public ArrayList<Object> query(String query,String columnName) throws Exception{
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Object> data = new ArrayList<Object>();
		try {
			
		    conn =
		       DriverManager.getConnection("jdbc:mysql://esberfes.icons.es/icontinua?" +
		                                   "user=icontinua&password=icontinua");

		    stmt = conn.createStatement();
		    rs = stmt.executeQuery(query);
		    
		    while(rs.next()){
		    	data.add(rs.getObject(columnName));
		    }
		    // Do something with the Connection

		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		    JOptionPane.showMessageDialog(null, "Unable to connect to DB...", "DB info", 0);

		}finally{
			if (conn != null && !conn.isClosed()){
				conn.close();
			}
		}
		return data;
	}
	private Connection connect(){
		Connection conn = null;
		try{
			conn = DriverManager.getConnection(DBController.URL);
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, "Unable to connect to DB...", "DB info", 0);
		}
		return conn;
		
	}
	public void insertIntoPersona(String name, String mail, String pass) {
	        String query = "INSERT INTO Persona(Nombre,Email,Pass) VALUES(?,?,?)";
	 
	        try (Connection conn = this.connect();
	            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(query)) {
	            pstmt.setString(1, name);
	            pstmt.setString(2, mail);
	            pstmt.setString(3, pass);
	            pstmt.executeUpdate();
	            conn.close();
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	}
	
	public void insertIntoTarea(String userID, String title, String decription, String date_init, String date_end){
		String query = "INSERT INTO Tarea (ID_persona,Titulo,Descripcion,Fecha_ini,Fecha_fin) values (?,?,?,?,?)";
		try (Connection conn = this.connect();
				
	            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(query)) {
	            pstmt.setString(1, userID);
	            pstmt.setString(2, title);
	            pstmt.setString(3, decription);
	            pstmt.setString(4, date_init);
	            pstmt.setString(5, date_end);
	            pstmt.executeUpdate();
	            
	            conn.close();
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	}
}
