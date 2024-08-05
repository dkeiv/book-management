<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Librarian</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-4">
    <h2>Edit Librarian</h2>

    <% if (request.getParameter("message") != null) { %>
    <div class="alert alert-success" role="alert">
        <%= request.getParameter("message") %>
    </div>
    <% } %>

    <form action="${pageContext.request.contextPath}/edit-librarian" method="post">

    <input type="hidden" name="id" value="${librarian.id}" />

        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" class="form-control" id="name" name="name" value="${librarian.name}" required />
        </div>

        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" class="form-control" id="email" name="email" value="${librarian.email}" required />
        </div>

        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" class="form-control" id="password" name="password" value="${librarian.password}" required />
        </div>

        <button type="submit" class="btn btn-primary">Update Librarian</button>
        <a href="${pageContext.request.contextPath}/list-librarian" class="btn btn-secondary">Back to Librarian List</a>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
