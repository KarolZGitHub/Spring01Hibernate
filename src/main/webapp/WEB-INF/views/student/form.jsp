<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/resources/style.css">
</head>
<body>
<form:form method="post"
           modelAttribute="student">
    <div>First Name: <form:input path="firstName"/></div>
    <div>Last Name:<form:input path="lastName"/></div>
    <div> Male:<form:radiobutton path="gender" value="Male"/></div>
    <div> Female:<form:radiobutton path="gender" value="Female"/></div>
    <div> Country:<form:input path="country"/></div>
    <div> Notes:<form:input path="notes"/></div>
    <div> Mailing List:<form:checkbox path="mailingList"/></div>
    <div> Programming Skills:<form:checkboxes items="${programmingSkills}" path="programmingSkills"/></div>
    <div> Hobbies:<form:checkboxes items="${hobbies}" path="hobbies"/></div>
    <div><input type="submit" value="Wyślij"></div>
</form:form>
</body>
</html>
