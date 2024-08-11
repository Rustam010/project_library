<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html>
<head>
    <title>Библиотека </title>
</head>
<body>
<h2>Список всех книг</h2>

<c:forEach var="book" items="${allBooks}">
    <a href="/book/details/${book.id}">${book.name} (${book.author}, ${book.publishYear}) </a>
    <br>
</c:forEach>
<hr>
<br>
<a href="/book/addBook">Добавить книгу в библиотеку</a>
<br>
<br>
<a href="/">На главную</a>
</body>
</html>
