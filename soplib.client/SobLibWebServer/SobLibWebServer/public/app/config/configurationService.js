(function (module) { 
	
	module.service('configurationService', function () {
		this.rolesEndpoint = 'http://localhost:8080/soplib-restws/api/roles';
	});

})(angular.module('app'));