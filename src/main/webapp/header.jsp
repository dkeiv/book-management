<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My JSP Page</title>
    <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css">
</head>
<style>
    .header__cart-item{
        display: flex;
        align-items: center;
        justify-content: center;
        padding: 10px 5px;
    }

    .header__cart-list-item {
        height: 25vh;
    }

    .header__cart-list {
        width: 210px;
    }

    .header {
        display: flex;
        justify-content: center;
    }

    .header__cart-heading {
        margin: 10px 0 10px 10px;
    }
    .btn--primary{
        display: block;
        background-color: var(--primary-color);
        border: none;
        height: 30px;
        border-radius: 2px;
        margin: 3px;
        padding: 5px 0 0 0;
        width: 98%;
        text-decoration: none;
        font-size: 14px;
        color: #fff;
    }
    .header__logo  {
        padding-top: 4px;
    }
</style>
<body>
<div class="header ">
    <!-- Header with search -->
    <div class="container">
        <div class="header-with-search">
            <div class="header__icon-mobile">
                <div class="header__icon-list">
                    <i class="fa-solid fa-bars"></i>
                </div>
                <label for="mobile-search-checkbox" class="header__icon-search-mb">
                    <i class="fa-solid fa-magnifying-glass"></i>
                </label>
            </div>
            <div class="header__logo hide-on-tablet">
                <a href="" class="header__logo-link">
                    <img class="header__logo-img" src="./css/img/logo.png">
                </a>
            </div>

            <input type="checkbox" hidden id="mobile-search-checkbox" class="header__search-checkbox">

            <div class="header__search ">
                <div class="header__search-input-warp">
                    <c:if test="${pageTitle != null}">
                        <input type="text" class="header__search-input" placeholder="Nhập để tìm kiếm..."
                               value="${pageTitle}" name="pageTitle">
                    </c:if>
                </div>
                <button class="header__search-btn">
                    <i class="header__search-btn-icon fa-solid fa-magnifying-glass"></i>
                </button>
            </div>
            <div class="header__cart ">
                <div class="header__cart-warp">
                    <i class=" header__cart-icon fa-solid fa-list"></i>

                    <!-- No Cart: header__cart--no-cart -->
                    <div class="header__cart-list ">
                        <span class="header__cart-heading ">Quản lý tài khoản</span>
                        <ul class="header__cart-list-item">
                            <li class="header__cart-item">
                                <h2 >Cài đặt</h2>
                            </li>
                            <li class="header__cart-item">
                                <h2 >Cài đặt</h2>
                            </li>
                            <li class="header__cart-item">
                                <h2 >Cài đặt</h2>
                            </li>
                            <li class="header__cart-item">
                                <h2 >Cài đặt</h2>
                            </li>
                            <li class="header__cart-item">
                                <h2 >Cài đặt</h2>
                            </li>
                        </ul>
                        <a href="#" class="btn btn--primary">Đăng xuất</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>