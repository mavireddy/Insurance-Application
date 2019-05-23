<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
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
::placeholder {
	color: black;
	opacity: 1; /* Firefox */
}

.dropdown, body, h1, h2, h3, h4, h5, h6 {
	font-family: "Lato", sans-serif
}

.dropdown, .w3-bar, h1, button {
	font-family: "Montserrat", sans-serif
}

.w3-heading {
	font-color: white;
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

<title>Progressive</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>


<script>
  
  	$(document).ready(function(){
  		
  		$('#id_vhclMsg').hide();
  	
  		$('#id_driverMsg').hide();
  		
	  		$('#id_quoteBtn').hide();


  		
  		$("#id_addressBtn").click(function(){
  			var addressLine1=document.getElementById('address_line1').value;
  			var addressLine2=document.getElementById('address_line2').value;
  			var city=document.getElementById('city').valu b e;
  			var state=document.getElementById('state').value;
  			var zipcode=document.getElementById('zipcode').value;



 
  			var vehicleList = null;
  			$.ajax({
  				url : 'vehicles/'+addressLine1+'/'+addressLine2+'/'+city+'/'+state+'/'+zipcode,
  				//url :'vehicles',
  				type : 'get',
  				dataType : 'json',
  				async : false,
  				success : function(data){
  					vehicleJsonArray = data;  					
  				}
  			});
  			createVehicleCheckList(vehicleJsonArray);
  			
  			$('#id_vhclMsg').show();
  			
  	 	var driverList = null;
  			$.ajax({
  				url : 'drivers/'+addressLine1+'/'+addressLine2+'/'+city+'/'+state+'/'+zipcode,
  				//url :'vehicles',
  				type : 'get',
  				dataType : 'json',
  				async : false,
  				success : function(data){
  					driverJsonArray = data;  					
  				}
  			});
  			 
  			createDriverCheckList(driverJsonArray);

  	  		$('#id_driverMsg').show();
  	  		$('#id_quoteBtn').show();


  			return false;
  		});
  		
  	});
  	
  	function createVehicleCheckList(vehicleJsonArray){
  		//var vehicleArray =[];
  		$(id_vehicles).html("");
  		
  		$.each(vehicleJsonArray, function(index,vehicleObj){
  			var li;
  			$.each(vehicleObj,function(){
  				var vehicle ="Vin Number : " + vehicleObj.vin_number + "     " +"Model : "+ vehicleObj.model + " "+ "Year : " + vehicleObj.year;
  				li = $('<input type="radio"  value="'+vehicleObj.vehicle_id +'" name="vehicle">'+ vehicle +'<br>');
  				console.log(vehicle);
  				
  			});
  			$(id_vehicles).append(li);
  		});
  		
  	}
  		
  	 	function createDriverCheckList(driverJsonArray){
  	  		var driverArray =[];
  	  		$(id_drivers).html("");
  	  
  	  		$.each(driverJsonArray, function(index,driverObj){
  	  			var li;
  	  			$.each(driverObj,function(){
  	  				var driver ="Driver name : " + driverObj.name ;
  	  				li = $('<input type="radio"  value="'+driverObj.driver_id +'" name="driver">'+ driver +'<br>');
  	  				console.log(driver);
  	  				
  	  			});
  	  			$(id_drivers).append(li);
  	  		});
  	  		
  	  			}
  	  		 
  </script>

</head>


<body>
	<div class="w3-top">
		<div class="w3-bar w3-amber w3-card w3-left-align w3-large">
			<a
				class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-amber"
				href="javascript:void(0);" onclick="myFunction()"
				title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a> <a
				href="home" class="w3-bar-item w3-button w3-padding-large w3-white">Progressive</a>

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
		<header class="w3-container  w3-amber w3-border-pale-amber w3-center "
			style="padding: 70px 16px">
			<h1 class="w3-margin .w3-heading ">Enter Address Details to find
				your Quote</h1>
			<p class="w3-xlarge"></p>
			<!-- <button class="w3-button w3-black w3-padding-large w3-large w3-margin-top">Get Started</button> -->
	

			<div class="w3-heading">
				<form>

					<label for="Address">Address Details:</label><br>
					<br> <input type="text" id="address_line1"
						placeholder="Enter Address Line 1" name="address_line1"> <input
						type="text" id="address_line2" placeholder="Enter Address Line 2"
						name="address_line2"> <input type="text" id="city"
						placeholder="Enter City" name="city"> <input type="text"
						id="state" placeholder="Enter State" name="state"> <input
						type="text" id="zipcode" placeholder="Enter Zipcode"
						name="zipcode"><br>
					<br>

					<button type="submit" id="id_addressBtn" class="w3-amber">Click
						to get Vehicle details</button>

				</form>
				<br>
				
				<div><h4>If you already have a quote number..Enter your quote number below</h2>
				
				<form action="quotedetails">
				 <input type="text" id="quote_num"
						placeholder="Enter quote number" name="quote_num">
				
				<button type="submit" class="w3-amber">Click
						to get quote details</button>
						
						</form>
				
				 </div>

			</div>
			<form action="driverdetails">

			<div class="w3-center">
				<h4 id="id_vhclMsg">Vehicles at the specified address??</h4>
				<ul id="id_vehicles"></ul>
			</div>
			<br>

			<div class="w3-center">
				<h4 id="id_driverMsg">Drivers at the specified address??</h4>
				<ul id="id_drivers"></ul>
			</div>

			
				<button type="submit" id="id_quoteBtn" class="w3-amber">Click
					to get the quote</button>
			</form>
			
			<h4>${Error}</h4>
			<h4>${Warning}</h4>
	</div>


	</header>

	<!-- First Grid -->
	<div class="w3-row-padding w3-center w3-container"
		style="padding: 10px 5px">
		<div class="w3-content">
			<div class="w3-twothird">
				<h1>
					<br>Progressive is one of the best insurance companies</br>
				</h1>
				<h2></h2>
				<!--       <h5 class="w3-padding-32">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</h5>
 -->
				<p class="w3-text-grey">Over 18 million people trust Progressive
					to insure something they love such as their car, boat, house,
					motorcycle, etc. That's no surprise because we're the third largest
					auto insurer and the #1 motorcycle/specialty RV insurer</p>
			</div>

			<div class="w3-third w3-center">
				<i class="fa fa-anchor w3-padding-64 w3-text-amber"></i>
			</div>
		</div>
	</div>

	<!-- Second Grid -->
	<div class="w3-container w3-center  w3-amber "
		style="padding: 10px 16px">
		<h1 class="w3-margin w3-xlarge ">Quote of the day: Find your
			"Quote" Today</h1>
	</div>
	<!-- Footer -->
	<footer class="w3-container w3-padding-64 w3-center w3-opacity style="padding:10px 16px"">
		<div class="w3-xlarge w3-padding-32">
			<i class="fa fa-facebook-official w3-hover-opacity"></i> <i
				class="fa fa-instagram w3-hover-opacity"></i> <i
				class="fa fa-snapchat w3-hover-opacity"></i> <i
				class="fa fa-pinterest-p w3-hover-opacity"></i> <i
				class="fa fa-twitter w3-hover-opacity"></i> <i
				class="fa fa-linkedin w3-hover-opacity"></i>
		</div>
		<!--  <p>Poweamber by <a href="https://www.w3schools.com/w3css/default.asp" target="_blank">w3.css</a></p>
 -->
	</footer>

	<script>
			// Used to toggle the menu on small screens when clicking on the menu button
			function myFunction() {
				var x = document.getElementById("navDemo");
				if (x.className.indexOf("w3-show") == -1) {
					x.className += " w3-show";
				} else {
					x.className = x.className.replace(" w3-show", "");
				}
			}
		</script>
</body>
</html>



