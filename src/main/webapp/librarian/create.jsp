<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/2/2024
  Time: 10:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.jsp"%>
<%@ include file="../navbar.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/create-librarian" method="post">
    <input type="text" name = "name">
    <input type="text" name = "email">
    <input type="text" name = "password">
    <input type="submit" value="AddNew">
</form>
</body>
</html>
