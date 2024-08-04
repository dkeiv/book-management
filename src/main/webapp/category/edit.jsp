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
<h1>Edit category</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="list.jsp">Back to category list</a>
</p>
<form method="post" action="${pageContext.request.contextPath}/edit-category">
    <fieldset>
        <legend>Category information</legend>
        <table>
            <input type="text" name="categoryId" id="categoryId" value="${categoryId}">
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name" id="name" value="${requestScope["category"].getName()}" required>
                </td>
            </tr>
            <tr>
                <td><input type="submit" value="Update category"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>