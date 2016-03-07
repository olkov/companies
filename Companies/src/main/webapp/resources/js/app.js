var myCompany = myCompany || {};
myCompany.app = angular.module("myCompany", ["ngRoute", "upidamodule"]);

myCompany.app.config(function ($routeProvider) {
	$routeProvider
		.when("/", {
			templateUrl: "all",
			controller: "allController"
		})
		.when("/all", {
			templateUrl: "all",
			controller: "allController"
		})
		.when("/addCompany", {
			templateUrl: "addCompany",
			controller: "addController"
		})
		.when("/addChildCompany/:id", {
			templateUrl: "addChildCompany",
			controller: "addChildController"
		})
		.when("/company/:id", {
			templateUrl: "company",
			controller: "selectController"
		})
		.when("/removeCompany/:id", {
			templateUrl: "all",
			controller: "removeController"
		})
		.when("/updateCompany/:id", {
			templateUrl: "updateCompany",
			controller: "updateController"
		})
		.otherwise({
			templateUrl: "/Companies/notFound"
		});
});

$upida.settings.baseUrl = "/Companies/";