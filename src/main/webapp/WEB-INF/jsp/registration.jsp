<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Registration</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/registration" method="post">
        <label for="login">login
            <input type="text" name="login" id="login">
        </label><br>
        <label for="password">password
            <input type="text" name="password" id="password">
        </label><br>
        <label for="name">name
            <input type="text" name="name" id="name">
        </label><br>
        <label for="age">age
            <input type="text" name="age" id="age">
        </label><br>
        <label for="address">address
            <input type="text" name="address" id="address">
        </label><br>
        <label for="role">role
            <select name="role" id="role">
              <c:forEach var="role" items="${requestScope.roles}">
                  <option value="${role}">${role}</option>
              </c:forEach>
            </select><br>
        </label><br>
        <button type="submit">Submit</button>
    </form>
</body>
</html>