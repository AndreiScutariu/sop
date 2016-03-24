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
				var uri = filter('filter')(user.links, {desc: "self"})[0];
				pubSub.publish("editUserEvent", uri);
			};

			scope.deleteUser = function(user) {
				var uri = filter('filter')(user.links, {desc: "self"})[0];
				pubSub.publish("deleteUserEvent", uri);
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
