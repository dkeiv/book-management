<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../header.jsp"%>
<%@ include file="../navbar.jsp"%>

<form method="POST" action="${pageContext.request.contextPath}/delete-book">
    <table>
        <tr>
            <td>
                <label for="bookIsbn">Book</label>
            </td>
            <td>
                <input id="bookIsbn" name="bookIsbn" required readonly>
            </td>
        </tr>

        <tr>
            <td>
                <label for="bookName">Name</label>
            </td>
            <td>
                <input id="bookName" name="bookName" required readonly>
            </td>
        </tr>
        <tr>
            <td>
                <label for="bookCondition">Condition</label>
            </td>
            <td>
                <input id="bookCondition" name="bookCondition" readonly>
            </td>
        </tr>
        <tr>
            <td>
                <label for="bookPublisher">Publisher</label>
            </td>
            <td>
                <select id="bookPublisher" name="bookPublisher" required readonly>
                    <c:forEach var="publisher" items="${publisherList}">
                        <option value="${publisher}">${publisher}</option>
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
                        <option value="${category}">${category}</option>
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
                <input id="bookImage" type="text" pattern="^https://*$" readonly>
            </td>
        </tr>
        <tr>
            <td>
                <label for="bookDescription">Description</label>
            </td>
            <td>
                <textarea id="bookDescription" name="bookDescription" cols="50" rows="4" readonly></textarea>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Delete">
                <a class="btn secondary-btn btn-sm" href="?">Cancel</a>
            </td>
        </tr>
    </table>
</form>