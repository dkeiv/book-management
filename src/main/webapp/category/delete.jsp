<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Deleting category</title>
</head>
<body>
<h1>Delete category</h1>
<p>
    <a href="list.jsp">Back to customer list</a>
</p>
<form method="post" action="${pageContext.request.contextPath}/delete-category">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Category information</legend>
        <table>
            <tr>
                <td>Id: </td>
                <td><input name="categoryId" value="${categoryId}" readonly></td>
            </tr>
            <tr>
                <td>Name: </td>
                <td>${requestScope["category"].getName()}</td>
            </tr>
            <tr>
                <td><input type="submit" value="Delete category"></td>
                <td><a href="list.jsp">Back to customer list</a></td>
            </tr>
        </table>
    </fieldset>
</body>
</html>