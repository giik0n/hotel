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
        <legend>Client</legend>
        <form name="client" action="" method="POST">
            <table>
                <tr>
            <td>Surname</td><td><@spring.formInput "clientForm.surname" "" "text"/></td>
                </tr>
                <tr>
                    <td> Name</td><td><@spring.formInput "clientForm.name" "" "text"/></td>
                </tr>
                <tr>
                    <td>Patronymic</td><td><@spring.formInput "clientForm.patronymic" "" "text"/></td>
                </tr>
                <tr>
                    <td>Passport</td><td><@spring.formInput "clientForm.passport" "" "text"/></td>
                </tr>
                <tr>
                    <td>Comment</td><td><@spring.formInput "clientForm.comment" "" "text"/></td>
                </tr>
            </table>
            <input type="submit" value="Save "/>
        </form>
    </fieldset>
</div>

</body>
</html>
