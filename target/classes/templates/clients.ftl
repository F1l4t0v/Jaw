<#import "/spring.ftl" as spring/>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>Clients</title>
</head>
<body>
<div>
    <table border="3" bgcolor="#a9a9a9">
        <tr>
            <th>LastName</th>
            <th>FirstName</th>
            <th>Patronymic</th>
            <th>ClientStatus</th>
            <th>Delete</th>
        </tr>
        <#list clients as client>
            <tr>
                <td>${client.lastName}</td>
                <td>${client.firstName}</td>
                <td>${client.patronymic}</td>
                <td>${client.clientStatus}</td>
                <td><a href="/ui/v1/clients/${client.id}"><button>Delete</button></a></td>
            </tr>
        </#list>
    </table>
</div>
</body>
</html>