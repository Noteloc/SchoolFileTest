<%-- 
    Document   : badLink
    Created on : 8-Mar-2015, 3:03:11 PM
    Author     : John
--%>

<%@page session="false"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CSRF Example - BAD LINK</title>
    </head>
    <body>
        <h1>CSRF Example - BAD LINK</h1>
        
        Hi User, please click on this innocent link: <a href="http://localhost:8080/CSRF_example_Nonce/Withdraw?amount=100">Cat videos</a>
        
    </body>
</html>
