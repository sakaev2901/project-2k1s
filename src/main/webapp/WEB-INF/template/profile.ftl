<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>profile</title>
</head>
<body>
    <#list list as name, id>
        <a href="dictionary/${id}"><p>${name}</p></a>
    </#list>
</body>
</html>