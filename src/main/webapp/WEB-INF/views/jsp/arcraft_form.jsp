<%--
  Created by IntelliJ IDEA.
  User: OleksiiF
  Date: 11.05.2018
  Time: 23:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Aircraft</title>
</head>
<body>

<form action = "hello" method = "POST">
    name: <input type = "text" name = "first_name">
    <br />
    cargo_volume: <input type = "text" name = "cargo_volume" />
    <br />
    passenger_quantity: <input type = "text" name = "passenger_quantity">
    <br />
    fuel_capacity: <input type = "text" name = "fuel_capacity" />
    <br />
    range: <input type = "text" name = "range">
    <br />
    serial_number: <input type = "text" name = "serial_number" />
    <br />
    fuel_consumption: <input type = "text" name = "fuel_consumption">
    <br />
    load_weight: <input type = "text" name = "load_weight" />
    <br />
    company_id: <input type = "text" name = "company_id">
    <br />
    <input type = "checkbox" name = "passenger_aircraft" checked = "checked"/> Passenger Aircraft

    <input type = "checkbox" name = "cargo_aircraft"  /> Cargo Aircraft
    <br />
    <input type = "submit" value = "Submit" />
</form>

</body>
</html>
