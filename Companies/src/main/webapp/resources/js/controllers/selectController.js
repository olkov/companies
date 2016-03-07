myCompany.app.controller(
	"selectController",
	["$scope", "$location", "$routeParams", "upida", function ($scope, $location, $routeParams, upida) {
		
	$scope.message;
	
	$scope.idCompany = $routeParams.id;
	$scope.companyName = null;
	$scope.estimatedEarnings = null;
	$scope.parentId = null;

	$scope.selectCompany = function () {
		upida.get("getbyid?id=" + $scope.idCompany)
		.then(function (item) {
			$scope.companyName = item.companyName;
			$scope.estimatedEarnings = item.estimatedEarnings;
			$scope.parentId = item.parentId;
			
			if(item.parentId == undefined){
				$scope.message = "This company is main.";
			} else {
				upida.get("getbyid?id=" + item.parentId)
				.then(function (item2) {
					$scope.message = "This company is child \"" + item2.companyName + "\" company.";
				});
			}
		});
	};

	$scope.$on('$routeChangeSuccess', function () {
		upida.setScope($scope);
		$scope.selectCompany();
	});
}]);
