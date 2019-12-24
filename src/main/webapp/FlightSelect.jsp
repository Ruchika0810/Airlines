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
.top{
font-size: 25px;
color:white; 
text-align:justify;
}

.top nav{
display: block;
background-color:teal;
padding: 15px;
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
</head>
<body>
<div class="top">
	<nav>
		<span>${ source } -> ${ destination }</span>
		<span style="float: right; ">${ passengers } Passengers</span>
	</nav>
	</div>
	<div class="main">
	
		<table  style="color: olive; " class="tab">
			<tr>
<th>Time</th>
<th>Flight No</th>
<th>Duration</th>		
<th>Economy Price</th>
<th>Business Price</th>
				<c:forEach items="${ flightList }" var="flight">
					<tr>
						<td> ${ flight.departureTime }-
						 ${ flight.arrivalTime }</td>
						<td>${ flight.flightsDetails.flightId }</td>
						<td>${ flight.duration } </td>
						<td><INPUT TYPE="radio" name="eco"><br>${ flight.flightsDetails.economyPrice }</td>
						<td><INPUT TYPE="radio" name="eco"><br>${ flight.flightsDetails.businessPrice }</td>					
					</tr>
				</c:forEach>
		</table>
			<div class="but">
	<input type="button" value="Book"> 
	</div>
	</div>

</body>
</html>