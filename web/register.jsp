<%-- 
    Document   : index
    Created on : Sep 22, 2020, 11:54:13 AM
    Author     : Mandeep
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration page</title>
        <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" 
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        
        <h1> USER REGISTRATION FORM </h1>
        <form action="registerValidate" method ="post">
            Enter First Name<br>
           
            <input type  ="text" placeholder="First Name" name="fname"><br>
            Enter Last Name<br>
              <input type  ="text" placeholder="Last Name" name="lname"><br>
              Enter User Name<br>
              <input type ="text" placeholder="User Name" name ="username"><br>
              Enter Password<br>
              <input type="password" placeholder="Password" name ="pass"><br>
              
             <button type="submit" class="btn btn-primary">Signup</button>
                
        </form>
        
        <br>
        <form action ="login.jsp" method="post">
            <button type ="submit" class="btn-success">Login</button>
        </form>
        <jsp:include page ="footer.jsp"></jsp:include>
    </body>
</html>
