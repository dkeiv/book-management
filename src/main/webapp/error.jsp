<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page errorPage="error.jsp" %>
<%-- error.jsp --%>
<%@ page isErrorPage="true" %>

<div>
    <h1>An error occurred:</h1>
    <p>
        <c:out value="${message}" />
    </p>
    <p>
        <c:out value="${exception.message}" />
    </p>
</div>