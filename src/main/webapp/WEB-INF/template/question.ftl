<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <form action="" method="post">
        <#assign correct_answers = word.getCorrectAnswers()>
        <#if (correct_answers > 9)>

            <h1 style="color: green">Поздравляем!!!</h1>
            <h2>Вы наконец-то выучили все слова!</h2>
            <#else>
                <p><b>${word.getWord()}</b></p>
                <p><input type="radio" name="answer" value="${answer1}">${answer1}</p>
                <p><input type="radio" name="answer" value="${answer2}">${answer2}</p>
                <p><input type="radio" name="answer" value="${answer3}">${answer3}</p>
                <p><input type="radio" name="answer" value="${answer4}">${answer4}</p>
                <p><input type="submit" value="Ок"></p>
        </#if>

    </form>
</body>
</html>