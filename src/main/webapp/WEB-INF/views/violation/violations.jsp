<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: karol
  Date: 03.06.2023
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Violations</title>
</head>
<body>
<c:forEach var="violation" items="${violations}">
    <div>${violation.propertyPath} : ${violation.message}</div>
</c:forEach>
</body>
</html>
