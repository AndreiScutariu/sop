(function () {
	
	var dep = ["ngResource", "ngRoute", 'ui.grid'];
	var appModule = angular.module("app", dep);
	
	appModule.config(function ($routeProvider, $locationProvider) {
		$locationProvider.html5Mode(true);
		$routeProvider
        .when("/", { templateUrl: "partials/main", controller: "mainController" })
		.when("/roles", { templateUrl: "partials/roles", controller: "roleController" })
		.when("/users", { templateUrl: "partials/users", controller: "userListController" })
		.otherwise({ redirectTo: '/' });
	});
	
	appModule.controller("mainController", function ($scope) {
		$scope.myVar = "hello world";
	});

})();