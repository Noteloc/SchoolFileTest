
<%
    if (session.getAttribute("username")==null)
        response.sendRedirect("index.jsp?message=Not logged in");
%>

<jsp:useBean id="transferHelper" class="helpers.TransferHelper"/>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Project 2020 Transfer Funds</title>
    </head>
    <body>
        <h1>Project 2020 Transfer Funds</h1>
        
        <%=session.getAttribute("welcome")%><span id="username"><%=session.getAttribute("username")%></span><br/>
        <a href="Validate?logout=true">Logout</a>
        <br/>
        
        <h3>Transfer Funds</h3>
        <form name="transfer" id="transfer" action="Transfer" method="GET">
        From: <%=transferHelper.getAccounts((String)session.getAttribute("username"),"from")%><br/>
        To: <%=transferHelper.getAccounts((String)session.getAttribute("username"),"to")%><br/>
        Amount: <input type="text" name="amount" id="amount"><br/>
        <input type="submit" value="Transfer">
        </form>
        
        <%=(request.getParameter("message")!=null)?request.getParameter("message"):""%>
        
    </body>
</html>
