
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Week2Lab_Calculators</title>
    </head>
    <body>
        <h1>Age Calculator</h1>
        <form method="post">
            <label>Enter your age: </label><input type="text" name="age_input" value="${currentAge}">
            <br>
            <input type="submit" name="next_bday" value="Age next birthday">
            <br>
            <span>${age_message}</span>
            <br>
            <a href="arithmetic">Arithmetic Calculator</a>
        </form>
    </body>
</html>
