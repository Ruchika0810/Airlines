<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
   
<meta charset="ISO-8859-1">
<title>Payment Details</title>
</head>
<style>

    .pay{
        margin-left:450px;
        margin-top: 20px;
        text-align: center;
        text-align: left;
        padding:5%;
        border: 3px solid lightgrey;
        width: 25%;
        height: auto;
        background-color: white;
    }
   
   .top{
color:white; 
text-align:center;
}

.top nav{
display: block;
background-color:teal;
padding: 15px;
}
    </style>
<body bgcolor="#e6e2d3">
<div class="top">
<nav>
<h1 id="inner">Payment Gateway</h1></nav></div>
    <div class="pay" >
	<form name="myForm" method="post" action="addPayment.lti">
		<label>Choose Bank</label> <select name="bankName"><br>
			<option value="I D B I Bank" name="bankName">I D B I Bank</option>
			<option value="Icici Bank" name="bankName">Icici Bank</option>
			<option value="Axis Bank" name="bankName">Axis Bank</option>
			<option value="Hdfc Bank" name="bankName">Hdfc Bank</option>
			<option value="Citi Bank" name="bankName">Citi Bank</option>
			<option value="State Bank Of India" name="bankName">State Bank Of India</option>
		</select><br><br>

		<label >Card Number</label>
        <input type="number" pattern="{16}" placeholder="16 digits number" name="cardNumber"><br><br>
        
      
		<label>Security Code(CVV)</label>
		<input type="number" pattern="{3}"  placeholder="222" name="cvv"><br><br>

		<label>Name on Card</label>
		<input type="text" placeholder="Ramesh Kumar" name="nameOnCard"><br><br>
		
		<label>Expiration Date</label>
		<input type="date" max=2 placeholder="2018" name="expieryDate"><br><br>
		
		<input type="submit" value="Click Here To Pay"><br>
		
	</form>
</div>
</body>
</html>