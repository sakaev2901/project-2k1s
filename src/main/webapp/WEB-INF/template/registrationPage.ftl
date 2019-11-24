<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Sign Up</title>
    <link rel="stylesheet" href="resources\css\registration_style.css" type="text/css">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script src="../js/registration.js" type="text/javascript"></script>
</head>

<body>
<header>
    <!--<h1>Header</h1>-->
</header>

<div class="">
    <div class="col-12 container">
        <form class="signUp" id="signUp" method="post">
            <fieldset>
                <div class="header">
                    <h3>Создайте учетную запись</h3>
                    <p>Пожалуйста, введите свои данные</p>
                </div>

                <div class="sep"></div>

                <div class="inputs">

                    <input id='login' type="text" name="login" placeholder="Логин" required />

                    <input  type="text" name="firstname" placeholder="Имя"/">

                    <input id='surname-input' type="text" name="surname" placeholder="Фамилия"  />

                    <input id='birthDay' type="date" name="birthday" placeholder="Дата рождения" required />

                    <input id="email" type="email" name="mail" placeholder="Почта" required/>

                    <input id="number" type="tel" name="phone" placeholder="Номер телефона" required />

                    <input id="psw" type="password" name="password" placeholder="Пароль" required minlength="6" maxlength="20" />

                    <input id="psw-repeat" type="password" name="psw-repeat" placeholder="Подтверждение пароля" required />

                    <button id="reset" type="reset">Сбросить</button>
                    <button id="submit" type="submit">Далее</button>

                    <div class="redirect-login col-12 align-self-start">Уже зарегестрированы? <div><a href="login">Войти</a></div></div>
                </div>
            </fieldset>
        </form>
    </div>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<footer>

</footer>
</body>

</html>