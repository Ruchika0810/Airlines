<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>

.box{
	margin-left: 50px;
	margin-top: 30px;
	width: 30%;
	height: auto;
	padding: 10px; 
	padding-top: 1px;
	border: 1px solid grey;
	border-radius: 5px;
	background-color: white;
}
input[type="radio"] {
  -webkit-appearance: none;
  -moz-appearance: none;
  appearance: none;

  display: inline-block;
  width: 20px;
  height: 20px;
  padding: 6px;

  background-clip: content-box;
  border: 2px solid #bbbbbb;
  background-color: white;
  border-radius: 50%;
}


input[type="radio"]:checked {
  background-color: blue;
}


.flex {
  display: flex;
  align-items: center;
}
.main{
	width: 100%;
}
.source{
	width: 40%	;
	display: inline-block;
	margin-right: 40px;
}
.source>input{
	border: none;
	border-bottom: 1px solid lightgrey;
	height: 30px;
	border-radius: 5px;
}

.destination{
	width: 40%;
	display: inline-block;
}
.destination>input{
	border: none;
	border-bottom: 1px solid lightgrey;
	height: 30px;
	border-radius: 5px;
}
.date{
	width: 100%;
}
.from{
	width: 40%	;
	display: inline-block;
	margin-right: 40px;
}
.from>input{
	border: none;
	border-bottom: 1px solid lightgrey;
	height: 30px;
	border-radius: 5px;
}

.to{
	width: 40%;
	display: inline-block;
}
.to>input{
	border: none;
	border-bottom: 1px solid lightgrey;
	height: 30px;
	border-radius: 5px;
}
.passengers>input{
	border: none;
	border-bottom: 1px solid lightgrey;
	height: 30px;
	border-radius: 5px;
	margin-left: 100px;
}

.search>input{
	width:50%;
	height: 35px;
	border-radius: 5px;
	border: 1px solid grey;
	background: #9999ff;
	border-color: #a88734 #9c7e31 #846a29;
	margin-top: 10px;
	margin-left: 90p30
	}
.log{
float: right; 
margin-right: 20px
	}
.log>input{
	height: 30px;
	border-radius: 5px;
	background: #9999ff;
	
	}
</style>
</head>
<body bgcolor="#cce6ff">
<form action="flight.lti" method="post">
	<label style="font-family: verdana; font-style: oblique;font-size: 30px; margin-left: 50px">
	<font color="grey">AIRLINE RESERVATION</font>
</label>
<label class="log" >
<input type="submit" name="submit" value="Login/Signup">
</label>
<div class="box">
<h2 style="margin-bottom: 0.1px"> Book A Flight</h2> <br>
<div class="flex">
<input type="radio" name="radio" value="radio1"><label for="radio1">One Way</label>  &nbsp&nbsp
<input type="radio" name="radio" value="radio2"><label for="radio2">Round Trip</label> </div><br><br>
<div class="main">
<div class="source">
<input type = text name="source"value="" placeholder="FROM"></div>
<div class="destination">
<input type = text name="destination"value="" placeholder="TO">
</div>
<br><br><br>
</div>
<div class="date">
<div class="from">
<input type = "date" name="from"value="" placeholder="Departure Date" data-date-inline-picker="true"></div>
<div class="to">
<input type = "date" name="to"value="" placeholder="Return Date" data-date-inline-picker="true">
</div>
</div>
<br><br>
<div class="passengers">
<input type="number" name="passengers" placeholder="No. of Passengers">
</div>
<br><br>
<div class="search">	
<input type="submit" name="search" value="Search Flight">
</div>
</div>
</form>
</body>
</html>
