(function (module, $) {

	var scopeModelBuilder = (function () {
		var obj = {};
		var scope;

		obj.init = function (initialScope) {
			scope = initialScope;
        };

        obj.callback = function (res) {
            scope.users = [];
            $.each(res.data, function(index, user) {
				addNewUser(user);
            });
        };

		function addNewUser(user) {
			scope.users.push({
				name: user.name,
				email: user.email,
				description: user.description,
				lastModifiedDate: user.lastModifiedDate
			});
		};

		obj.whenUserAdded = function (event, user) {
			addNewUser(user);
		};

		return obj;
	})();

	module.controller("userListController", ["$scope", "userService", "pubSub", function ($scope, userService, pubSub) {
            scopeModelBuilder.init($scope);
			pubSub.subscribe("newUserSaved", scopeModelBuilder.whenUserAdded);
			userService.getAll(scopeModelBuilder.callback);
		}]);

})(angular.module('app'), jQuery);
