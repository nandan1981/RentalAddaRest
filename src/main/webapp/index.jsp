<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<!doctype html>
<html ng-app="demo">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Hello AngularJS</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.6/angular.min.js"></script>
<link type="text/css" rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link type="text/css" rel="stylesheet"
	href="https://cdn.jsdelivr.net/qtip2/3.0.3/jquery.qtip.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/qtip2/3.0.3/jquery.qtip.min.js"></script>
<script>
	angular.module('demo', []).controller(
			'CustomerListController',
			function($scope, $http) {
				var customerList = this;
				//This gets the data from the restful web service which in turn fetches data via the DAO
				$http.get('http://localhost:6627/RentalAddaRest/customers.htm')
						.then(function(response) {
							customerList.customers = response.data;
						});
			});

	$('th').each(function() {
		$(this).qtip({ // Grab some elements to apply the tooltip to
			content : $(this).attr('tooltip'),
			position : {
				target : 'mouse',
				adjust : {
					mouse : true
				// Can be omitted (e.g. default behaviour)
				}
			},
			style : {
				classes : 'qtip-blue qtip-shadow qtip-dark qtip-rounded',
				widget : true
			},
			show : {
				delay : 100
			}
		});

	});
</script>
<style>
h1 {
	font-family: lato black;
}

p {
	font-family: lato;
	font-weight: bold;
}

html, body {
	height: 100%;
}

.col-sm-2 {
	display: inline;
}

.table tr>th {
	background-color: grey;
	color: white;
}
/* CSS2 styles */
qtip {
} /* This one is applied by default (formally the "cream" style) */
qtip-plain {
}

qtip-light {
}

qtip-dark {
}

qtip-red {
}

qtip-green {
}

qtip-blue {
}

/* CSS3+ styles */
qtip-shadow {
} /* Adds a shadows to your tooltips */
qtip-rounded {
	
} /* Adds a rounded corner to your tooltips */
qtip-bootstrap {
} /* Bootstrap style */
qtip-tipsy {
} /* Tipsy style */
qtip-youtube {
} /* Youtube style */
qtip-jtools {
} /* jTools tooltip style */
qtip-cluetip {
} /* ClueTip style */
qtip-tipped {
} /* Tipped style */
</style>
</head>
<body>
	<!-- <spring:url value="/resources/images" var="images" /> -->
	<h1>
		RentalAdda Customer List <img src="/images/logo.png" />
	</h1>
	<div class="form-group">
		<div class="col-md-6">
			<input type="text" [(ngModel)]="searchText" class="form-control"
				placeholder="Search By Category" />
		</div>
	</div>
	<div class="panel panel-default">
		<div ng-controller="CustomerListController as customerList"
			class="container-fluid panel-body">
			<table class="table table-responsive table-hover">
				<tr>
					<th class="col-sm-2" tooltip="ID"><p>ID</p></th>
					<th class="col-sm-2" tooltip="First Name"><p>First Name</p></th>
					<th class="col-sm-2" tooltip="Last Name"><p>Last Name</p></th>
					<th class="col-sm-2" tooltip="Email Id"><p>Email</p></th>
					<th class="col-sm-2" tooltip="Mobile"><p>Mobile</p></th>
					<th class="col-sm-2" tooltip="DOB"><p>Date of Enrollment</p></th>
				</tr>
				<tr ng-repeat="customer in customerList.customers">
					<td class="col-sm-2"><p>{{customer.id}}</p></td>
					<td class="col-sm-2"><p>{{customer.firstName}}</p></td>
					<td class="col-sm-2"><p>{{customer.lastName}}</p></td>
					<td class="col-sm-2"><p>{{customer.email}}</p></td>
					<td class="col-sm-2"><p>{{customer.mobile}}</p></td>
					<td class="col-sm-2"><p>{{customer.dateOfBirth}}</p></td>
				</tr>
			</table>
			<div class="footer navbar-fixed-bottom container text-center">
				<p>Copyright Rentaladda.in</p>
			</div>
		</div>
</body>
</html>