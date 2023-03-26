
package app;

import java.sql.*;
/**
 *
 * @author Tanzim
 */
public class DbConnection {
    Connection con = null;
    
    public static Connection ConnectionDB() {
        
        try {
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:information.db");
            System.out.println("Connection Successful");
            return con;
        }
        catch(Exception e) {
            System.out.println("Connection failed" + e);
            return null;
        }
    }
    
}
