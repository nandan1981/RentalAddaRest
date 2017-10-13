<!doctype html>
<html ng-app="demo">
	<head>
		<title>Hello AngularJS</title>
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.3/angular.min.js"></script>
    	<script>
    	angular.module('demo', [])
    	.controller('Hello', function($scope, $http) {
    	    $http.get('http://localhost:6627/RentalAddaRest/customers.htm').
    	        then(function(response) {
    	            $scope.customer = response.data;
    	        });
    	});
    	</script>
	</head>

	<body>
		<div ng-controller="Hello">
			<p>The ID is {{customer.id}}</p>
			<p>The Name is {{customer.firstName}}</p>
		</div>
	</body>
</html>