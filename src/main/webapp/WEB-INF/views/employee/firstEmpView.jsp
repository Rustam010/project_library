<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>First EmpView </title>
</head>
<body>
<h2>Все работники</h2>

<c:forEach var="employee" items="${AllPeopleAttribute}">
    <a href="/employee/details/${employee.id}">${employee.name}, ${employee.age} </a>
    <br>
</c:forEach>

<br>
<hr>
<a href="/employee/addNewEmployee">Создать нового человека</a>
<br><br>
<a href="/">На главную</a>
</body>
</html>
