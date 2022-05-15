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

<!-- new CSS JS Import -->

<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/bootstrap.css">
<script src="js/bootstrap.js"></script>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link
	href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/style.css">

<!-- new CSS JS Import end -->

<title>Customer Management</title>
</head>
<body>

	<!-- form container -->

	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-5">
					<h2 class="heading-section">Customer Management</h2>
				</div>
			</div>
			<div class="row justify-content-center">
				<div class="col-md-12 col-lg-10">
					<div class="wrap d-md-flex">
						<div class="img" style="background-image: url(images/customer.jpg);">
						</div>
						<div class="login-wrap p-4 p-md-5">
							<div class="d-flex">
								<div class="w-100">
									<h3 class="mb-4">Customer Details</h3>
								</div>
								
							</div>
							
							<form id="formItem" name="formItem" class="signin-form">
							
								<div class="form-group mb-3">
									<label class="label" for="name">Customer name</label> <input
										id="name" name="name" type="text" class="form-control"
										placeholder=" Name" required>
								</div>
								<div class="form-group mb-3">
									<label class="label" for="name">Address</label> <input
										id="address" type="text" name="address" class="form-control"
										placeholder="Address" required>
								</div>
								<div class="form-group mb-3">
									<label class="label" for="name">Mobile No</label> <input
										id="mobile" type="text" name="mobile" class="form-control"
										placeholder="Mobile No" required>
								</div>
						
								<div class="form-group mb-3">
									<label class="label" for="name">Email</label> <input
										id="email" type="text" name="email" class="form-control"
										placeholder="Email" required>
								</div>
								
								<div class="form-group mb-3">
									<label class="label" for="name">User name</label> <input
										id="username" type="text" name="username" class="form-control"
										placeholder="Username" required>
								</div>
								<div class="form-group mb-3">
									<label class="label" for="name">Password</label> <input
										id="password" type="text" name="password" class="form-control"
										placeholder="Password" required>
								</div>
								<div class="form-group">
								
								<input id="btnSave" name="btnSave" type="button" value="Save"
									class="form-control btn btn-primary rounded submit px-3"> 
								<input type="hidden" id="hidItemIDSave" name="hidItemIDSave" value="">
								</div>
								
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<!-- form container End-->
	<div class="container">
		<div class="row">
			<div>
				<h1 style= "text-align:center">Customer Management</h1>
				
				<div id="alertSuccess" class="alert alert-success"></div>
				<div id="alertError" class="alert alert-danger"></div>
				<br>
				<div id="divItemGrid">
					<%
					Customer CustomerObj = new Customer(); 
					out.print(CustomerObj.readCustomer()); 
					%>
				</div>
			</div>
		</div>
	</div>

	<!-- script -->

	<script src="js/jquery.min.js"></script>
	<script src="js/popper.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/main.js"></script>

	<!-- script End-->

</body>
</html>

