<%-- 
    Document   : adminLogin
    Created on : Mar 11, 2016, 12:28:37 PM
    Author     : Aya Mahmoud
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="header.jsp"></jsp:include>
<div class="grow">
    <div class="container">
        <h2>Admin Login Page</h2>
    </div>
</div>
    <center>
        <h1>Home of Music</h1>
        <p>please enter your administrator user and password</p>
        <form  method="post" action="admin">
        Username: &nbsp;<input type="text" name="user"/><br><br>
        Password: &nbsp;  <input type="password" name="pwd"/>
        <pre>                     <input type="submit" value="  Login  "></pre>
        </form>
    </center>  
<jsp:include page="footer.jsp"></jsp:include>