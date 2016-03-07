myCompany.app.controller(
	"addChildController",
	["$scope", "$location", "$routeParams", "upida", function ($scope, $location, $routeParams, upida) {
	
	$scope.companyChildName = null;
		
	$scope.companyName = null;
	$scope.estimatedEarnings = null;
	$scope.parentId =  $routeParams.id;

	$scope.loadChildCompany = function () {
		upida.get("getbyid?id=" + $scope.parentId)
		.then(function (item) {
			$scope.companyChildName = item.companyName;
		});
	};
	
	$scope.onSaveChildCompany = function () {
		var data = {};
		data.companyName = $scope.companyName;
		data.estimatedEarnings = $scope.estimatedEarnings;
		data.parentId = $scope.parentId;
		
		upida.post("saveCompany", data)
		.then(function () {
			$location.path("company/" + $scope.parentId);
		});
	};

	$scope.$on("$routeChangeSuccess", function () {
		upida.setScope($scope);
		$scope.loadChildCompany();
	});
}]);