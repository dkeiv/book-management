<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../header.jsp"%>
<%@ include file="../navbar.jsp"%>
<form method="POST" action="${pageContext.request.contextPath}/edit-book">


    <head>
        <title>Edit Book</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>
    <div class="container mt-4">
        <h2>Edit book</h2>

        <% if (request.getParameter("message") != null) { %>
        <div class="alert alert-success" role="alert">
            <%= request.getParameter("message") %>
        </div>
        <% } %>

        <form action="${pageContext.request.contextPath}/delete-book" method="post">

            <input type="hidden" readonly name="bookId" value="${book.id}">

            <div class="form-group">
                <label for="bookIsbn">ISBN:</label>
                <input type="text" class="form-control" id="bookIsbn" name="bookIsbn" value="${book.isbn}" readonly>

            </div>

            <div class="form-group">
                <label for="bookName">Name:</label>
                <input type="text" class="form-control" id="Bookname" name="bookName" required value="${book.name}" readonly>

            </div>

            <div class="form-group">
                <label for="bookCondition">Condition:</label>
                <input type="text" class="form-control" id="bookCondition" name="bookCondition" value="${book.condition}" readonly>

            </div>

            <div class="form-group">
                <label for="bookPublisher">Publisher:</label>
                <select class="form-control" id="bookPublisher" name="bookPublisher" readonly>
                    <c:forEach  var="publisher" items="${publisherList}">
                        <option value="${publisher}"
                                <c:if test="${publisher == book.publisher}">selected</c:if> >${publisher}</option>
                        </option>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group">
                <label for="bookCategory">Category:</label>
                <select class="form-control" id="bookCategory" class="form-select" size="3" name="bookCategory" multiple="multiple" readonly>
                    <c:forEach var="category" items="${categoryList}">
                        <option value="${category.id}"
                                <c:if test="${bookCategoryList.contains(category.name)}">selected</c:if>>
                                ${category.name}
                        </option>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group">
                <label for="bookImage">Img:</label>
                <input type="text" class="form-control" name="bookImage" id="bookImage" type="url" value="${book.imgUrl}">
            </div>

            <div class="form-group">
                <label for="bookDescription">Description</label>
                <textarea type="text" class="form-control" id="bookDescription" name="bookDescription" cols="50" rows="4">${book.description}</textarea>
            </div>

            <div class="form-group">
                <label for="borrowedStatus">Status</label>
                <select type="text" class="form-control" id="borrowedStatus" name="borrowedStatus" readonly>
                    <option value="true" <c:if test="${book.borrowed== true}">selected
                    </c:if>> Borrowed
                    </option>
                    <option value="false" <c:if test="${book.borrowed == false}">selected
                    </c:if>> Available
                    </option>
                </select>
            </div>

            <button type="submit" class="btn btn-primary">Update Book</button>
            <a href="${pageContext.request.contextPath}/list-book" class="btn btn-secondary">Back to Book List</a>
        </form>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</form>