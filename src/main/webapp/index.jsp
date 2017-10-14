<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<!doctype html>
<html ng-app="demo">
	<head>
	    <meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Hello AngularJS</title>
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
    	<script>
    	angular.module('demo', [])
    	.controller('Hello', function($scope, $http) {
    	    $http.get('http://localhost:6627/RentalAddaRest/customers.htm').
    	        then(function(response) {
    	            $scope.customer = response.data;
    	        });
    	});
    	</script>
    	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    	<style>
    	    h1{
    	       font-family:lato black;
    	    }
    	    p{
    	      font-family:lato;
    	      font-weight:bold;
    	    }
    	    html,body{
    	      height:100%;
    	    }
    	</style>
	</head>
	<body>
	<h1>RentalAdda Customer List <img src="resources/images/ConsoleRental.jpg" /></h1>
	<div class="panel panel-default">
		<div ng-controller="Hello" class="container-fluid panel-body">
		 <div class="row bg-primary">
			<div class="col-sm-2"><p>ID</p></div>
			<div class="col-sm-2"><p>First Name</p></div> 
			<div class="col-sm-2"><p>Last Name</p></div>
			<div class="col-sm-2"><p>Email</p></div> 
			<div class="col-sm-2"><p>Mobile</p></div>
			<div class="col-sm-2"><p>Date of Birth</p></div>
		</div>
		 <div class="row table-hover">
			<div class="col-sm-2"><p>{{customer.id}}</p></div>
			<div class="col-sm-2"><p>{{customer.firstName}}</p></div> 
			<div class="col-sm-2"><p>{{customer.lastName}}</p></div>
			<div class="col-sm-2"><p>{{customer.email}}</p></div>
			<div class="col-sm-2"><p>{{customer.mobile}}</p></div> 
			<div class="col-sm-2"><p>{{customer.dateOfBirth}}</p></div>
		</div>
		</div>
		<div class="footer navbar-fixed-bottom container text-center"><p>Copyright Rentaladda.in</p></div>
		</div>
	</body>
</html>