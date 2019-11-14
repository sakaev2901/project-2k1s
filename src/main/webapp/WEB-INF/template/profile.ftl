<!DOCTYPE html>
<html lang="en">
<head>
    <#include "style.css">
    <meta charset="UTF-8">
    <title>profile</title>
    <link rel="stylesheet" href="/style.css" type="text/css">
</head>
<body>
<header>
    <nav>
        <ul class="nav-links">
            <li><a href="profile">Профиль</a></li>
            <li><a href="parsing">Создать тест </a></li>
            <li><a href="logout">Выйти</a></li>
        </ul>
    </nav>
</header>
<main>
    <#list list as name, id>
        <a class="item">
            <div>
            <a href="dictionary/${id}">
                <div class="dictionary-item">
                    ${name}
                </div>
            </a>
            </div>
        </a>
    </#list>
</main>


</body>
</html>