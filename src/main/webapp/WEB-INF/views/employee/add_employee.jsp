<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Employee</title>
</head>
<body>
<h2>Add Employee Info</h2>

<form:form action="/employee/saveEmployee" modelAttribute="employee">
    Name: <form:input path="name"/>
    <div style="color: red"><form:errors path="name"/></div>
    <br><br>

    Surname: <form:input path="surname"/>
    <div style="color: red"><form:errors path="surname"/></div>
    <br><br>

    Age: <form:input path="age"/>
    <div style="color: red"><form:errors path="age"/></div>
    <br><br>

    <input type="submit" value="Создать">
</form:form>
<br>
<a href="/employee">Back</a>
</body>
</html>
