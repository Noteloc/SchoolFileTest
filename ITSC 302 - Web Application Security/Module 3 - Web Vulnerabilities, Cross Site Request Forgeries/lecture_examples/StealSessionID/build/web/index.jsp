

<%@page session="false" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Steal Session ID</title>
    </head>
    
    <body>
        
        <h1>Steal Session ID - Login</h1>
        
        <form action="Login" method="POST">
	Username: <input type="text" name="username" id="username"><br/>
	Password: <input type="password" name="password" id="password"><br/>
	<input type="submit" value="Login">
        </form>

        <%= request.getParameter("message") %>
        
        
    </body>
</html>
