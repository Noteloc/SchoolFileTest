
package brokers;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBBroker {
    
    public boolean validateUser(String username, String password) {
        boolean result = false;
        
        Connection conn = null; 
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/assign02?allowMultiQueries=true", "root", "");
            
            String sql = "select count(*) from users where username='" + username + "' and password='" + password + "' and locked=0;";
            
            System.out.println("DEBUG: " + sql);
            
            Statement st = conn.createStatement();
            
            ResultSet rs = st.executeQuery(sql);

            rs.next();
            
            result = (rs.getInt(1)>0); 
            
            rs.close();
            st.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return result;
    }
    
}
