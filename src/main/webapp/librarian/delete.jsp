<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Delete Librarian</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            padding-top: 20px;
        }
        .container {
            max-width: 600px;
            margin: auto;
        }
        .btn-custom {
            margin-top: 10px;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Delete Librarian</h2>
    <form action="${pageContext.request.contextPath}/delete-librarian" method="post">
        <input type="hidden" name="id" value="${librarian.id}">
        <button type="submit" class="btn btn-danger">Delete</button>
    </form>
    <a href="${pageContext.request.contextPath}/list-librarian" class="btn btn-secondary btn-custom">Back</a>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
