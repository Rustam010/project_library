<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html>
<head>
    <title>Details </title>
</head>
<body>
<h2>Детали книги</h2>
Id: ${book.id}
<br/>
Name: ${book.name}
<br/>
Author: ${book.author}
<br/>
Publish Year: ${book.publishYear}
<br/>
<br/>

<!-- Логика отображения владельца книги -->
<c:if test="${bookOwner != null}">
    <p>Кига принадлежит человеку: ${bookOwner.name} ${bookOwner.surname}</p>

    <%--Форма для овобождения книги --%>
    <form action="/book/releaseBook" method="post">
        <input type="hidden" name="bookId" value="${book.id}">
        <input type="submit" value="Освободить">
    </form>
</c:if>

<c:if test="${bookOwner == null}">
    <p>Книга пока-что никому не принадлежит</p>

    <%--Форма назначения книги человеку--%>
    <form action="/book/assignBook" method="post">
        <input type="hidden" name="bookId" value="${book.id}" />
        <label for="employee">Назначить книгу человеку:</label>
        <select name="employeeId" id="employee">
            <c:forEach var="employee" items="${allEmployees}">
                <option value="${employee.id}">${employee.name} ${employee.surname}</option>
            </c:forEach>
        </select>
        <div></div>
        <br>
        <input type="submit" value="Назначить">
    </form>

</c:if>


<hr>
<br>
<a href="/book/editBook/${book.id}">Редактировать</a>
<br>
<a href="/book">Назад</a>
<br><br>
<form action="/book/delete/${book.id}">
    <input type="submit" value="Удалить книгу">
</form>

</body>
</html>
