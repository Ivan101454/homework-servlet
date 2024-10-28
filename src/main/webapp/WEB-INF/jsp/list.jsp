<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>ListUsers</title>
</head>
<body>
    <%@ include file="logout.jsp"%>
    <h3>List of users</h3>
    <ul>
        <c:forEach var="user" items="${requestScope.users}">
            <li>${user.name}</li>
        </c:forEach>
    </ul>
</body>
</html>
