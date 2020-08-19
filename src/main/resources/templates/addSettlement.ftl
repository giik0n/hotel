<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Client</title>
    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/css/style.css'/>"/>
</head>
<body>

<div>
    <fieldset style="display: inline-block">
        <legend>Settlement</legend>
        <form name="room" action="" method="POST">
            <table>
                <tr>
            <td>Client</td><td><@spring.formSingleSelect "settlementForm.client", clients, ""/></td>
                </tr>
                <tr>
                    <td> Room</td><td><@spring.formSingleSelect "settlementForm.room", rooms, ""/></td>
                </tr>
                <tr>
                    <td>Check In Date</td><td><@spring.formInput "settlementForm.checkInDate" "" "text"/></td>
                </tr>
                <tr>
                    <td>Check Out Date</td><td><@spring.formInput "settlementForm.checkOutDate" "" "text"/></td>
                </tr>
                <tr>
                    <td>Comment</td><td><@spring.formInput "settlementForm.comment" "" "text"/></td>
                </tr>
            </table>
            <input type="submit" value="Save "/>
        </form>
    </fieldset>
</div>

</body>
</html>
