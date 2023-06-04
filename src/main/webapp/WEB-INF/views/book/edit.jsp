<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit book</title>
    <link rel="stylesheet" type="text/css" href="/resources/style.css">
</head>
<body>

<h3>Edit book</h3>

<form:form method="post" modelAttribute="book">

    <div>Title: <form:input path="title"/><form:errors path="title" cssClass="error-message"/></div>
    <div>Description: <form:input path="description"/><form:errors path="description" cssClass="error-message"/></div>
    <div>Rating: <form:input path="rating" type="number" min="1" max="10"/><form:errors path="rating" cssClass="error-message"/></div>
    <div>Publisher: <form:select path="publisher.id" items="${publishers}" itemLabel="name" itemValue="id"/><form:errors path="publisher" cssClass="error-message"/></div>
    <div>Authors: <form:select path="authors" items="${authors}" itemLabel="fullName" itemValue="id"
                               multiple="true"/><form:errors path="authors" cssClass="error-message"/></div>
    <div>Pages: <form:input path="pages" type="number" min="1" placeholder="Podaj liczbę stron"/><form:errors path="pages" cssClass="error-message"/></div>
    <form:hidden path="id"/>
    <div>Categories: <form:select path="category" items="${categories}" itemLabel="name" itemValue="id"/><form:errors path="category" cssClass="error-message"/></div>
    <input type="submit" value="Update book">
</form:form>

</body>
</html>
