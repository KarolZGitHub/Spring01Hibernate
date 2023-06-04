<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add author</title>
    <link rel="stylesheet" type="text/css" href="/resources/style.css">
</head>
<body>
<form:form modelAttribute="author" method="post">
    <div>Name: <form:input path="firstName"/></div>
    <div>Last name: <form:input path="lastName"/></div>
    <div><input type="submit" value="Dodaj"></div>
</form:form>
</body>
</html>
