<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>FreeMarker模板</title>
</head>
<body>
    <span>${name}</span>
    <ul>
    	<#list list as item>
        	<li>${item}</li>
        </#list>
    </ul>
</body>
</html>