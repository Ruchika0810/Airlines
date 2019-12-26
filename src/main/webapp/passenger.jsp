<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Passenger Details</title>
</head>
<body>
<h2>Welcome</h2><!-- ${sessionScope.loggedInPassenger.email } -->
<h3>${ sessionScope.passengers }</h3>
<form method="post" action="addPassenger.lti"> 
<c:forEach begin="1" end="${ sessionScope.passengers }" var="pp">
	<label>Enter full Name of Passenger ${ pp }</label>
	<input type="text" name="passengers[${ pp - 1 }].passengerName" required>
<label>Enter Email</label>
<input type="email" name="passengers[${ pp - 1 }].passengerEmail" required>
<label>Enter Mobile Number</label>
<input type="tel" name="passengers[${ pp - 1 }].mobileNumber" required>
<label>Select Gender</label>
<input type="radio" name="passengers[${ pp - 1 }].passengerGender" value="male" > Male<br>
  <input type="radio" name="passengers[${ pp - 1 }].passengerGender" value="female"> Female<br>
  <input type="radio" name="passengers[${ pp - 1 }].passengerGender" value="other"> Other  
<label>Enter Age</label>
<input type="number" name="passengers[${ pp - 1 }].passengerAge" required>

</c:forEach>

<input type="submit">
</form>
</body>
</html>