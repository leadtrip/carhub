<!doctype html>
<html>
<head>
    %{--<meta name="layout" content="main">--}%
    <asset:stylesheet src="bootstrap.css"/>
    <style type="text/css">
        body {
            background-image: url("${car.images[0].uri}");
            background-repeat: no-repeat;
        }
    </style>
</head>
<body>
<div style="padding: 20px">
<dl class="dl-horizontal" style="font-size: 22px; font-family: Calibri;">
    <dt>Manufacturer</dt>
    <dd>${car.manufacturer}</dd>

    <dt>Model</dt>
    <dd>${car.model}</dd>

    <dt>Aspiration</dt>
    <dd>${car.aspiration}</dd>

    <dt>BHP</dt>
    <dd>${car.bhp}</dd>

    <dt>Cylinders</dt>
    <dd>${car.cylinders}</dd>

    <dt>Displacement</dt>
    <dd>${car.displacement}</dd>
</dl>

</div>
%{--<div>
    <g:each in="${car.images}" var="img">
        <dt></dt>
        <dd><g:img uri="${img.uri}" width="400" height="400"/></dd>
    </g:each>
</div>--}%
</body>
</html>