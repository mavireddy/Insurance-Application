<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.dropdown, body, h1, h2, h3, h4, h5, h6 {
	font-family: "Lato", sans-serif
}

.dropdown, .w3-bar, h1, button {
	font-family: "Montserrat", sans-serif
}

.fa-anchor, .fa-coffee {
	font-size: 200px
}

.dropdown {
	font-size: 20px
}

.location {
	font-family: "Comic Sans MS", cursive, sans-serif
}

.w3-blue {
	background-color: #4e69a2, color:#4e69a2
}
</style>
<title>PSB Parks</title>
</head>
<%-- <body>

<h1>Details of the Vehicles</h1>
 Vehicle :  ${Vehicle.model} <br>
 Model Year : ${Vehicle.year} <br>
 Vin Number : ${Vehicle.vin_number}<br>
 
 <h1>Details of the Driver</h1>
 
 Name : ${Driver.name} <br>
 
 
 <h1>Final Quote Amount : ${Amount}</h1>

</body>
</html> --%>

<body>
<div class="w3-top">
		<div class="w3-bar w3-amber w3-card w3-left-align w3-large">
			<a
				class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-amber"
				href="javascript:void(0);" onclick="myFunction()"
				title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a> <a
				href="home" class="w3-bar-item w3-button w3-padding-large w3-white">Home</a>

			<a href="login.html"
				class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Insurance</a>

			<a href="register.html"
				class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Claims</a>
			<!--  <a href="#" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white"></a>
    <a href="#" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Link 4</a> -->
		</div>

		<!-- Navbar on small screens -->
		<div id="navDemo"
			class="w3-bar-block w3-white w3-hide w3-hide-large w3-hide-medium w3-large">
			<a href="#" class="w3-bar-item w3-button w3-padding-large">Link 1</a>
			<a href="#" class="w3-bar-item w3-button w3-padding-large">Link 2</a>
			<a href="#" class="w3-bar-item w3-button w3-padding-large">Link 3</a>
			<a href="#" class="w3-bar-item w3-button w3-padding-large">Link 4</a>
		</div>
	</div>

	<div>
	

	<div class="w3-row-padding  w3-padding-64 w3-container w3-white ">
		<div class="w3-content w3-amber w3-container w3-white">
			<div class="w3-twothird w3-white">
				<!-- <h2 class="">Details of Tenants in the selected Location </h2> -->
				<h4 class="tenant w3-row-padding w3-white">

					<div>
						<h3 class='w3-container  w3-center  w3-amber loc'>Quote Details
							</h3>
					</div>

					<div class="w3-container location ">

						<h3 class='w3-container  w3-center  w3-amber loc'>Details of the vehicle
							</h3>
						Vehicle : ${Vehicle.model} <br> Model Year : ${Vehicle.year}
						<br> Vin Number : ${Vehicle.vin_number}<br>

						<h3 class='w3-container  w3-center  w3-amber loc'>Details of the driver
							</h3>
						Name : ${Driver.name} <br> Age : ${Driver.age}<br>
						<br>

						<h1>Final Quote Amount : ${Amount}</h1>
					
					</div>
				</h4>

			</div>
		</div>
	</div>

	<div class="w3-container w3-center  w3-amber">
		<h1 class="w3-margin w3-xlarge ">Quote of the day: live life</h1>
	</div>

</body>
</html>