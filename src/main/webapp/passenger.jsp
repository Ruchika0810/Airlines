<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Passenger Details</title>
</head>
<body>
<form method="post" action="addPassenger.lti"> 
<label>Enter full Name</label>
<input type="text" name="passengerName" required>
<label>Enter Email</label>
<input type="email" name="passengerEmail" required>
<label>Enter Mobile Number</label>
<input type="tel" name="mobileNumber" required>
<label>Select Gender</label>
<input type="radio" name="passengerGender" value="male" checked> Male<br>
  <input type="radio" name="passengerGender" value="female"> Female<br>
  <input type="radio" name="passengerGender" value="other"> Other  
<label>Enter Age</label>
<input type="number" name="passengerAge" required>
<input type="submit">
</form>
</body>
</html>