<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html>
<head>
    <title>Библиотека </title>
</head>
<body>
<h2>Редактировать книгу</h2>

<form:form action="/book/updateBook" modelAttribute="book">
    <form:hidden path="id"/>

    <!-- Сохранение человека при обновлении книги -->
    <c:if test="${book.employee != null}">
        <form:hidden path="employee.id"/>
    </c:if>

    Название: <form:input path="name"/>
    <div style="color: red"><form:errors path="name"/></div>
    <br><br>
    Автор: <form:input path="author"/>
    <div style="color: red"><form:errors path="author"/></div>
    <br><br>
    Год издания: <form:input path="publishYear"/>
    <div style="color: red"><form:errors path="publishYear"/></div>
    <br><br>

    <br><br>
    <input type="submit" value="Обновить книгу">
</form:form>
<br>
<a href="/book/details/${book.id}">Назад</a>

</body>
</html>
