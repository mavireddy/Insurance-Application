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

.w3-blue {
	background-color: #4e69a2, color:#4e69a2
}
</style>
<title>PSB Parks</title>

</head>
<%-- <body>

	<h1>Enter few more details to get your quote</h1>
	
	Welcome ${Name} <br>
	
	<br><form action="quote">
		Driver's License Number : <input type="text" id="license" placeholder="Enter license num" name="license"><br> <br>
		Total Tickets : <input type="text" id="tickets" placeholder="Enter num of tickets" name="ticket"> <br><br>
		<button type="submit" id="id_quoteBtn" class="w3-amber">Click to get the quote</button>
	</form><br>

</body>
</html> --%>

<body>

	<div class="w3-container  w3-center  w3-amber" style="padding: 40px 16px">
		<h1></h1>
	</div>

	<div class="w3-row-padding  w3-padding-64 w3-container w3-white ">
		<div class="w3-content w3-amber w3-container w3-white">
			<div class="w3-twothird w3-white">
				<!-- <h2 class="">Details of Tenants in the selected Location </h2> -->
				<h4 class="tenant w3-row-padding w3-white">

					<div>
						<h3 class='w3-container  w3-center  w3-amber loc'>Welcome
							${Name}</h3>
					</div>

					<div class="w3-container location ">

						<h1>Enter few more details to get your quote</h1>

						<%-- Welcome ${Name} <br> <br> --%>
						<form action="quote">
							Driver's License Number : <input type="text" id="license"
								placeholder="Enter license num" name="license"><br>
							<br> Total Tickets : <input type="text" id="tickets"
								placeholder="Enter num of tickets" name="ticket"> <br>
							<br>
							<button type="submit" id="id_quoteBtn" class="w3-amber">Click
								to get the quote</button>
						</form>
						
						<div>${Error}</div>
						<br>
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