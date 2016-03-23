(function (module) {
	
	var rolesCbk = function (response) {
		console.log(response);
	};

	module.controller("roleController", ["$scope", "roleService", function ($scope, roleService) {
			$scope.bookTemp = "roles temp";
			roleService.getAll(rolesCbk);
		}]);

})(angular.module('app'));