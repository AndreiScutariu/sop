(function (module) {
	
	var scopeModeBuilder = (function () {
		var obj = {};
		var scope;
	    var userService;

		obj.init = function (initialScope, uService) {
            scope = initialScope;
		    userService = uService;
            scope.modalShown = false;
            scope.user = {};

		    scope.addNewUser = function () {
		        scope.labels = {
                    frmTitle: "Add New User",
                    btnName: "Save"
		        };
		        scope.modalShown = true;
            };

            scope.saveUser = function () {
                var callback = function(response) {
                    console.log(response);
                };
                userService.save(scope.user, callback);
		    };
		};

	    obj.buildRolesModel = function(response) {
	        scope.roles = response.data;
	    };

		return obj;
	})();

	module.controller("userDetailController", ["$scope", "userService", "roleService", function ($scope, userService, roleService) {
            scopeModeBuilder.init($scope, userService);
	        roleService.getAll(scopeModeBuilder.buildRolesModel);
	    }]);

})(angular.module('app'));