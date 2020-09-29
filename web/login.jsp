<%-- 
    Document   : login
    Created on : Sep 23, 2020, 11:06:55 AM
    Author     : Mandeep
--%>

<%@page language ="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LOGIN </title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >
    </head>
    <body>
       
        <jsp:include page="header.jsp"></jsp:include>
        <h1>LOGIN PAGE</h1>
        <form action="login" method="post">
            UserName:<br>
            <input type ="text" placeholder="username" name="username"><br>
            Password: <br>
            <input type="password" placeholder="password" name="password"<br>
            <button type="submit" class="btn-success">Login</button>
        </form>
        
        <br>
        <form action="register.jsp" method="post">
            <button type="submit" class="btn-primary">Signup</button> 
        </form>
        
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
