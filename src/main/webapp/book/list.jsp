<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../header.jsp"%>
<%@ include file="../navbar.jsp"%>

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
            <th>#</th>
            <th>Picture</th>
            <th>ISBN</th>
            <th>Book Name</th>
            <th>Publisher</th>
            <th>Condition</th>
            <th>Borrow Status</th>
        </tr>
        </thead>
        <tbody>
        <c:set var="count" value="0" scope="page"/>
        <c:forEach var="book" items="${bookList}">
            <c:set var="count" value="${count + 1}" scope="page"/>
            <tr>
                <td><c:out value="${count}"/></td>
                <td>
                    <img src="${book.imgUrl}" alt="${book.name}" />
                </td>
                <td><c:out value="${book.isbn}"/></td>
                <td><c:out value="${book.name}"/></td>
                <td><c:out value="${book.publisher}"/></td>
                <td><c:out value="${book.condition}"/></td>
                <td><c:out value="${book.borrowed}"/></td>
                <td>
                    <a href="javascript:void(0);" onclick="confirmDelete('${pageContext.request.contextPath}/delete-book-form?bookId=${book.id}')" class="btn btn-danger btn-sm">Delete</a>
                    <a href="${pageContext.request.contextPath}/edit-book-form?bookId=${book.id}" class="btn btn-warning btn-sm ml-2">Edit</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <a href="${pageContext.request.contextPath}/create-book-form" class="btn btn-primary">Add New</a>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

