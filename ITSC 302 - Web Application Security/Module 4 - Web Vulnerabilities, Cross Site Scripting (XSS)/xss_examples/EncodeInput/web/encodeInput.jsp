<%@page import="java.net.URLEncoder"%>
<%
    String message="";
    
    if (request.getParameter("message")!=null)
    {
        message=request.getParameter("message");
        
        //Encode the message to be output to avoid injection attacks
        message = URLEncoder.encode(message, "UTF-8");
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Encode output to stop injection attacks</title>
    </head>
    <body>
        <h1>Encode output to stop injection attacks</h1>
        
        <b>Try some normal values first, then try: &lt;script&gt;alert("ok")&lt;/script&gt;<br/>
        <form action="encodeInput.jsp" method="GET">
        Enter value: <input type="text" name="message">
        <input type="submit" value="Go">
        </form>
        <%= message %>
    </body>
</html>
