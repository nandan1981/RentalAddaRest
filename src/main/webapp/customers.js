
	angular.module('demo', []).controller(
			'CustomerListController',
			function($scope, $http) {
				var customerList = this;
				//This gets the data from the restful web service which in turn fetches data via the DAO
				$http.get('http://localhost:8081/RentalAddaRest/customers.htm')
						.then(function(response) {
							customerList.customers = response.data;
						});
				
				var customerCount;
				//This gets the data from the restful web service which in turn fetches count via the DAO
				$http.get('http://localhost:8081/RentalAddaRest/customerCount.htm')
						.then(function(response) {
							customerCount = response.data;
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
