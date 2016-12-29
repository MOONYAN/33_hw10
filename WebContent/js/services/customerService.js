angular.module('iMovie').service('CustomerService', function ($http){
	var self = this;
    //
	// self.getMovies = function(onSuccess){
	// 	$http.get(contextPath + '/ws/movies/')
	// 	.success(function(data, status, headers, config) {
	// 		(onSuccess || angular.noop)(data);
	// 	})
	// 	.error(function(data, status, headers, config) {
	// 		alert("Error - Data:" + data + " status:" + status);
	// 	});
	// };

	self.getBookerTickets = function(onSuccess){
		$http.get(contextPath + '/ws/tickets/booker/')
		.success(function(data, status, headers, config) {
			(onSuccess || angular.noop)(data);
		})
		.error(function(data, status, headers, config) {
			alert("Error - Data:" + data + " status:" + status);
		});
	};
});
