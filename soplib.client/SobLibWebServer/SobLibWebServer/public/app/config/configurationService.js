 (function (module) { 
	
	module.service('configurationService', function () {
		this.baseEnpoint = 'http://localhost:8080/soplib-restws/api/';
		this.rolesEndpoint = this.baseEnpoint + 'roles';
		this.usersEndpoint = this.baseEnpoint + 'users';
	});

})(angular.module('app'));