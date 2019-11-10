<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <form action="/project_2k1s_war_exploded/dictionary/test/${id}">
        <input type="submit" value="Пройти тест">
    </form>
    <table>
        <tr>
            <th>Word</th>
            <th>Translation</th>
        </tr>
        <#list dictionary as word, translation>
            <tr>
                <td>
                    ${word}
                </td>
                <td>
                    ${translation}
                </td>
            </tr>
        </#list>

    </table>
</body>
</html>