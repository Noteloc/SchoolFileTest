<%
    String message="";
    
    if (request.getParameter("message")!=null)
        message = request.getParameter("message");
    
    String username=request.getParameter("username");
    String password=request.getParameter("password");
    
    if (username!=null && password!=null && !username.equals("") && !password.equals(""))
    {
        if (username.equals("user") && password.equals("pass"))
        {
            session.setAttribute("username", username);
            
            response.sendRedirect("mainpage.jsp");
        }
        else 
            message="Invalid username or password!";
    }
    else if (username!=null && password!=null)
        message="Both values required!";
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Persistent XSS -Login</title>
    </head>
    <body>
        <h1>Persistent XSS - Login</h1>
        
        <form action="index.jsp" method="POST">
	Username: <input type="text" name="username" id="username"><br/>
	Password: <input type="password" name="password" id="password"><br/>
	<input type="submit" value="Login">
</form>

<%= message %>
    </body>
</html>
