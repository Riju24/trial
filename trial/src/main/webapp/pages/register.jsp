<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<div class="jumbotron">
		<h3>Registration Page</h3>
		<div class="col-lg-6 col-lg-offset-3 border">
			<form method="POST" action="/register">
				<div class="row">
					<div class="col">
						<div class="form-group">
							<label for=name">Name:</label> <input type="text" name="name"
								class="form-control" id="name" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col">
						<label for="company">Company Name:</label> <input type="text" name="company"
							class="form-control" id="company" />
					</div>
				</div>
				<div class="row">
					<div class="col">
						<label for="phnumber">Mobile Number:</label> <input type="text" name="mobile"
							class="form-control" id="phnumber" />
					</div>
				</div>
				</br>
				<div class="row pl-3">
					Select Gender: </br>
					<div class="form-check">
						<input class="form-check-input" type="radio" name="gender"
							id="Male" value="Male" /> <label for="gender">Male</label>
					</div>
					<div class="form-check">
						<input class="form-check-input" type="radio" name="gender"
							id="Female" value="Female" /> <label for="gender">Female</label>
					</div>
				</div>
				</br>
				<div class="row">
					<div class="col-4">
						<div class="form-group">
							<label for="country">Country</label> 
							<select id="country" name="country"
								class="form-control">
								<option selected>Choose...</option>
							</select>
						</div>
					</div>
					<div class="col-4">
						<div class="form-group">
							<label for="state">State</label> 
							<select id="state" name="state"
								class="form-control">
								<option selected>Choose...</option>
							</select>
						</div>
					</div>

					<div class="col-4">
						<div class="form-group">
							<label for="city">City</label> 
							<select id="city" name="city"
								class="form-control">
								<option selected>Choose...</option>
							</select>
						</div>
					</div>
				</div>
				<input type="submit" class="btn btn-success">Save</button>
			</form>
		</div>
	</div>
</body>
<script>
var countrystate = {
		"India": {"WB":["Kolkata","Howrah","Assansol"],"UP":["Meerut","Luckhnow"],"Maharastra":["Pune","Mumbai"]},
		"USA": {"Michigan":["Lansing"],"New York":["Albany"]},
		"France": {"Limousin":["Tulle"],"Bourgogne":["Auxerre"]}
}


window.onload =function(){
		var countrySel = document.getElementById("country");
		var stateSel = document.getElementById("state");
		var citySel = document.getElementById("city");

		for(var country in countrystate)
		{
			countrySel.options[countrySel.options.length] = new Option(country,country)

		}
		
		countrySel.onchange = function()
		{
			stateSel.length =1;
			citySel.length =1;

			if(this.selectIndex<1) return;
			for(var state in countrystate[this.value])
				{
					stateSel.options[stateSel.options.length] = new Option(state,state);
				}
		}
		

		stateSel.onchange = function()
		{
			citySel.length=1;
			if(this.selectedIndex<1) return;
			
			var c = countrystate[countrySel.value][this.value];
			for(var i =0;i < c.length;i++)
			{
				citySel.options[citySel.options.length] = new Option(c[i],c[i]);
			}
				
		}
		
		
}
</script>
</html>