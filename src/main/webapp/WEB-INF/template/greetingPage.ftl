<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <#include "greetingPageStyles.css">
    <title>Welcome!</title>
    <link rel="stylesheet" href="css/greetingPageStyles.css" type="text/css">
</head>

<body>
    <div class="nav-bar-container">
        <div class="nav-bar-title">LS</div>
        <div class="nav-bar-search">
            <form>
                <div class="form-group">
                    <input type="search" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Поиск по тестам...">
                    <small id="emailHelp" class="form-text text-muted"></small>
                </div>
            </form>
        </div>
        <div class="nav-bar-username">
            <div class="nav-bar-userpic">
                <img class="nav-bar-userpic-pic" src="resources/images/avatar_square.png" alt="Grapefruit slice atop a pile of other slices">
            </div>
            <a class="nav-link" href="ProfilePage.html">Joseph</a>
        </div>
        <div class="nav-bar-other">
            <div class="nav-bar-test-premium"><a class="nav-link" href="TestPage.html"> Создать премиум тест </a></div>
            <div class="nav-bar-test"><a class="nav-link" href="TestPage.html">Создать тест</a></div>
            <div class="nav-bar-more">
                <div class="dropdown">
                    <button class="btn dropdown-toggle nav-bar-dropdown-button" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Show More
                    </button>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                        <a class="dropdown-item" href="ProfilePage.html">мои тесты</a>
                        <a class="dropdown-item" href="AboutPage.html">About</a>
                        <a class="dropdown-item" href="todo.html">Контакты</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="#">Log out</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="nav-bar-mode">
        </div>
    </div>

    <div class="home-container">
        <div class="home-list">
            <div class="home-list-header">
                <h1>Добро пожаловать!</h1>
            </div>
            <div class="home-list-text">
                Learning Service - Сайт с адаптивными тестами для изучения иностранных языков. Единицей теста является перевод слова с выбором одного варианта ответа. Тесты могут созданы пользователем: настраиваемый парсинг текстового файла или собственноручное добавление
                каждого слова. Также сайт будем иметь свой уникальные тесты, которые пользователь может добавить, подключив premium-доступ.
            </div>
            <div class="home-list-button-container">
                <button class="btn home-list-button" type="button">Создать тест</button>
            </div>
        </div>
    </div>

    <div class="home-footer">
        <div class="home-footer-item"><a class="home-footer-contacts" href="ContactsPage.html">Наши Контакты</a></div>
        <div class="home-footer-item"><a class="home-footer-test" href="AboutPage.html">О нас</a></div>
        <div class="home-footer-item">All copyrightes reserved</div>

    </div>

</body>

</html>