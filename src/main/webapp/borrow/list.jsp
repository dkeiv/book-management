<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../header.jsp"%>
<%@ include file="../navbar.jsp"%>
<style>
    .table {
        font-size: 13px;
    }

    a:hover {
        text-decoration: none;
        color: #fff;
    }
</style>
<table class="table table-striped table-hover">
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
    <c:forEach var="borrowBook" items="${borrowBookList}">
        <c:set var="count" value="${count + 1}" scope="page"/>
        <tr>

            <td><c:out value="${count}"/></td>
            <td><c:out value="${borrowBook.bookIsbn}"/></td>
            <td><c:out value="${borrowBook.borrowDate}"/></td>
            <td><c:out value="${borrowBook.returnDate}"/></td>
            <td><c:out value="${borrowBook.status}"/></td>
            <td><c:out value="${borrowBook.userId}"/></td>
            <td>
                <a href="edit-borrow-form?borrowId=${borrowBook.id}">Edit</a>
                -
                <a href="delete-borrow-form?borrowId=${borrowBook.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

