<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Clients List</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <script src="https://use.fontawesome.com/7158ac61f7.js"></script>

</head>
<body>
<div style="background-color: rgba(57,61,65,1)">
    <a href="/"><img src="https://img.icons8.com/fluent/48/000000/back.png"/></a>
    <table class="table table-striped table-dark">
        <tr>
            <th>Client</th>
            <th>Room</th>
            <th>Check In Date</th>
            <th>Check In Date</th>
            <th>Comment</th>
            <th>Update</th>
            <th>Delete</th>
        </tr>
        <#list list as item>
            <tr>
                <td>${item.client.name} ${item.client.surname}</td>
                <td>${item.room.roomNumber}</td>
                <td>${item.checkInDate}</td>
                <td>${item.checkOutDate}</td>
                <td>${item.comment}</td>
               <td><a href="http://localhost:8080/web/settlement/update/${item.settlementId}">
                        <input type="button" value="update" class="btn-primary">
                    </a> </td>
                <td><a href="http://localhost:8080/web/settlement/delete/${item.settlementId}">
                        <input type="button" value="delete" class="btn-danger">
                    </a></td>
            </tr>
        </#list>
    </table>
    <div>
        <a href="/web/settlement/create">
            <input type="button" value="Create Settlement From" style="
                        background-color: aquamarine;
                        border-color: aqua;
                        border-radius: 30px;
                        border-width: 10px;
                ">
        </a>
    </div>
</div>
</body>

</html>
