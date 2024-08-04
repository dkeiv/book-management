<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
</head>
<body>
<table border="1">
    <tr>
        <td>Id</td>
        <td>Name</td>
    </tr>
    <c:forEach items="${categoryList}" var="category">
        <tr>
            <td>${category.getId()}</td>
            <td>${category.getName()}</td>
            <td><a href="/edit-category-form?categoryId=${category.getId()}">edit</a></td>
            <td><a href="/delete-category-form?categoryId=${category.getId()}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>