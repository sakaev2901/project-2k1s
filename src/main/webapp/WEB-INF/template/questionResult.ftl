<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<p><b>${word}</b></p>
<#if wrongAnswer??>
    <p>Wrong answer: <span>${wrongAnswer}</span></p>
    <p>Correct answer: <span>${correctAnswer}</span></p>
    <#else>
        <p>You're right !</p>
</#if>
<form action="">
    <input type="submit" value="Next">
</form>
</body>
</html>