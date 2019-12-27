<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Passenger Details</title>
</head>
<style>
.tab {
	top: 50%;
	left: 50%;
	margin: auto;
	padding-top: 20px;
}

.tab td
{
    padding:25px 25px 10px ;
}

.but{
	height: 35px;
	border-radius: 5px;
}

.but>input{
height: 35px;
border-radius: 5px;
border: 1px solid grey;
background:powderblue;
}
.main{
width: 100%;
height: 100%;
text-align: center;
}

.top{
color:white; 
text-align:justify;
}

.top nav{
display: block;
background-color:teal;
padding: 15px;
}
</style>
<body bgcolor="#e6e2d3">
<div class="main">
<div class="top">
<nav>
<table class="top" style="width: 100%;   ">
<tr>
<td>Hello, ${sessionScope.loggedInPassenger}</td>
<td></td>
<td style="text-align: right;">Flight No: ${ flightId }</td>
</tr>
<tr>
<td></td>
<td><h3 style="text-align: center; font-size: 20px" >${ sessionScope.source } - ${ sessionScope.destination }</h3></td>
<td style="text-align: right;">Total Fare: ${ tot }</td>
</tr>
</table></nav>
<div style="padding-top: 20px;color:#00264d;font-size: 20px"><strong>Enter Passengers Detail</strong> </div>
<form method="post" action="addPassenger.lti"> 
<table style="color:maroon; " class="tab">
<tr>
<th>Sr. No.</th>
<th>Passenger Name</th>
<th>Email</th>
<th>Mobile Number</th>
<th>Gender</th>
<th>Age</th></tr>
<c:forEach begin="1" end="${ sessionScope.passengers }" var="pp">
<tr>
<td>${ pp }</td>
<td><input type="text" name="passengers[${ pp - 1 }].passengerName" required></td>
<td><input type="email" name="passengers[${ pp - 1 }].passengerEmail" required></td>
<td><input type="tel" name="passengers[${ pp - 1 }].mobileNumber" required></td>
<td>
<input type="radio" name="passengers[${ pp - 1 }].passengerGender" value="male" >Male<br>
<input type="radio" name="passengers[${ pp - 1 }].passengerGender" value="female">Female<br>
<input type="radio" name="passengers[${ pp - 1 }].passengerGender" value="other">Other</td>
<td><input type="number" name="passengers[${ pp - 1 }].passengerAge" required></td>
</tr>
</c:forEach>
</table>
<div class="but">
	<input type="submit" value="Book Now" />
	</div> 
</form>
</div>
</body>
</html>