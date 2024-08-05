<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../header.jsp"%>
<%@ include file="../navbar.jsp"%>
<jsp:useBean id="now" class="java.util.Date"/>

<form method="POST" action="${pageContext.request.contextPath}/borrow-book">
    <c:if test="${successMsg != null}">
        <p>${successMsg}</p>
    </c:if>
    <table>
        <caption>
            Borrow Book
        </caption>
        <tbody>
        <tr>
            <td><label for="bookIsbn">Book ISBN:</label></td>
            <td>
                <input id="bookIsbn" name="bookIsbn" required pattern="[0-9\-]+">
                <c:if test="${invalidBookMsg != null}">
                    <span>${invalidBookMsg}</span>
                </c:if>
            </td>
        </tr>
        <tr>
            <td><label for="userId">User ID:</label></td>
            <td><input id="userId" name="userId" required pattern="[0-9]+"></td>
        </tr>
        <tr>
            <td><label for="borrowDate">Borrow Date:</label></td>
            <td><input id="borrowDate" name="borrowDate" required type="date"
                       value="<fmt:formatDate value="${now}" pattern="yyyy-MM-dd" />"></td>
        </tr>
        <tr>
            <td><label for="returnDate">Return Date:</label></td>
            <td><input id="returnDate" name="returnDate" required type="date"></td>
        </tr>
        <input type="hidden" name="borrowStatus" value="BORROWING">
        <tr>
            <td><input type="submit" value="Submit"></td>
        </tr>
        </tbody>
    </table>
</form>
