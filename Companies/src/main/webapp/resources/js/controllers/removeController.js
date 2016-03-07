myCompany.app.controller(
	"removeController",
	["$scope", "$location", "$routeParams", "upida", function ($scope, $location, $routeParams, upida) {

	$scope.idCompany = $routeParams.id;
	
	$scope.removeCompany = function () {
		upida.get("removeCompany?id=" + $scope.idCompany)
		.then(function () {
			$location.path("all");
		});
	};

	$scope.$on('$routeChangeSuccess', function () {
		upida.setScope($scope);
		$scope.removeCompany();
	});
}]);
