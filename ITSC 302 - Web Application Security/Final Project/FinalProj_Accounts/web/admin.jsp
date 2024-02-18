
<%
    if (session.getAttribute("adminUsername")==null)
        response.sendRedirect("adminLogin.jsp?message=Not logged in");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Project 2020 Admin Page</title>
    </head>
    <body>
        <h1>Project 2020 Admin Page</h1>
        <%=session.getAttribute("welcome")%><%=session.getAttribute("adminUsername")%><br/>
        <a href="Validate?logout=true">Logout</a>
        <br/>
        <h3>Account Details</h3>
        <jsp:useBean id="adminHelper" class="helpers.AdminHelper"/>
        <%=adminHelper.getAllAccountsTable()%>
  
        <%=(request.getParameter("message")!=null)?request.getParameter("message"):""%>
        
        <h3>Update Welcome Message</h3>
        <form action="Admin" method="GET">
            New message: <input type="text" name="welcome">
            <input type="submit" value="Update Welcome">
        </form>
        
    </body>
</html>
