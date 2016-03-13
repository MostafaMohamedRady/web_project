<%-- 
    Document   : allCategories
    Created on : Mar 11, 2016, 4:36:42 PM
    Author     : Aya Mahmoud
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<jsp:include page="header.jsp"></jsp:include>
<div class="grow">
    <div class="container">
        <h2>Admin ALL Categories</h2>
    </div>
</div>
        <h1>Hello World!</h1>
            <ul>
            <c:forEach items="${requestScope.catsName}" var="cat">
                <li><a href="products"><c:out value="${cat.categoryName}"/></a></li>
                <c:set var="id" scope="request" value="${cat.idcategory}"/>
            </c:forEach>
            </ul>
<jsp:include page="footer.jsp"></jsp:include>