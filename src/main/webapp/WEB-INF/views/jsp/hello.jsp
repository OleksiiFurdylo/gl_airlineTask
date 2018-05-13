<%--
  Created by IntelliJ IDEA.
  User: OleksiiF
  Date: 11.05.2018
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello page</title>
</head>
<body>
Add Aircraft:
<form action = "aircraft" method = "POST" align = "middle">
    name: <input type = "text" name = "name" required >
    <br />
    cargo_volume: <input type = "text" name = "cargo_volume" required />
    <br />
    passenger_quantity: <input type = "text" name = "passenger_quantity" >
    <br />
    fuel_capacity: <input type = "number" name = "fuel_capacity" required />
    <br />
    range: <input type = "number" name = "range" required >
    <br />
    serial_number(unique): <input type = "text" name = "serial_number" required />
    <br />
    fuel_consumption: <input type = "number" name = "fuel_consumption" required >
    <br />
    load_weight: <input type = "text" name = "load_weight" />
    <br />
    company_id: <input type = "number" name = "company_id" required >
    <br />
    <input type = "checkbox" name = "passenger_aircraft" /> Passenger Aircraft

    <input type = "checkbox" name = "cargo_aircraft"  /> Cargo Aircraft
    <br />
    <input type = "submit" value = "Submit" />
</form>

${add_status}

<br />
Find aircraft corresponding to the specified range of fuel consumption
parameters (liters per hour)
Set min and max consumption:
<form action = "aircraft/fuel_range" method = "GET" align = "middle">
    min: <input type = "number" name = "min" required >
    <br />
    max: <input type = "number" name = "max" required />
    <br />
    <input type = "submit" value = "Submit" />
</form>
<br />
Find aircraft which corresponding to the specified passenger capacity
and the flight range

<form action = "aircraft/passenger_range_match" method = "GET" align = "middle">
    Set min and max passenger capacity:
    <br />
min: <input type = "number" name = "minP" required >
<br />
max: <input type = "number" name = "maxP" required />
<br />

Set min and max flight range:
<br />
min: <input type = "number" name = "minR" required >
<br />
max: <input type = "number" name = "maxR" required />
<br />
<input type = "submit" value = "Submit" />
</form>
</body>
</html>
