<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Delete Librarian</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .container {
            max-width: 500px; /* Adjusted container width */
            margin-top: 50px; /* Added margin-top for spacing */
        }
        .btn-custom {
            margin-top: 10px;
        }
    </style>
</head>
<body>
<div class="container">
    <h2 class="text-center mb-4">Delete Librarian</h2>
    <div class="alert alert-warning" role="alert">
        Bạn có chắc chắn muốn xóa người quản lý này?
    </div>
    <form action="${pageContext.request.contextPath}/delete-librarian" method="post">
        <input type="hidden" name="id" value="${requestScope["librarian"].getId()}">
        <div class="form-group">
            <label>ID:</label>
            <p class="form-control-plaintext">${requestScope["librarian"].getId()}</p>
        </div>
        <div class="form-group">
            <label>Name:</label>
            <p class="form-control-plaintext">${requestScope["librarian"].getName()}</p>
        </div>
        <div class="form-group">
            <label>Email:</label>
            <p class="form-control-plaintext">${requestScope["librarian"].getEmail()}</p>
        </div>
        <div class="form-group">
            <label>Password:</label>
            <p class="form-control-plaintext">${requestScope["librarian"].getPassword()}</p>
        </div>
        <div class="d-flex justify-content-between">
            <button type="submit" class="btn btn-danger">Delete</button>
            <a href="${pageContext.request.contextPath}/list-librarian" class="btn btn-secondary">Back to Librarian List</a>
        </div>
    </form>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
