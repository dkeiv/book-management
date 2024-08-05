<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <style>
        .message{
            color:green;
        }
    </style>
</head>
<body>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="user">Back to user list</a>
</p>
<form method="post" action="${pageContext.request.contextPath}/create-user">
    <fieldset>
        <legend>User information</legend>
        <table>

            <tr>
                <td>Name: </td>
                <td><input type="text" name="user-name" id="name"></td>
            </tr>

            <tr>
                <td>Course: </td>
                <td><input type="text" name="course" id="course"></td>
            </tr>
            <tr>
                <td>Birthday: </td>
                <td><input type="date" name="birthday" id="birthday"></td>
            </tr>


            <tr>
                <td></td>
                <td><input type="submit" value="Create user"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>