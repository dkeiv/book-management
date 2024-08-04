<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../navbar.jsp"%>
<table class="table table-striped table-hover">
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
                <a href="edit-book-form?bookId=${book.id}">Edit</a>
                -
                <a href="edit-book-form?bookId=${book.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

