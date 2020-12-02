
package redflixP;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author casierrav
 */
public class ConnectionJDBC {
    
    public static Connection getConnection(){
        String dbURL = "jdbc:mysql://localhost:3306/redflix157?serverTimezone=UTC";
        String username = "root";
        String password = "root"; 

        try {
            return DriverManager.getConnection(dbURL, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
