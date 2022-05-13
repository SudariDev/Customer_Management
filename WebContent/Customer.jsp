<%@ page import="com.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.6.0.min.js"></script>
<script src="Components/Customer.js"></script>


<meta charset="ISO-8859-1">
<title>Customer Management</title>
</head>
<body>

<div class="container"><div class="row"><div class="col-6">
<h1>Customer details</h1>

	<form id="formItem" name="formItem">
		
		Customer Name:
		<input id="name" name="name" type="text" class="form-control form-control-sm"><br> 
		Address:
		<input id="address" name="address" type="text" class="form-control form-control-sm"><br>
		Mobile:
		<input id="mobile" name="mobile" type="text" class="form-control form-control-sm"><br>
		Email:
		<input id="email" name="email" type="text" class="form-control form-control-sm"><br>
		User Name:
		<input id="username" name="username" type="text" class="form-control form-control-sm"><br> 
		Password:
		<input id="password" name="password" type="password" class="form-control form-control-sm"><br> 
		
		<input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-primary">
		<input type="hidden" id="hidItemIDSave" name="hidItemIDSave" value="">
	</form>
	
	<div id="alertSuccess" class="alert alert-success"></div>
<div id="alertError" class="alert alert-danger"></div>
	<br>
	<div id="divItemGrid">
	<%
	Customer CustomerObj = new Customer(); 
	out.print(CustomerObj.readCustomer()); 
	%>
	</div>
</div> </div> </div> 
	
</body>
</html>