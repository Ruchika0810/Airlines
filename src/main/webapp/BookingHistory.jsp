<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="finalCancellation.lti">
<table border=1>
<tr>
<th>Booking Id</th>
<th>Date of Journey</th>
<th>Booking Status</th>
<th>Flight Id</th>
<th>Registeration Id</th>
</tr>
<c:forEach items="${ bk }" var="book">
<tr>
<td>${ book.bookingId }</td>
<td>${ book.dateOfJourney}</td>
<td>${ book.bookingStatus}</td>
<td>${ book.flightId}</td>
<td>${ book.registeration.registerationId}</td>
</tr>
</c:forEach>
</table>
</form>
</body>
</html>