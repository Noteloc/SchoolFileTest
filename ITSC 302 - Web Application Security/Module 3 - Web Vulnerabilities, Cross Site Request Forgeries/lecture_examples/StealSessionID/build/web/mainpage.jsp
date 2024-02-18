<%
    //Get session ID from local memory
    String localSessionID = request.getSession().getId();
    
    //Get session ID and referer from cookies   
    String cookieSessionID = "";
    String referer="";
    
    Cookie[] cookies = request.getCookies();
    
    for (Cookie c: cookies  )
    {
        if (c.getName().equals("JSESSIONID"))
            cookieSessionID = c.getValue();
        
        if (c.getName().equals("Referer"))
            referer = c.getValue();
    }
    
    //Check if session id's don't match
    if (! cookieSessionID.equals(localSessionID))
    {
        response.sendRedirect("index.jsp?message=Invalid session ID");
    }
    
    //Store user "secret" in his/her session 
    if (request.getParameter("secret")!=null && !request.getParameter("secret").equals(""))
    {
        session.setAttribute("secret", request.getParameter("secret"));
    }
    
    
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Steal Session ID - Main Page</title>
    </head>
    <body>
        <h1>Steal Session ID - Main Page</h1>
        
        Hello, <%= session.getAttribute("username") %><br/>

        <a href="Logout">Logout</a><br/>

        Cookie session ID is: <%= cookieSessionID %><br/>
        Local in-memory session ID is: <%= localSessionID %><br/>
        The "referer" is: <%= referer %><br/>

        Enter a secret:
        <form action="mainpage.jsp" method="GET">
        Secret: <input type="text" name="secret" id="secret"> <input type="submit" value="Save">
        </form>

        Secret: <%= (session.getAttribute("secret")!=null)?session.getAttribute("secret"):"" %>
        
    </body>
</html>
