<%--
  Created by IntelliJ IDEA.
  User: karol
  Date: 02.06.2023
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>All Authors</title>
    <link rel="stylesheet" type="text/css" href="/resources/view.css">
</head>
<body>
<c:forEach items="${authors}" var="author">
    <ul>
        <li>${author} <a href="/author/edit/${author.id}">Edytuj</a> <a href="/author/delete/${author.id}">Usuń</a></li>
    </ul>
</c:forEach>
</body>
</html>
