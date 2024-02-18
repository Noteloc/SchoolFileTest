<%@page import="java.sql.*"%>
<%
    String message="";
    
    String usernameDyn=request.getParameter("usernameDyn");
    String usernameParam=request.getParameter("usernameParam");
    
    if (usernameDyn!=null && !usernameDyn.equals(""))
    {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/secureusers", "root", "password");
        
        String sql="select locked from users where username='" + usernameDyn + "';";
        
        Statement st = conn.createStatement();
        
        ResultSet rs = st.executeQuery(sql);
        
        int count=0;
        
        while(rs.next())
        {
            count++;
            
            message = rs.getInt(1) + "<br/>";
        }
        
        if (count==0)
            message="Username not found in database";
        
        rs.close();
        st.close();
        conn.close();
               
    }
    
    if (usernameParam!=null && !usernameParam.equals(""))
    {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/secureusers", "root", "password");
        
        String sql="select locked from users where username=?;";
        
        PreparedStatement ps = conn.prepareCall(sql);
        ps.setString(1, usernameParam);
        
        ResultSet rs = ps.executeQuery();
        
        int count=0;
        
        while(rs.next())
        {
            count++;
            
            message = rs.getInt(1) + "<br/>";
        }
        
        if (count==0)
            message="Username not found in database";
        
        rs.close();
        ps.close();
        conn.close();
               
    }
    
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Database Security: Using Parameterized Queries</h1>

        <h3>Use a dynamically-built SQL statement</h3>
        <form action="paramQueries.jsp" method="POST">
        Look for: <input type="text" name="usernameDyn"><br/>
        <input type="submit" value="Find">
        </form>

        <h3>Use a parameterized SQL statement</h3>
        <form action="paramQueries.jsp" method="POST">
        Look for: <input type="text" name="usernameParam"><br/>
        <input type="submit" value="Find">
        </form>

        Locked status: <%= message %>
    </body>
</html>
