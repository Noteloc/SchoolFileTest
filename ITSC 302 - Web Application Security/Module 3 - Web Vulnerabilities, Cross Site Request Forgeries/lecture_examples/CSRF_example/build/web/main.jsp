<%-- 
    Document   : main
    Created on : 8-Mar-2015, 2:38:26 PM
    Author     : John
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CSRF Example Main Page</title>
    </head>
    <body>
        <h1>CSRF Example Main Page</h1>
        <a href="Validate?logout=true">Logout</a>
        
        <h2>Withdraw Cash</h2>
        <form action="Withdraw" method="GET">
            Amount: <input type="text" name="amount"><br/>
            <input type="submit" value="Withdraw">
        </form>
        
        Balance: <%= session.getAttribute("balance") %>
    </body>
</html>
