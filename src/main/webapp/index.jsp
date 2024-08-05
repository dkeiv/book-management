<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Libary</title>
</head>
<body>
<div id="container">
    <jsp:include page="header.jsp" />
    <jsp:include page="navbar.jsp" />
    <c:if test='${requestScope["message"] != null}'>
        <jsp:include page="success.jsp"/>
    </c:if>
</div>
</body>
</html>