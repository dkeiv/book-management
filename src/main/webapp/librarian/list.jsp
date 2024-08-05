<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Librarian List</title>
    
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-4">
    <form action="${pageContext.request.contextPath}/search-librarian" method="get">
        <input type="text" name="name" placeholder="name">
        <input type="submit" value="Search">
    </form>


    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Password</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${librarianList}" var="librarian">
            <tr>
                <td>${librarian.id}</td>
                <td>${librarian.name}</td>
                <td>${librarian.email}</td>
                <td>${librarian.password}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/delete-librarian-form?id=${librarian.id}" class="btn btn-danger btn-sm ml-2">Xoa</a>
                    <a href="${pageContext.request.contextPath}/edit-librarian-form?id=${librarian.id}" class="btn btn-warning btn-sm ml-2">Edit</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <a href="${pageContext.request.contextPath}/create-librarian-form" class="btn btn-primary">Add New</a>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
