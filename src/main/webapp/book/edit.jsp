<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../header.jsp"%>
<%@ include file="../navbar.jsp"%>
<form method="POST" action="${pageContext.request.contextPath}/edit-book">
    <table>
        <tr>
            <td>
                <label for="bookIsbn">ISBN</label>
            </td>
            <td>
            </td>
        </tr>
        <tr>
            <td>
                <label for="bookName">Name</label>
            </td>
            <td>
                <input id="bookName" name="bookName" required value="${book.name}">
            </td>
        </tr>
        <tr>
            <td>
                <label for="bookCondition">Condition</label>
            </td>
            <td>
            </td>
        </tr>
        <tr>
            <td>
                <label for="bookPublisher">Publisher</label>
            </td>
            <td>

            </td>
        </tr>
        <tr>
            <td>
                <label for="bookCategory">Category</label>
            </td>
            <td>
                <select id="bookCategory" class="form-select" size="3" name="bookCategory" multiple="multiple" readonly>
                    <c:forEach var="category" items="${categoryList}">
                        <option value="${category.id}"
                                <c:if test="${bookCategoryList.contains(category.name)}">selected</c:if>>
                                ${category.name}
                        </option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>
                <label for="bookImage">
                    Book Image
                </label>
            </td>
            <td>
                <input id="bookImage" type="url" value="${book.imgUrl}" name="bookImage">
            </td>
        </tr>
        <tr>
            <td>
                <label for="bookDescription">Description</label>
            </td>
            <td>
                <textarea id="bookDescription" name="bookDescription" cols="50" rows="4">${book.description}</textarea>
            </td>
        </tr>
        <tr>
            <td>
                <label for="borrowedStatus">Status</label>
            </td>
            <td>
                <select id="borrowedStatus" name="borrowedStatus" required>
                    <option value="true" <c:if test="${book.borrowed== true}">selected
                    </c:if>> Borrowed
                    </option>
                    <option value="false" <c:if test="${book.borrowed == false}">selected
                    </c:if>> Available
                    </option>
                </select>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Edit">
                <a class="btn secondary-btn btn-sm" href="${pageContext.request.contextPath}/list-book">Cancel</a>
            </td>
        </tr>
    </table>

    <head>
        <title>Edit Librarian</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>
    <div class="container mt-4">
        <h2>Edit Librarian</h2>

        <% if (request.getParameter("message") != null) { %>
        <div class="alert alert-success" role="alert">
            <%= request.getParameter("message") %>
        </div>
        <% } %>

        <form action="${pageContext.request.contextPath}/edit-librarian" method="post">

            <input type="hidden" readonly name="bookId" value="${book.id}">

            <div class="form-group">
                <label for="bookIsbn">Name:</label>
                <input type="text" class="form-control" id="bookIsbn" name="bookIsbn" value="${book.isbn}" required>

            </div>

            <div class="form-group">
                <label for="bookCondition">Condition:</label>
                <input type="text" class="form-control" id="bookCondition" name="bookCondition" value="${book.condition}">

            </div>

            <div class="form-group">
                <label for="password">Password:</label>
                <select id="bookPublisher" name="bookPublisher" required readonly>
                    <c:forEach  var="publisher" items="${publisherList}">
                        <option value="${publisher}"
                                <c:if test="${publisher == book.publisher}">selected</c:if> >${publisher}</option>
                    </c:forEach>
                </select>
            </div>

            <button type="submit" class="btn btn-primary">Update Librarian</button>
            <a href="${pageContext.request.contextPath}/list-librarian" class="btn btn-secondary">Back to Librarian List</a>
        </form>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</form>