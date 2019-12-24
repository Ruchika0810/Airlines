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
}

.tab td
{
    padding:5px 15px 10px ;
}
</style>
</head>
<body>
	<div class="main">
		<h1 style="color: red">FLIGHTS FOR THE SELECTED OPTIONS ARE</h1>
		<table border="1" style="color: olive; " class="tab">
			<tr>
<th>Flight No</th>
<th>Source</th>
<th>Destination</th>
<th>Economy Price</th>
<th>Business Price</th>
<th>Seat Availability</th>
<th>Date</th>
<th>Departure Time</th>
<th>Arrival Time</th>
<th>Duration</th>		
				<c:forEach items="${ flightList }" var="flight">
					<tr>
						<td>${ flight.flightsDetails.flightId }</td>
						<td>${ flight.flightsDetails.source }</td>
						<td>${ flight.flightsDetails.destination }</td>
						<td>${ flight.flightsDetails.economyPrice }</td>
						<td>${ flight.flightsDetails.businessPrice }</td>
						<td>${ flight.flightsDetails.seatAvailablity }</td>
						<td>${ flight.scheduleDate } </td>
						<td>${ flight.arrivalTime } </td>
						<td>${ flight.departureTime } </td>
						<td>${ flight.duration } </td>
						<%-- <td><input  value="${ flight.flightSchedules.getArrivalTime().toString() }" readonly></td> --%>
						<td><input type="button" value="Book" /></td>
					</tr>
				</c:forEach>

		</table>
	</div>
</body>
</html>