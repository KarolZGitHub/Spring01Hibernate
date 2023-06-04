<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: karol
  Date: 02.06.2023
  Time: 22:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit Form</title>
    <link rel="stylesheet" type="text/css" href="/resources/style.css">
</head>
<body>
<form:form method="post" modelAttribute="author">
<div>First Name<form:input path="firstName"/></div>
<div>Last Name<form:input path="lastName"/></div>
<div><input type="submit" value="Edytuj"></div>
</form:form>
</body>
</html>
