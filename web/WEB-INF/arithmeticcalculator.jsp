
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Week2Lab_Calculators</title>
    </head>
    <body>
        <h1>Arithmetic Calculator</h1>

        <form method="post">
            <label>First: </label><input type="text" name="first_number" value="${firstNum}">
            <br>
            <label>Second: </label><input type="text" name="second_number" value="${secondNum}">
            <br>
            <input type="submit" name="addition" value="+">&nbsp;
            <input type="submit" name="subtraction" value="-">&nbsp;
            <input type="submit" name="multiplication" value="*">&nbsp;
            <input type="submit" name="modulus" value="%">&nbsp;
            <p>Result: ${resultMessage}</p>
            <a href="age">Age Calculator</a>
        </form>
    </body>
</html>
