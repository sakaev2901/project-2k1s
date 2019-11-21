<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        th {
            font-size: 13px;
            font-weight: normal;
            background: #b9c9fe;
            border-top: 4px solid #aabcfe;
            border-bottom: 1px solid #fff;
            color: #039;
            padding: 8px;
        }
        td {
            background: #e8edff;
            border-bottom: 1px solid #fff;
            color: #669;
            border-top: 1px solid transparent;
            padding: 8px;
        }
        tr:hover td {background: #ccddff;}
        table {
            margin: 0 auto;
        }

    </style>
</head>
<body>
    <form action="/project_2k1s_war_exploded/dictionary/test/${id}">
        <input type="submit" value="Пройти тест">
    </form>
    <table>
        <tr>
            <th>Word</th>
            <th>Translation</th>
            <th>Status</th>
        </tr>
        <#list dictionary as word>
            <tr>
                <td>
                    ${word.getWord()}
                </td>
                <td>
                    ${word.getTranslation()}
                </td>
                <td>
            <#assign correct_answers = word.getCorrectAnswers()>
                    <#if (correct_answers > 9) >
                        <p style="font-weight: bold; color: green">МОЛОДЕЦ!</p>
                    <#elseif (correct_answers >= 0) && (correct_answers < 4 )>
                        <p style="font-weight: bold; color: red">ДА ВЫУЧИ ТЫ УЖЕ!</p>
                    <#else>
                        <p style="font-weight: bold; color: blue">ЕЩЕ ЧУТЬ-ЧУТЬ!</p>
                    </#if>
                </td>
            </tr>
        </#list>

    </table>
</body>
</html>