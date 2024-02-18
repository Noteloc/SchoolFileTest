<%@page import="java.io.IOException"%>
<%@page import="myfilereader.MyFileReader"%>
<%
    String message="";
    
    if (request.getParameter("message")!=null)
        message=request.getParameter("message");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Persistent XSS - Main Page</title>
    </head>
    <body>
        <h1>Persistent XSS - Main Page</h1>
        
        Hello, <%= session.getAttribute("username")%><br/>

        <a href="Logout">Logout</a><br/>

        <form action="PostMessage" method="GET">
        Post message: <input type="text" name="message">
        <input type="submit" value="Submit">
        </form>

        Message: <%= message %>

        <h4>All Messages</h4>
        <div id="messages">
        <%
                MyFileReader mfr = new MyFileReader();
                String messages="";
                
                //Lazy: squash error if no messages.txt file exists yet
                try
                {
                    messages = mfr.readFile("messages.txt");
                }
                catch(IOException ex)
                {}

                out.println(messages);
        %>
        </div>
        
    </body>
</html>
