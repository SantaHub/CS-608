<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>

<form action="http://localhost:8080/cs610_Project3_war_exploded/name-age" method="POST">
Enter Your Name
    &nbsp;&nbsp;&nbsp;&nbsp;
    :
<input type="text" name="yourName">
<br>
    <br>
Enter Your Age
&nbsp;&nbsp;&nbsp;&nbsp;
:
<input type="text" name="yourAge">
<br>
<input type="submit" value="Click to submit">
</form>
<br/>
</body>
</html>