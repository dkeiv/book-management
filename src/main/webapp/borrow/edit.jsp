<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../navbar.jsp" %>
<jsp:useBean id="now" class="java.util.Date"/>

<form method="POST" action="${pageContext.request.contextPath}/borrow-book">
    <table>
        <caption>
            Borrow Book
        </caption>
        <tbody>
        <tr>
            <td><label for="bookIsbn">Book ISBN:</label></td>
            <td><input id="bookIsbn" name="bookIsbn" required pattern="[0-9\-]+" value="${borrowBook.bookIsbn}"></td>
        </tr>
        <tr>
            <td><label for="userId">User ID:</label></td>
            <td><input id="userId" name="userId" required pattern="[0-9]+" value="${borrowBook.userId}"></td>
        </tr>
        <tr>
            <td><label for="borrowDate">Borrow Date:</label></td>
            <td><input id="borrowDate" name="borrowDate" required type="date"
                       value="${borrowBook.borrowDate}"></td>
        </tr>
        <tr>
            <td><label for="returnDate">Return Date:</label></td>
            <td><input id="returnDate" name="returnDate" required type="date" value="${borrowBook.returnDate}"></td>
        </tr>


        <tr>
            <td><label for="borrowStatus">Status:</label></td>
            <td>
                <select id="borrowStatus" readonly disabled>
                    <c:forEach var="status" items="${statusList}">
                        <option value="${status}" <c:if
                                test="${status.description == borrowBook.status }"> selected </c:if>>${status.description}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"></td>
        </tr>
        </tbody>
    </table>
</form>
