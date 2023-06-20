<#import "/spring.ftl" as spring/>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>Bills</title>
</head>
<body>
<div>
    <table border="3" bgcolor="#a9a9a9">
        <tr>
            <th>Client</th>
            <th>Selling</th>
            <th>Products</th>
            <th>Material</th>
            <th>Discount</th>
            <th>TotalPrice</th>
            <th>Delete</th>
        </tr>
        <#list bills as bill>
            <tr>
                <td>${bill.client.firstName}</td>
                <td>${bill.selling.client.patronymic}</td>
                <td><#list bill.products as item>
                        ${item.name}
                    </#list></td>
                <td>${bill.material.name}</td>
                <td>${bill.discount}</td>
                <td>${bill.totalPrice}</td>
                <td><a href="/ui/v1/bills/${bill.id}"><button>Delete</button></a></td>
            </tr>
        </#list>
    </table>

</div>
</body>
</html>