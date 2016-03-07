myCompany.app.controller(
	"updateController",
	["$scope", "$location", "$routeParams", "upida", function ($scope, $location, $routeParams, upida) {
	
	$scope.idCompany = $routeParams.id;
	$scope.name = null;
	$scope.companyName = null;
	$scope.estimatedEarnings = null;
	$scope.parentId = null;


	$scope.updateCompany = function () {
		var data = {};
		data.idCompany = $scope.idCompany;
		data.companyName = $scope.companyName;
		data.estimatedEarnings = $scope.estimatedEarnings;
		data.parentId = $scope.parentId;
		
		upida.post("saveCompany", data)
		.then(function () {
			$location.path("all");
		});
	};

	$scope.loadCompany = function () {
		upida.get("getbyid?id=" + $scope.idCompany)
		.then(function (item) {
			$scope.name = item.companyName;
			$scope.companyName = item.companyName;
			$scope.estimatedEarnings = item.estimatedEarnings;
			$scope.parentId = item.parentId;
		});
	};

	$scope.$on('$routeChangeSuccess', function () {
		upida.setScope($scope);
		$scope.loadCompany();
	});
}]);