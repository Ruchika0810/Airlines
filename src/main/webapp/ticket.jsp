<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
#main{
    margin: auto;
    width: 60%;
}

.heading{
    height:auto;
    width: 100%;
   text-align: center;
  font-size: x-large;
 
}

.travel{
    padding-top: 5%;
}
.space {
margin-top: 0px;
border-collapse: collapse;
width: 100%;
}
.space td, .space th {
border: 1px solid;
padding: 8px;
}
.space th {
padding-top: 12px;
padding-bottom: 12px;
text-align: left;
background-color: lightcoral;
}

</style>
</head>
<body>
    

<div class="heading">  
 <h1>TOOFANI AIRLINES </h1>  
</div>
<div id="main">
<h2>Passenger Information</h2>
<table class="space">
<c:forEach items="${ sessionScope.booking }" var="book">
<tr><td><strong>Name:</strong> ${ book.passengerName}</td></tr>
</c:forEach>
</table>


    <div class="travel">
        <h2>Travel Information</h2>
       <table class="space">
            <tr>
              <th>Travel Date</th>
              <th>Flight No.</th>
              <th>FROM/TERMINAL</th>
              <th>TO/TERMINAL</th>
              <th>DEP.TIME</th>
              <th>ARR.TIME</th>
            </tr>
            <tr>
              <td>${ sessionScope.date }</td>
              <td>${ sessionScope.flightId }</td>
              <td> ${ sessionScope.source }</td>
              <td> ${ sessionScope.destination }</td>
              <td> ${ sessionScope.dept }</td>
              <td>${ sessionScope.arrive } </td>
            </tr>
        </table>
        <table class="space">
            <tr>
              <th>Confirmation Number (PNR): </th>
              <th>Status:</th>
            </tr>
        
            <tr>
              <td>${ sessionScope.details.bookingId }</td>
              <td>${ sessionScope.details.bookingStatus }</td>
            </tr>
           
          </table>
    </div>
</div>
</body>
</html>