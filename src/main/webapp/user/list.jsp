<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../header.jsp"%>
<%@ include file="../navbar.jsp"%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Librarian List</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

</head>
<style>
    .table {
        font-size: 13px;
    }

    a:hover {
        text-decoration: none;
        color: #fff;
    }
</style>
<body>
<div class="container mt-4">
    <center>
        <h1>User Management</h1>

    </center>
    </form>

    <table class="table table-striped">
        <thead>
        <tr>
            <td>#</td>
            <td>Name</td>
            <td>Course</td>
            <td>Birthday</td>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${userList}" var="user">
            <tr>
                <td>${user.getId()}</td>
                <td>${user.getName()}</td>
                <td>${user.getCourse()}</td>
                <td>${user.getBirthday()}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/delete-user-form?id=${user.getId()}" class="btn btn-danger btn-sm">Delete</a>
                    <a href="${pageContext.request.contextPath}/edit-user-form?id=${user.getId()}" class="btn btn-warning btn-sm ml-2">Edit</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <a href="${pageContext.request.contextPath}/create-user-form" class="btn btn-primary">Add New</a>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>