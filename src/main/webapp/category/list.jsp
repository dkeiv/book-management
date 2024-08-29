<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../header.jsp" %>
<%@ include file="../navbar.jsp" %>

<style>
    .table {
        font-size: 13px;
    }

    a:hover {
        text-decoration: none;
        color: #fff;
    }
</style>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Category List</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

</head>
<body>

<div class="container mt-4">
    <center>
        <h1>Category Management</h1>

    </center>
    <form action="${pageContext.request.contextPath}/search-category" method="get" class="mb-4">
        <div class="input-group">
            <input type="text" name="name" class="form-control" placeholder="Search by name">
            <div class="input-group-append">
                <button type="submit" class="btn btn-primary">Search</button>
            </div>
        </div>
    </form>

    <table class="table table-striped">
        <thead>
        <tr>
            <td>#</td>
            <td>Name</td>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:set var="count" value="0" scope="page"/>
        <c:forEach var="category" items="${categoryList}">
            <c:set var="count" value="${count + 1}" scope="page"/>

            <tr>
                <td><c:out value="${count}"/></td>
                <td>${category.getName()}</td>

                <td>
                    <a href="${pageContext.request.contextPath}/delete-category-form?categoryId=${category.getId()}"
                       class="btn btn-danger btn-sm">Delete</a>
                    <a href="${pageContext.request.contextPath}/edit-category-form?categoryId=${category.getId()}"
                       class="btn btn-warning btn-sm ml-2">Edit</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <a href="${pageContext.request.contextPath}/create-category-form" class="btn btn-primary">Add New</a>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
