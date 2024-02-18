<%@page import="java.util.Scanner"%>
<%@page import="java.io.File"%>
<%
    String allNames=""; 
    
    
    //Place copy of namelist.txt file in: /usr/local/glassfish-4.1/glassfish/domains/domain1/config
    File f = new File("namelist.txt");
    Scanner s = new Scanner(f);
    
    String sql="select * from users where username='adam' and (";
    
    while (s.hasNext())
    {
        String name=s.nextLine();
        sql = sql + "password='" + name + "' or ";
    }
    
    sql = sql.substring(0,sql.length()-4);
    
    sql = sql + ");";
    
    s.close();
    
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Generate Brute Force</title>
    </head>
    <body>
        <h1>Generate Brute Force</h1>
        
        <%= sql %>
        
    </body>
</html>
