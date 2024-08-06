<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../header.jsp"%>
<%@ include file="../navbar.jsp"%>


<html>
<head>
    <title>Delete User</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<c:if test="${message != null}" >
    <p>${message}</p>
</c:if>
<div class="container mt-4">
    <h2>Delete User</h2>

    <% if (request.getParameter("message") != null) { %>
    <div class="alert alert-success" role="alert">
        <%= request.getParameter("message") %>
    </div>
    <% } %>

    <form method="post" action="${pageContext.request.contextPath}/delete-user">

        <input type="hidden" name="id" value="${user.id}" />

        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" id="name" class="form-control" name="name" value="${requestScope["user"].getName()}" >
        </div>

        <div class="form-group">
            <label for="course">Course:</label>
            <input type="text" class="form-control" id="course" name="course" value="${requestScope["user"].getCourse()}" >
        </div>

        <div class="form-group">
            <label for="birthday">Birthday:</label>
            <input id="birthday" type="date" class="form-control" name="birthday" value="${requestScope["user"].getBirthday()}" >
        </div>

        <div class="form-group">
            <label for="active">Active:</label>
            <input id="active" type="text" class="form-control" name="active" value="${requestScope["user"].isActive()}" readonly>
        </div>

        <button type="submit" class="btn btn-primary">Delete User</button>
        <a href="${pageContext.request.contextPath}/list-user" class="btn btn-secondary">Back to User List</a>
    </form>
</div>


<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>