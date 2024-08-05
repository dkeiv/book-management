<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../header.jsp" %>
<c:if test="${message != null}">
    <p>${message}</p>
</c:if>
<form method="POST" action="${pageContext.request.contextPath}/delete-book">
    <input type="hidden" readonly name="bookId" value="${book.id}">
    <table>
        <tr>
            <td>
                <label for="bookIsbn">ISBN</label>
            </td>
            <td>
                <input id="bookIsbn" name="bookIsbn" value="${book.isbn}" required readonly>
            </td>
        </tr>
        <tr>
            <td>
                <label for="bookName">Name</label>
            </td>
            <td>
                <input id="bookName" name="bookName" required value="${book.name}" readonly>
            </td>
        </tr>
        <tr>
            <td>
                <label for="bookCondition">Condition</label>
            </td>
            <td>
                <input id="bookCondition" name="bookCondition" value="${book.condition}" readonly>
            </td>
        </tr>
        <tr>
            <td>
                <label for="bookPublisher">Publisher</label>
            </td>
            <td>
                <select id="bookPublisher" name="bookPublisher" required readonly disabled>
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
                <select id="bookCategory" class="form-select" size="3" name="bookCategory" multiple="multiple" readonly disabled>
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
                <input id="bookImage" type="url" value="${book.imgUrl}" name="bookImage" readonly>
            </td>
        </tr>
        <tr>
            <td>
                <label for="bookDescription">Description</label>
            </td>
            <td>
                <textarea id="bookDescription" name="bookDescription" cols="50" rows="4" readonly>${book.description}</textarea>
            </td>
        </tr>
        <tr>
            <td>
                <label for="borrowedStatus">Status</label>
            </td>
            <td>
                <select id="borrowedStatus" name="borrowedStatus" required readonly disabled>
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
                <input type="submit" value="Delete">
                <a class="btn secondary-btn btn-sm" href="${pageContext.request.contextPath}/list-book">Cancel</a>
            </td>
        </tr>
    </table>
</form>