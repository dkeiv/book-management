<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<ul>
    <li>
        <a href="${pageContext.request.contextPath}/list-book">Book</a>
    </li>
    <li>
        <a href="${pageContext.request.contextPath}/borrow-book-form">Borrow Book</a>
    </li>
    <li>
        <a href="${pageContext.request.contextPath}/create-book-form">Create Book</a>
    </li>
    <li>
        <a href="${pageContext.request.contextPath}/create-user-form">Create User</a>
    </li>
</ul>

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
                <a href="#">HOT</a>
                <a href="#">THEO DÕI</a>
                <a href="#">LỊCH SỬ</a>
                <a href="#">THỂ LOẠI</a>
                <a href="#">XẾP HẠNG</a>
                <a href="#">FANPAGE</a>
            </div>
        </div>
    </div>
</body>
</html>

