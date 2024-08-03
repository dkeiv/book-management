<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form method="POST" action="${pageContext.request.contextPath}/edit-book">
    <table>
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
                <input id="bookCondition" name="bookCondition" value="${book.condition}">
            </td>
        </tr>
        <tr>
            <td>
                <label for="bookPublisher">Publisher</label>
            </td>
            <td>
                <select id="bookPublisher" name="bookPublisher" required readonly>
                    <c:forEach var="publisher" items="${publisherList}">
                        <option value="${publisher}"
                                <c:if test="${publisher == book.publisher}">selected</c:if> >${publisher}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>
                <label for="bookCategory">Category</label>
            </td>
            <td>
                <select id="bookCategory" name="bookCategory" multiple readonly>
                    <c:forEach var="category" items="${categoryList}">
                        <option value="${category}"
                                <c:if test="${category == book.category}">selected</c:if> >${category}</option>
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
                <input id="bookImage" type="text" pattern="^https://*$" value="${book.imgUrl}">
            </td>
        </tr>
        <tr>
            <td>
                <label for="bookDescription">Description</label>
            </td>
            <td>
                <textarea id="bookDescription" name="bookDescription" cols="50" rows="4" >${book.description}</textarea>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Edit">
                <a class="btn secondary-btn btn-sm" href="?">Cancel</a>
            </td>
        </tr>
    </table>
</form>