<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DB Week 9 Lab</title>
    </head>
    <body>
        <h1>Login</h1>
        
        <form action="Validate" method="POST">
            Username: <input type="text" name="username" id="username"><br/>
            Password: <input type="password" name="password"><br/>
            <input type="submit" value="Post">
        </form>
        
        Result: ${requestScope.message}
        
    </body>
    
    <script type="text/javascript">document.getElementById("username").focus()</script>
</html>
