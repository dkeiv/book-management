<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My JSP Page</title>
    <link rel="stylesheet" href="css/navbar.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css">
</head>
<style>
    .a{
        background-color: #F5F5F5;
        display: flex;
        justify-content: center;
        flex-direction: row;
        flex-wrap: wrap;
    }
</style>
<body>
<div class="app__container">
    <div id="navbar">
        <div class="container nav-height">
            <div class="nav-container">
                <div class="nav-home">
                    <i class="fa-solid fa-house"></i>
                </div>
                <a href="${pageContext.request.contextPath}/list-book">Book</a>
                <a href="${pageContext.request.contextPath}/list-user">User</a>
                <a href="${pageContext.request.contextPath}/list-category">Category</a>
                <a href="${pageContext.request.contextPath}/list-librarian">Librarian</a>
                <a href="${pageContext.request.contextPath}/list-borrow">Borrow</a>

            </div>
        </div>
    </div>
</body>
</html>

