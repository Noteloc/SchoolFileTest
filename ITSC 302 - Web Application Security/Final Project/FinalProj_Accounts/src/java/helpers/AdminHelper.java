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

public class AdminHelper {
    public String getAllAccountsTable() throws ClassNotFoundException, SQLException
    {
        String table="<table border='1'><th>Holder</th><th>Locked</th>";
        table += "<form action='Admin' method='GET'>";
        
        Connection conn = DBConn.getConnection();
        String sql="select * from accountholders;";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next())
        {
            table += "<tr>";
            table += "<td>" + rs.getString(1) + "</td>";
            table += "<td><input type='checkbox' name='locked' value='" + rs.getString(1) + "' " + ((rs.getInt(4)==1)?"checked=true":"") + "></td>";
            table += "</tr>";
        }
        
        table += "<tr><td colspan='2'><input type='submit' value='Set Locked Status'></td></tr>";
        
        table += "</form>";
        table += "</table>";
        
        return table;
    }
}
