<%@page import="java.sql.*"%>

<%
    String message="";
    
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    
    if (username!=null && password!=null)
    {
        //Replace all single quotes with double quotes 
        username=username.replaceAll("'","\"");
        password=password.replaceAll("'","\"");
        
        System.out.println("DEBUG: " + username + " ; " + password);
       
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/secureusers?allowMultiQueries=true", "root", "password");

        String sql = "select count(*) from users where username='" + username + "' and password='" + password + "';";

        Statement st = conn.createStatement();

        ResultSet rs = st.executeQuery(sql);

        rs.next();

        int valid = rs.getInt(1);

        if (valid==0)
            message="Invalid username or password";
        else
            message="Welcome, " + username;

        rs.close();
        st.close();
        conn.close();
    }
                
    
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SQL Injection 4</title>
    </head>
    <body>
        <h1>Database Security #4: Escaping Quotes for Defence</h1>
        
        <h3>Database Security #4: Escaping Quotes for Defence</h3>

        <form action="sqlinjectionDefence2.jsp" method="POST">
        Username: <input type="text" name="username"><br/>
        Password: <input type="password" name="password"><br/>
        <input type="submit" value="Login">
        </form>
        <%= message %>
        
    </body>
</html>
