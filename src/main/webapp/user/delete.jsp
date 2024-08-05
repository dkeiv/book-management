<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../header.jsp"%>
<%@ include file="../navbar.jsp"%>
<html>
<head>
    <title>Deleting category</title>
</head>
<body>
<h1>Delete category</h1>
<p>
    <a href="list.jsp">Back to customer list</a>
</p>
<form method="post" action="${pageContext.request.contextPath}/delete-user">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>User information</legend>
        <table>
            <tr>
                <td>Id: </td>
                <td><input name="id" value="${id}" readonly></td>
            </tr>
            <tr>
                <td>Name: </td>
                <td><input name="name" value="${requestScope["user"].getName()}" readonly></td>
            </tr>

            <tr>
                <td>Course: </td>\
                <td><input name="course" value="${requestScope["user"].getCourse()}" readonly></td>

            </tr>
            <tr>
                <td>Birthday: </td>
                <td><input name="birthday" value="${requestScope["user"].getBirthday()}" readonly></td>
            </tr>
            <tr>
                <td>Active: </td>
                <td><input name="active" value="${requestScope["user"].isActive()}" readonly></td>
            </tr>
            <tr>
                <td><input type="submit" value="Delete User"></td>
                <td><a href="list.jsp">Back to User list</a></td>
            </tr>
        </table>
    </fieldset>
</body>
</html>