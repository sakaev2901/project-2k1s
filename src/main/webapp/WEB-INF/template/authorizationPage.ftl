<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Login</title>
    <link rel="stylesheet" href="css/registration_style.css" type="text/css">
</head>

<body>
<<<<<<< HEAD:src/main/webapp/WEB-INF/template/authorizationPage.ftl
<h1>Войти</h1>
<p>Пожалуйста, введите свои данные</p>
<form method="post">
    <table>
        <tr>
            <td><label for="login">Логин</label></td>
            <td><input id="login" type="text" name="login" required></td>
        </tr>
        <tr>
            <td><label for="password">Пароль</label></td>
            <td><input id="password" type="password" name="password" required></td>
        </tr>
        <tr>
            <td><button type="submit">Войти</button></td>
            <td><input id="remember" type="checkbox" name="remember" value="true">
            <label for="remember">Запомнить</label></td>
        </tr>
    </table>
</form>
<hr>
<form>
    <table>
        <tr><td><a href="passwordReset.html"><button>Забыли пароль?</button></a></td></tr>

    <tr><td><label>Нет аккаунта?</label>
        <a href="../../html/registrationPage.html"><button>Зарегистрируйтесь</button></a></td></tr>
    </table>
</form>
=======
<header>

</header>

<div class="">
    <div class="col-12 container">
        <form class="login" action="" method="post">
            <fieldset>
            <div class="header">
                <h3>Войти</h3>
                <p>Пожалуйста, введите свои данные</p>
            </div>

            <div class="sep"></div>

            <div class="inputs">
                <input id='login' type="text" name="login" placeholder="Логин" required />

                <input id="psw" type="password" name="psw" placeholder="Пароль" required />

                <button id="reset" type="reset">Сбросить</button>
                <button id="submit" type="submit">Войти</button>

                <div class="redirect-login col-12 align-self-start">Нет аккаунта? <div><a href="registrationPage.html">Зарегистрироваться</a></div></div>
            </div>
            </fieldset>
        </form>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<footer>

</footer>
>>>>>>> f86b3e62dfc3f65ad11883d028ce0516154609f4:src/main/webapp/html/authorizationPage.html
</body>

</html>