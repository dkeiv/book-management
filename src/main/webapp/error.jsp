<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp"%>
<%@ include file="navbar.jsp"%>
<style>
    .content {
        padding-top: 40px;
        background-color: #f3f3f3;
        height: 100vh;
    }
    .centered-box {
        display: flex;
        justify-content: center;
        height: 55px;
    }

    .styled-message {
        padding: 20px;
        border: 2px solid red; /* Border color */
        background-color: #ff9999; /* Background color for the box */
        color: #fff; /* Text color */
        text-align: center;
    }
</style>
<div class="content">
    <div class="centered-box">
        <h1 class="styled-message">
            <c:out value="${message}" />
        </h1>
    </div>
</div>