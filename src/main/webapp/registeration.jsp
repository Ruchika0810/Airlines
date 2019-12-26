<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
.main {
auto;
width: 25%;
height: auto;
padding: 10px;
padding-top: 1px;
border: 1px solid lightgrey;
border-radius: 5px;
}

.details>input {
width: 100%;
height: 30px;
border-radius: 5px;
border: 1px solid grey;
5px;
}

.end>input {
height: 30px;
border-radius: 5px;
border: 1px solid grey;
5px;
}
</style>
</head>
<body bgcolor="powderblue" >

<form name="myForm" method="post" action="addDetails.lti" >

<div class="main">
<strong><label>Title:</label></strong>
<input type="radio" name="Title" value="Mr">Mr
<input type="radio" name="Title" value="Mrs">Mrs
<input type="radio" name="Title" value="Miss">Miss <br><br>


<div class="details">
<strong><label>FirstName:</label></strong><br>
<input type="text" name="firstname" value=""><br>

<strong><label>LastName:</label></strong><br>
<input type="text" name="lastname" value=""><br> <br>

<strong><label>Email:</label></strong><br>

<input type="email" name="email" value=""><br> <br>

<strong><label>Password:</label></strong><br>
<input type="password" id="psw" name="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, at least 8 or more characters and a special character" required>


<!-- <strong><label>Confirm Password:</label></strong><br> <input
type="password" name="confPassword" value=""><br> <br> -->

<strong><label>Date of Birth:</label></strong><br> <input
type="date" name="dateOfBirth" value=""><br> <br>

<strong><label>Phone Number:</label></strong><br>
<input type="tel" name="mobileNumber" pattern="[7-9]{1}[0-9]{9}" title="Phone number with 7-9 and remaing 9 digit with 0-9" required><br><br>
</div>

<div class="end">
<input type="submit" value="Register" onclick="validatePassword(document.form1.text1)">
<input type="submit" value="Cancel">
</div>
</div>
</form>
<!-- <script src="passwordvalidity.js"></script> -->
</body>
</html>

