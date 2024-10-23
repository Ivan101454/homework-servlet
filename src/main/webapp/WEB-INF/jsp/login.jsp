<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>

<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="post">
    <label for="login">LOGIN
        <input type="text" name="login" id="login" required>
    </label>
    <label for="password">PASSWORD
        <input type="text" name="password" id="password" required>
    </label>
    <button type="submit">Submit</button>
    <a href="${pageContext.request.contextPath}/registration">
        <button type="button">Register</button>
    </a>
</form>
</body>
</html>
