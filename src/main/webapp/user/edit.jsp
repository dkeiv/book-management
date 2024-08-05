<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Edit category</title>
    <style>
        .message{
            color:green;
        }
    </style>
</head>
<body>
<h1>Edit user</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="list.jsp">Back to user list</a>
</p>
<form method="post" action="${pageContext.request.contextPath}/edit-user">
    <fieldset>
        <legend>User information</legend>
        <table>
            <tr>
                <td>Id: </td>
                <td><input name="id" value="${id}" readonly></td>
            </tr>
            <tr>
                <td>Name: </td>
                <td><input name="name" value="${requestScope["user"].getName()}" ></td>

            </tr>

            <tr>
                <td>Course: </td>\
                <td><input name="course" value="${requestScope["user"].getCourse()}" ></td>

            </tr>
            <tr>
                <td>Birthday: </td>
                <td><input name="birthday" value="${requestScope["user"].getBirthday()}" ></td>
            </tr>
            <tr>
                <td><input type="submit" value="Update User"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>