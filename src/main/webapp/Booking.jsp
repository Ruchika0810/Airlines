<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style>
.main{
width: 100%;
height: 100%;
text-align: center;
}

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
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#e6e2d3">
<form action="" method="post">
<div class="main">
<table  style="color: olive; " class="tab">
<tr>
<th>Name</th>
<th>Gender</th>
<th>Age</th>
</tr>
<c:forEach items="${ booking }" var="book">
<tr>
<td>${book.passengerName }</td>
<td>${book.passengerGender }</td>
<td>${book.passengerAge }</td>
</tr><br>
</c:forEach>
</table><br><br>
<LABEL style="color: olive;" >TOTAL FARE: ${ tot }</LABEL><br><br>
<div class="but">
	<input type="submit" value="Confirm Booking" />
</div> 
</div>	
</form>
</body>
</html>