<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <form enctype="multipart/form-data" method="post">
        <#list dictionary as item>
            <p>
                <input type="text" name="word" value="${item.getWord()}">
                <input type="text" name="translation" value="${item.getTranslation()}">
                <input type="file" name="photo">
            </p>
            <hr>
        </#list>
        <input type="submit" value="Сохранить">
    </form>

</body>
</html>