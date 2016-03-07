myCompany.app.controller(
	"addController",
	["$scope", "$location", "upida", function ($scope, $location, upida) {
	
	$scope.companyName = null;
	$scope.estimatedEarnings = null;

	$scope.onSaveCompany = function () {
		var data = {};
		data.companyName = $scope.companyName;
		data.estimatedEarnings = $scope.estimatedEarnings;
		upida.post("saveCompany", data)
		.then(function () {
			$location.path("all");
		});
	};

	$scope.$on("$routeChangeSuccess", function () {
		upida.setScope($scope);
	});
}]);