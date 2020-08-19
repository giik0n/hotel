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
        <legend>Room</legend>
        <form name="room" action="" method="POST">
            <table>
                <tr>
            <td>Room Number</td><td><@spring.formInput "roomForm.roomNumber" "" "text"/></td>
                </tr>
                <tr>
                    <td> Room Capacity</td><td><@spring.formInput "roomForm.roomCapacity" "" "text"/></td>
                </tr>
                <tr>
                    <td>Comfort</td><td><@spring.formInput "roomForm.comfort" "" "text"/></td>
                </tr>
                <tr>
                    <td>Price</td><td><@spring.formInput "roomForm.price" "" "text"/></td>
                </tr>
            </table>
            <input type="submit" value="Save "/>
        </form>
    </fieldset>
</div>

</body>
</html>
