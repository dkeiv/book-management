<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
</head>
<body>
<table border="1">
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Address</td>
        <td>Course</td>
        <td>Birthday</td>
    </tr>
    <c:forEach items="${userList}" var="user">
        <tr>
            <td>${user.getId()}</td>
            <td>${user.getName()}</td>
            <td>${user.getAddress()}</td>
            <td>${user.getCourse()}</td>
            <td>${user.getBirthdayd()}</td>
            <td><a href="/edit-user-form?id=${user.getId()}">edit</a></td>
            <td><a href="/delete-user-form?id=${user.getId()}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>