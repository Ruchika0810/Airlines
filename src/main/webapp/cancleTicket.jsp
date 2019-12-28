<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cancle Passenger Ticket</title>
</head>
<body>


<form method="post" action="finalCancellation.lti">
<table border=1>
<tr>
<th>Date Of Journey
<th>Booking Status
<th>Flight Id

</tr>

<tr>
<td>${ cancleTicketBooking.dateOfJourney }</td>
<td>${ cancleTicketBooking.bookingStatus}</td>
<td>${ cancleTicketBooking.flightId}</td>
<td><input type="submit" value="Cancle Booking" /></td>
</tr>
</table>
</form>
</body>
</html>