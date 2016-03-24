 (function (module) {

	module.service('configurationService', function () {
		this.baseEnpoint = 'http://localhost:8080';
		this.rolesEndpoint = this.baseEnpoint + '/soplib-restws/api/roles';
		this.usersEndpoint = this.baseEnpoint + '/soplib-restws/api/users';
		this.buildEndpoint = function (uri) {
			return this.baseEnpoint + uri;
		}
	});

})(angular.module('app'));
