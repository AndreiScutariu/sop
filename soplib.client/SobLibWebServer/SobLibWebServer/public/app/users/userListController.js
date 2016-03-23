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
                scope.users.push({
                    name: user.name,
                    email: user.email,
                    description: user.description,
                    lastModifiedDate: user.lastModifiedDate
                });
            });
        };

		return obj;
	})();

	module.controller("userListController", ["$scope", "userService", function ($scope, userService) {
            scopeModelBuilder.init($scope);
			userService.getAll(scopeModelBuilder.callback);
		}]);

})(angular.module('app'), jQuery);