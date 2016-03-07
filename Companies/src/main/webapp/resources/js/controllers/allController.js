myCompany.app.controller(
	"allController", ["$scope", "upida", function ($scope, upida) {

	$scope.treeCompanies = function () {
		upida.get("c")
		.then(function (item) {
			$(function(){ 
				$("#tree").dynatree({ 
					onActivate: function(node) { 
						if (node.data.href) 
							window.location.href = dtnode.data.href; 
					}, 
				children: item 
				});
			}); 
		});
	};

	$scope.$on("$routeChangeSuccess", function () {
		upida.setScope($scope);
		$scope.treeCompanies();
	});
}]);