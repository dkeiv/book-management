<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../header.jsp"%>
<%@ include file="../navbar.jsp"%>
<jsp:useBean id="now" class="java.util.Date"/>


<html>
<head>
    <title>Edit Borrow</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-4">
    <h2>Edit Borrow</h2>

    <% if (request.getParameter("message") != null) { %>
    <div class="alert alert-success" role="alert">
        <%= request.getParameter("message") %>
    </div>
    <% } %>

    <form method="POST" action="${pageContext.request.contextPath}/delete-borrow">

        <input type="hidden" name="borrowId" value="${borrowId}">

        <div class="form-group">
            <label for="bookIsbn">Book ISBN:</label>
            <input type="text" class="form-control" id="bookIsbn" name="bookIsbn" required pattern="[0-9\-]+" value="${borrowBook.bookIsbn}" readonly>
        </div>

        <div class="form-group">
            <label for="userId">User ID:</label>
            <input type="text" class="form-control" id="userId" name="userId" required pattern="[0-9]+" value="${borrowBook.userId}" readonly>
        </div>

        <div class="form-group">
            <label for="borrowDate">Borrow Date:</label>
            <input  id="password" name="password" value="${librarian.password}" required />
            <input type="date" class="form-control" id="borrowDate" name="borrowDate" required type="date" value="${borrowBook.borrowDate}" readonly>
        </div>

        <div class="form-group">
            <label for="returnDate">Return Date:</label></td>
            <input type="date" class="form-control" id="returnDate" name="returnDate" required type="date" value="${borrowBook.returnDate}" readonly>
        </div>

        <div class="form-group">
            <label for="borrowStatus">Status:</label>
            <select type="text" class="form-control" id="borrowStatus" name="borrowStatus" >
                <c:forEach var="status" items="${statusList}">
                    <option value="${status}" <c:if
                            test="${status.description == borrowBook.status }"> selected </c:if>>${status.description}</option>
                </c:forEach>
            </select>
        </div>

        <button type="submit" class="btn btn-primary">Update Borrow</button>
        <a href="${pageContext.request.contextPath}/list-borrow" class="btn btn-secondary">Back to Borrow List</a>

    </form>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
