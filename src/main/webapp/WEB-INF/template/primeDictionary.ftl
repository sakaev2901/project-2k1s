<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <#list dictionary as item>
        <p>
            ${item.getWord()} - ${item.getTranslation()}
        </p>
        <p>
            <img src="../resources${item.getPhotoPath()}">
        </p>
        <p>
            <audio controls src="../1.ogg" >
                <#--<source src="../resources${item.getSpeechPath()}" type="audio/mpeg">-->
            </audio>
        </p>
        <hr>
    </#list>
</body>
</html>