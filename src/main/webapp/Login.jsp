<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>

<form action="login.lti" method="post">
        <div class="panel panel-primary" style="text-align: center">
            <div class="panel-heading">
                <h3>Login Details</h3>
            </div>
            <hr>
            <div class="panel-body">
                <table align="center">
                    <tr>
                        <td><label for="username"><b>Enter your Username &nbsp; <span style="color: red">*</span></b></label></td>
                        <td>&nbsp; &nbsp;<input type="text" name="email"></td>
                        <td>&nbsp; &nbsp;(valid Username between 8 to 30 chars)</td>
                    </tr>
                    <br> <br>
                    <tr>
                        <td><label for="password"><b>Enter your Password &nbsp; <span style="color: red">*</span></b></label></td>
                        <td>&nbsp; &nbsp;<input type="password" name="password"></td>
                        <td>&nbsp; &nbsp;(valid Password between 6 to 15 chars)</td>
                    </tr>
                </table>
                     <br> <br>
            </div>
            <div class="panel-footer">
                    <button type="submit" class="btn btn-success" >Submit</button>
                    &nbsp; &nbsp; &nbsp; &nbsp;
                    <button type="reset" class="btn btn-primary">Clear</button>
                    &nbsp; &nbsp; &nbsp; &nbsp;
                    <button type="submit" class="btn btn-danger"><a style="color:white;" href="registeration.jsp" >Sign-Up </a></button>
                    &nbsp; &nbsp; &nbsp; &nbsp;
            </div>
        </div> <br> <hr> <br>


</body>
</html>