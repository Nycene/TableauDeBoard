
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Naycene Boussoffara
 */
public class Connecter {
    public static Connection connexion=null;
  public static Connection Connecter() throws SQLException{
   
   String hostdb = "localhost:3306";  			// MySQl host
   String userdb = "root";  			        // MySQL username
   String passdb = "1234";  			        // MySQL password
   String namedb = "tableaudebord";  	// MySQL database name

    // Establish a connection to the database
    try {
        Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e){
        System.err.println("Echec1");
    }
    try{
        connexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/tableaudebord","root","1234");
    } catch(SQLException e){
        System.err.println("Echec2");
    }
     Statement state=connexion.createStatement();
     ResultSet rs=state.executeQuery("SELECT * FROM employé après vente");
     ResultSetMetaData result= rs.getMetaData();
     
     return connexion;
     
}
public static void main(String[] args){
    }}


