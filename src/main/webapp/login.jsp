<style>
    <%@ include file="css/login.css"%>
</style>

<body>
<div class="header">
    <p>Welcome to the library</p>
</div>
<div class="wrapper">
    <div class="card-switch">
        <label class="switch">
            <input class="toggle" type="checkbox">
            <span class="slider"></span>
            <span class="card-side"></span>
            <div class="flip-card__inner">
                <div class="flip-card__front">
                    <div class="title">Log in</div>
                    <form action="login-form" class="flip-card__form" method="post">
                        <input type="email" placeholder="Email" name="email" class="flip-card__input">
                        <input type="password" placeholder="Password" name="password" class="flip-card__input">
                        <button class="flip-card__btn">Let`s go!</button>
                    </form>
                </div>
                <div class="flip-card__back">
                    <div class="title">Sign up</div>
                    <form action="" class="flip-card__form">
                        <input type="text" placeholder="Name" class="flip-card__input">
                        <input type="email" placeholder="Email" name="email" class="flip-card__input">
                        <input type="password" placeholder="Password" name="password" class="flip-card__input">
                        <button class="flip-card__btn">Confirm!</button>
                    </form>
                </div>
            </div>
        </label>
    </div>
</div>
</body>
</html>
