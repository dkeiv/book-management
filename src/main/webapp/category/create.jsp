<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../header.jsp"%>
<%@ include file="../navbar.jsp"%>
<html>
<head>
    <title>Create Category</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<div class="container mt-4">
    <h2>Edit Librarian</h2>

    <% if (request.getParameter("message") != null) { %>
    <div class="alert alert-success" role="alert">
        <%= request.getParameter("message") %>
    </div>
    <% } %>

    <form action="${pageContext.request.contextPath}/create-category" method="post">

        <input type="hidden" name="id" value="${category.id}" />

        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" class="form-control" id="name" name="name" value="${category.name}" required />
        </div>

        <button type="submit" class="btn btn-primary">Create Category</button>
        <a href="${pageContext.request.contextPath}/list-category" class="btn btn-secondary">Back to Category List</a>
    </form>
</div>
</body>
</html>