(function (module) {

	var scopeModeBuilder = (function () {
		var obj = {};
		var scope;
	    var userService;
		var pubSub;

		obj.init = function (scopeParam, userServiceParam, pubSubParam) {
            scope = scopeParam;
		    userService = userServiceParam;
			pubSub = pubSubParam;

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
					scope.modalShown = false;
					pubSub.publish("newUserSaved", response.data);
                };
                userService.save(scope.user, callback);
		    };
		};

	    obj.buildRolesModel = function(response) {
	        scope.roles = response.data;
	    };

		return obj;
	})();

	module.controller("userDetailController", ["$scope", "userService", "roleService", "pubSub", function ($scope, userService, roleService, pubSub) {
            scopeModeBuilder.init($scope, userService, pubSub);
	        roleService.getAll(scopeModeBuilder.buildRolesModel);
	    }]);

})(angular.module('app'));
