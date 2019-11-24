<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>profile</title>
</head>
<body>
    <p>${user}</p>
    <#list list as name, id>
        <a href="dictionary/${id}"><p>${name}</p></a>
    </#list>
    <a href="primeHub">Prime Hub</a>
    <form action="logout">
        <input type="submit" value="Выйти">
    </form>
</body>
</html>