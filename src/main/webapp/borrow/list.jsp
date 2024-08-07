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

<div class="container mt-4" style="min-height: 40vh";>
    <center>
        <h1>Borrow Management</h1>

    </center>
    </form>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>#</th>
            <th>ISBN</th>
            <th>Borrow Date</th>
            <th>Return Date</th>
            <th>Borrow Status</th>
            <th>User Id</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:set var="count" value="0" scope="page"/>
        <c:forEach var="book" items="${bookList}">
            <c:set var="count" value="${count + 1}" scope="page"/>
            <tr class="middle">

                <td><c:out value="${count}"/></td>
                <td><c:out value="${borrowBook.bookIsbn}"/></td>
                <td><c:out value="${borrowBook.borrowDate}"/></td>
                <td><c:out value="${borrowBook.returnDate}"/></td>
                <td><c:out value="${borrowBook.status}"/></td>
                <td><c:out value="${borrowBook.userId}"/></td>
                <td>
                    <a href="${pageContext.request.contextPath}/delete-borrow-form?borrowId=${borrowBook.id}" class="btn btn-warning btn-sm ml-2">Delete</a>
                    <a href="${pageContext.request.contextPath}/edit-borrow-form?borrowId=${borrowBook.id}" class="btn btn-danger btn-sm">Edit</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <a href="${pageContext.request.contextPath}/create-borrow-form" class="btn btn-primary">Add New</a>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<%@ include file="../footer.jsp" %>
</body>


