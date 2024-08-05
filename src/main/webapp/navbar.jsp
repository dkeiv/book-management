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
    <div class="container">
        <div class="app-content">
            <div class="col1">
                <nav class="category">
                    <h3 class="category-heading">
                        <i class="category-heading-icon fa-solid fa-list"></i>
                        Danh Mục
                    </h3>

                    <ul class="category-list">
                        <li class="category-item category-item-active">
                            <a href="#" class="category-item__link">Áo Khoác Nữ</a>
                        </li>
                        <li class="category-item">
                            <a href="#" class="category-item__link">Áo Khoác Nam</a>
                        </li>
                        <li class="category-item">
                            <a href="#" class="category-item__link">Áo Phông Nam Nữ</a>
                        </li>
                        <li class="category-item">
                            <a href="#" class="category-item__link">Áo Polo</a>
                        </li>
                        <li class="category-item">
                            <a href="#" class="category-item__link">Áo Hoodie</a>
                        </li>
                        <li class="category-item">
                            <a href="#" class="category-item__link">Quần jean</a>
                        </li>
                        <li class="category-item">
                            <a href="#" class="category-item__link">Quần bò</a>
                        </li>
                        <li class="category-item">
                            <a href="#" class="category-item__link">Phụ kiện</a>
                        </li>
                    </ul>
                </nav>
            </div>

            <div class="col2 ">
                <span>aaaaaaaa</span>
            </div>
        </div>
    </div>
</body>
</html>

