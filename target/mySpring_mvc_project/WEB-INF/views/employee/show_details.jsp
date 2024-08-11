<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Show details Page</title>
</head>
<body>
<h2>Your details</h2>
Id: ${getOneEmployeeAttribute.id}
<br/>
Name: ${getOneEmployeeAttribute.name}
<br/>
Surname: ${getOneEmployeeAttribute.surname}
<br/>
Age: ${getOneEmployeeAttribute.age}
<br/>

<%--<hr>--%>
<%--<c:choose>--%>
<%--    <c:when test="${empty books}">--%>
<%--        <p>Человек пока не взял ни одной книги</p>--%>
<%--    </c:when>--%>
<%--    <c:otherwise>--%>
<%--        <h3>Книги, которые взял человек:</h3>--%>
<%--        <ul>--%>
<%--            <c:forEach var="book" items="${books}">--%>
<%--                <li>${book.name}  (${book.author})</li>--%>
<%--            </c:forEach>--%>
<%--        </ul>--%>
<%--    </c:otherwise>--%>
<%--</c:choose>--%>
<%--<hr>--%>

<hr>
<c:if test="${empty books}">
    <p>Человек пока не взял ни одной книги</p>
</c:if>

<c:if test="${not empty books}">
    <h3>Книги, которые взял человек:</h3>
    <ul>
        <c:forEach var="book" items="${books}">
            <li>${book.name} - ${book.author}</li>
        </c:forEach>
    </ul>
</c:if>
<hr>

<a href="/employee/editEmployee/${getOneEmployeeAttribute.id}">Edit</a>
<br/>

<a href="/employee">Back</a>
<br/>

<form action="/employee/deleteInfo/${getOneEmployeeAttribute.id}">
    <input type="submit" value="DELETE">
</form>

</body>
</html>
