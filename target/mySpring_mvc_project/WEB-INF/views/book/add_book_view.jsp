<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html>
<head>
    <title>Библиотека </title>
</head>
<body>
<h2>Добавить книгу</h2>

<form:form action="/book/saveBook" modelAttribute="book">
    Название: <form:input path="name"/>
    <br><br>
    Автор: <form:input path="author"/>
    <br><br>
    Год издания: <form:input path="publishYear"/>
    <br><br>
    <input type="submit" value="Добавить">
</form:form>

<br>
<a href="/book">Назад</a>

</body>
</html>
