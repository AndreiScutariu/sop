(function (module, $) {

	var scopeModelBuilder = (function () {
		var obj = {};
		var scope;
		var filter;
		var pubSub;
		var userService;

		obj.init = function (initialScope, filterParam, pubSubParam, userServiceParam) {
			scope = initialScope;
			filter = filterParam;
			pubSub = pubSubParam;
			userService = userServiceParam;

			scope.editUser = function(user) {
				pubSub.publish("editUserEvent", user);
			};

			scope.deleteUser = function(user) {
				pubSub.publish("deleteUserEvent", user);
			};
        };

        obj.callback = function (res) {
            scope.users = [];
            $.each(res.data, function(index, user) {
				scope.users.push(user);
            });
        };

		return obj;
	})();

	module.controller("userListController", ["$scope", "$filter", "userService", "pubSub", function ($scope, $filter, userService, pubSub) {
			var refreshGrid = function () {
				userService.getAll(scopeModelBuilder.callback);
			};
			scopeModelBuilder.init($scope, $filter, pubSub, userService);
			pubSub.subscribe("refreshGrid", refreshGrid);
			refreshGrid();
		}]);

})(angular.module('app'), jQuery);
