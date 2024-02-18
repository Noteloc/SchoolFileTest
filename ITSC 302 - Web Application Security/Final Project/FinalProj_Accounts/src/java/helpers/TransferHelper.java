/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import dbconn.DBConn;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TransferHelper {
    public String getAccounts(String username, String listName) throws ClassNotFoundException, SQLException
    {
        String accountList="<select name='" + listName + "' id='" + listName + "'>";
        
        Connection conn = DBConn.getConnection();
        
        String sql="";
        if (listName.equals("from"))
            sql="select * from accounts where FK_accountHolder='" + username + "';";
        else if (listName.equals("to"))
            sql="select * from accounts;";
        
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        while(rs.next())
        {
            if (listName.equals("from"))
                accountList += "<option value='" + rs.getInt(1) + "'>" + rs.getString(2) + " ($" + rs.getFloat(3) + ")";
            else if (listName.equals("to"))
                accountList += "<option value='" + rs.getInt(1) + "'>" + rs.getString(4) + " - " + rs.getString(2);
        }
        
        rs.close();
        st.close();
        conn.close();
        
        accountList += "</select>";
        
        return accountList;
    }
}
