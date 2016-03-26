(function (module) {

	var scopeModelBuilder = (function () {
		var obj = {};
		var scope;
        var filter;
	    var userService;
		var pubSub;

		obj.init = function (scopeParam, filterParam, userServiceParam, pubSubParam) {
            scope = scopeParam;
		    userService = userServiceParam;
            filter = filterParam;
			pubSub = pubSubParam;

            scope.modalShown = false;
			scope.user = {};

		    scope.addNewUser = function () {
				scope.user = {};
		        scope.labels = { frmTitle: "Add New User", btnName: "Save" };
		        scope.modalShown = true;
				$.each(scope.roles, function(index, role) {
                    role.checked = false;
                });
            };

            scope.saveUser = function () {
				scope.user.roles = [];
				var roles = filter('filter')(scope.roles, {checked: true});
                $.each(roles, function(index, role) {
                    scope.user.roles.push( { id: role.id } );
                });

                var callback = function(response) {
					scope.modalShown = false;
					pubSub.publish("refreshGrid");
                };
                userService.save(scope.user, callback);
		    };
		};

	    obj.buildRolesModel = function(response) {
	        scope.roles = response.data;
	    };

		obj.whenUserDeleted = function (event, user) {
			var callback = function(response) {
				pubSub.publish("refreshGrid");
			};
			userService.deleteUser(user, callback);
		};

		obj.whenUserEdit = function (event, user) {
			scope.modalShown = true;
			scope.labels = { frmTitle: "Update User", btnName: "Update" };
			var callback = function(response) {
				scope.user = response.data;
				$.each(scope.roles, function(index, role) {
					var userRole = filter('filter')(scope.user.roles, {id: role.id})[0];
					if(userRole !== undefined)
						role.checked = true;
                });
				pubSub.publish("refreshGrid");
			};
			userService.getUser(user, callback);
		};

		return obj;
	})();

	module.controller("userDetailController", ["$scope", "$filter", "userService", "roleService", "pubSub", function ($scope, $filter, userService, roleService, pubSub) {
            scopeModelBuilder.init($scope, $filter, userService, pubSub);
	        roleService.getAll(scopeModelBuilder.buildRolesModel);
			pubSub.subscribe("editUserEvent", scopeModelBuilder.whenUserEdit);
			pubSub.subscribe("deleteUserEvent", scopeModelBuilder.whenUserDeleted);
	    }]);

})(angular.module('app'));
