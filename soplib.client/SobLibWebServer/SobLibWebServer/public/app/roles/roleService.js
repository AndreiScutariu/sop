(function (module) {
	
	module.service('roleService', ["$http", "configurationService", function ($http, configurationService) {
			this.getAll = function (callback) {
				$http.get(configurationService.rolesEndpoint).then(callback);
			};
		}]);

})(angular.module('app'));