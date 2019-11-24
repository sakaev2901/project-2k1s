<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <#list dictionaries as item>
        <p>
            <a href="primeDictionary/${item.getId()}">
                ${item.getName()}
            </a>
        </p>
    </#list>
</body>
</html>