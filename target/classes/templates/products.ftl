<#import "/spring.ftl" as spring/>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>Products</title>
</head>
<body>
<div>
    <table border="3" bgcolor="#a9a9a9">
        <tr>
            <th>Name</th>
            <th>Type</th>
            <th>Materials</th>
            <th>Price</th>
            <th>Delete</th>
        </tr>
        <#list products as product>
            <tr>
                <td>${product.name}</td>
                <td>${product.type}</td>
                <td><#list product.materials as item>
                        ${item.name()}
                    </#list></td>
                <td>${product.price}</td>
                <td><a href="/ui/v1/products/${product.id}"><button>Delete</button></a></td>
            </tr>
        </#list>
    </table>
</div>
</body>
</html>