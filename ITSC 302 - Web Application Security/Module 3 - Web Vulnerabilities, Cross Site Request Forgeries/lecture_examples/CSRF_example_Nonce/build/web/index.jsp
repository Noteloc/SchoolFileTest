<%-- 
    Document   : index
    Created on : 8-Mar-2015, 2:30:12 PM
    Author     : John
--%>

<%@page session="false"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CSRF Example</title>
    </head>
    <body>
        <h1>CSRF Example</h1>
        
        <h2>Login</h2>
        <form action="Validate" method="POST">
            Username: <input type="text" name="username"><br/>
            Password: <input type="password" name="password"></br>
            <input type="submit" value="Login">
        </form>
        
    </body>
</html>
