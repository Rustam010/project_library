<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Employee</title>
</head>
<body>
<h2>Edit Employee Page</h2>

<form:form action="/employee/updateInfo" modelAttribute="employee">
    <form:hidden path="id"/>
    Name: <form:input path="name"/>
    <div style="color: red"><form:errors path="name"/></div>
    <br><br>

    Surname: <form:input path="surname"/>
    <div style="color: red"><form:errors path="surname"/></div>
    <br><br>

    Age: <form:input path="age"/>
    <div style="color: red"><form:errors path="age"/></div>
    <br><br>

    <input type="submit" value="Обновить">
</form:form>

</body>
</html>
